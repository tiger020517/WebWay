package problem_manager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProblemCRUD implements IProblemCRUD{
	private Connection conn;

	public ProblemCRUD() { this.conn = DatabaseManager.getConnection(); }

	@Override
	public int addProblem(Problem problem) {
		String sql = "INSERT INTO Problems (user_id, username, title, description, create_at) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setInt(1, problem.getUserId());
			pstmt.setString(2, problem.getUsername());
			pstmt.setString(3, problem.getTitle());
			pstmt.setString(4, problem.getDescription());
			pstmt.setString(5, problem.getCreateAt());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("추가 오류: " + e.getMessage());
			return 0;
		}
	}
	@Override
	public ArrayList<Problem> listAllProblems() {
		ArrayList<Problem> list = new ArrayList<>();
		String sql = "SELECT * FROM Problems ORDER BY id DESC";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				list.add(new Problem(
						rs.getInt("id"),
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getString("create_at")
				));
			}
		} catch (SQLException e) {
			System.err.println("목록 조회 오류: " + e.getMessage());
		}
		return list;
	}

	@Override
	public int updateProblem(Problem problem) {
		String sql = "UPDATE Problems SET title = ?, description = ? WHERE id = ?";
		try (PreparedStatement ptsmt = conn.prepareStatement(sql)) {
			ptsmt.setString(1, problem.getTitle());
			ptsmt.setString(2, problem.getDescription());
			ptsmt.setInt(3, problem.getId());
			return ptsmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("수정 오류: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int deleteProblem(int id) {
		String sql = "DELETE FROM Problems WHERE id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("삭제 오류: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public ArrayList<Problem> searchByTitle(String keyword) {
		ArrayList<Problem> list = new ArrayList<>();
		String sql = "SELECT * FROM Problems WHERE title LIKE ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Problem(
						rs.getInt("id"),
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getString("create_at")
				));
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("제목 검색 오류: " + e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Problem> searchByUsername(String username) {
		ArrayList<Problem> list = new ArrayList<>();
		String sql = "SELECT * FROM Problems WHERE username = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Problem(
						rs.getInt("id"),
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getString("create_at")
				));
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("작성자 검색 오류: " + e.getMessage());
		}
		return list;
	}

	@Override
	public void saveToFile() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
		String filename = "data_" + now.format(formatter) + ".txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			ArrayList<Problem> list = listAllProblems();
			if (list.isEmpty()) {
				System.out.println("저장할 데이터가 없습니다.");
				return;
			}

			for (Problem p : list) {
				writer.println(
						p.getId() + "|" +
								p.getUserId() + "|" +
								p.getUsername() + "|" +
								p.getTitle() + "|" +
								p.getDescription().replace("\n", " ") + "|" + // 개행 문자 제거
								p.getCreateAt()
				);
			}
			System.out.println("데이터가 " + filename + " 파일로 성공적으로 저장되었습니다.");

		} catch (IOException e) {
			System.err.println("파일 저장 오류: " + e.getMessage());
		}
	}
}
