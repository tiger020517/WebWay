package problem_manager;

public class Main {
	public static void main (String[] args)
	{
		System.out.println("데이터베이스 연결을 시도합니다...");

		new ProblemManager().run();
	}
}
