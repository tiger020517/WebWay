package problem_manager;

import java.util.ArrayList;

public interface IProblemCRUD {
	public int addProblem(Problem p);
	public ArrayList<Problem> listAllProblems();
	public int updateProblem(Problem p);
	public int deleteProblem(int id);
	public ArrayList<Problem> searchByTitle(String keyword);
	public ArrayList<Problem> searchByUsername(String username);
	public void saveToFile();
}
