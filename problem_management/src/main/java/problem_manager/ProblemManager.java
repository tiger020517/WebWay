package problem_manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemManager {

	private final IProblemCRUD problemCRUD;
	private final Scanner scanner;

	public ProblemManager() {
		this.problemCRUD = new ProblemCRUD();
		this.scanner = new Scanner(System.in);
	}

	public void run() {
		while (true) {
			printMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					listProblems(problemCRUD.listAllProblems());
					break;
				case 2:
					System.out.print("검색할 사용자명 입력: ");
					String user = scanner.nextLine();
					listProblems(problemCRUD.searchByUsername(user));
					break;
				case 3:
					System.out.print("검색할 제목 키워드 입력: ");
					String keyword = scanner.nextLine();
					listProblems(problemCRUD.searchByTitle(keyword));
					break;
				case 4:
					addProblemMenu();
					break;
				case 5:
					modifyProblemMenu();
					break;
				case 6:
					deleteProblemMenu();
					break;
				case 7:
					problemCRUD.saveToFile();
					break;
				case 0: // Exit
					System.out.println("프로그램을 종료합니다.");
					scanner.close();
					return;
				default:
					System.out.println("잘못된 입력입니다. 0-7 사이의 숫자를 입력하세요.");
			}
		}
	}


	private void printMenu() {
		System.out.println("\n===== 문제 관리 프로그램 =====");
		System.out.println("1. 전체 문제 목록 (List)");
		System.out.println("2. 사용자별 문제 목록 (List by User)");
		System.out.println("3. 제목 검색 (Search)");
		System.out.println("4. 문제 추가 (Add)");
		System.out.println("5. 문제 수정 (Modify)");
		System.out.println("6. 문제 삭제 (Delete)");
		System.out.println("7. 파일로 저장 (Save file)");
		System.out.println("0. 종료 (Exit)");
		System.out.print("원하는 메뉴를 선택하세요: ");
	}

	private void listProblems(ArrayList<Problem> list) {
		if (list.isEmpty()) {
			System.out.println("표시할 데이터가 없습니다.");
			return;
		}
		System.out.println("----- 총 " + list.size() + "개의 문제 -----");
		for (Problem p : list) {
			System.out.println(p.toString());
		}
		System.out.println("---------------------------");
	}

	private void addProblemMenu() {
		System.out.print("UserID (숫자): ");
		int userId = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Username (기본: anonymous): ");
		String username = scanner.nextLine();
		if (username.isEmpty()) username = "anonymous";
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("상세 설명: ");
		String desc = scanner.nextLine();

		String createAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		Problem p = new Problem(0, userId, username, title, desc, createAt);

		int result = problemCRUD.addProblem(p);

		if (result > 0) System.out.println("성공적으로 추가되었습니다.");
		else System.out.println("추가에 실패했습니다.");
	}

	private void modifyProblemMenu() {
		System.out.print("수정할 문제의 ID를 입력하세요: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("새 제목: ");
		String title = scanner.nextLine();
		System.out.print("새 상세 설명: ");
		String desc = scanner.nextLine();

		Problem p = new Problem(id, 0, null, title, desc, null);

		int result = problemCRUD.updateProblem(p);

		if (result > 0) System.out.println("성공적으로 수정되었습니다.");
		else System.out.println("수정에 실패했습니다 (ID를 확인하세요).");
	}

	private void deleteProblemMenu() {
		System.out.print("삭제할 문제의 ID를 입력하세요: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("정말로 삭제하시겠습니까? (y/n): ");
		String confirm = scanner.nextLine();

		if (confirm.equalsIgnoreCase("y")) {
			int result = problemCRUD.deleteProblem(id);

			if (result > 0) System.out.println("성공적으로 삭제되었습니다.");
			else System.out.println("삭제에 실패했습니다 (ID를 확인하세요).");
		} else {
			System.out.println("삭제가 취소되었습니다.");
		}
	}
}