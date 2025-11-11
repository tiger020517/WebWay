import java.util.Scanner;

public class EnglishWordManager {
	Scanner sc;
	String menus =	"1. List 2. List(level) 3. Search\n" +
					"4. Add 5. Modify 6. Delete\n" +
					"7. Save file 0. Exit";

	EnglishWordManager() {
		sc = new Scanner(System.in);
	}

	public void start() {
		int loop = 10;

		System.out.println("welcome!");
		while(loop != 0) {
			System.out.println(menus);
			System.out.println("Enter your select: ");
			loop = sc.nextInt();
			switch (loop) {
				case 1:
					break ;
				case 2:
					break ;
				case 3:
					break ;
				case 4:
					break ;
				case 5:
					break ;
				case 6:
					break ;
				case 7:
					break ;
				default:
					break ;
			}
		}
	}
}
