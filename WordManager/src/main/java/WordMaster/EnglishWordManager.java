package WordMaster;

import java.util.Scanner;

public class EnglishWordManager {
	Scanner sc;
	String menus =	"1. List 2. List(level) 3. Search\n" +
			"4. Add 5. Modify 6. Delete\n" +
			"7. Save file 0. Exit";
	WordCRUD wordManager;

	EnglishWordManager() {
		sc = new Scanner(System.in);
		wordManager = new WordCRUD();
	}

	public void start() {
		int loop;

		System.out.println("welcome!");
		wordManager.loadFile();
		while(true) {
			System.out.println(menus);
			System.out.print("Enter your select: ");
			loop = sc.nextInt();
			sc.nextLine();
			switch (loop) {
				case 0:
					System.out.println("Goodbye!");
					return ;
				case 1:
					wordManager.readWord();
					break ;
				case 2:
					System.out.print("Enter level: ");
					int level = sc.nextInt();
					sc.nextLine();
					if (level < 1 || level > 3)
					{
						System.out.println("Invalid level");
					}
					else
					{
						wordManager.readWord(level);
					}
					break ;
				case 3:
					System.out.print("Enter word to search: ");
					String word = sc.nextLine();
					wordManager.readWord(word);
					break ;
				case 4:
					wordManager.createWord();
					break ;
				case 5:
					wordManager.updateWord();
					break ;
				case 6:
					wordManager.deleteWord();
					break ;
				case 7:
					wordManager.saveFile();
					break ;
				default:
					break ;
			}
		}
	}
}
