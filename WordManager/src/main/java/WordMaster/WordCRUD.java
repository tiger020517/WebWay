package WordMaster;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
	private ArrayList<Word> words;
	Scanner scanner;
	int id;
	final String fname = "Dictionary.txt";
	public WordCRUD() {
		words = new ArrayList<>(); scanner = new Scanner(System.in);
		id = 0;
	}

	public void createWord()
	{
		System.out.print("Enter new word: ");
		String newWord = scanner.nextLine();
		System.out.print("Enter meaning: ");
		String newMeaning = scanner.nextLine();
		System.out.print("Enter level (1~3): ");
		int level = scanner.nextInt();
		scanner.nextLine();
		words.add(new Word(id++, newWord, newMeaning, level));
		System.out.println("Word added!");
	}

	public void readWord()
	{
		for (Word word : words)
			System.out.println(word.toString());
		System.out.println(words.size() + " words added!");
	}

	public void readWord(int Level)
	{
		int index = 0;
		for (Word word : words)
		{
			if (word.getLevel() == Level)
			{
				System.out.println(word.toString());
				index++;
			}
		}
		System.out.println(index + " words found!");
	}

	public void readWord(String Word)
	{
		int index = 0;
		for (Word word : words)
		{
			if (word.getWord().toLowerCase().contains(Word.toLowerCase()))
			{
				System.out.println(word.toString());
				index++;
			}
		}
		System.out.println(index + " words found!");
	}

	public void updateWord()
	{
		System.out.print("Which word would you like to update?: ");
		String forChange = scanner.nextLine();
		for(Word word : words)
		{
			if (word.getWord().equals(forChange))
			{
				System.out.print("What do you want to update? 1.word 2.meaning 3.level: ");
				int changeMenu = scanner.nextInt();
				scanner.nextLine();
				if (changeMenu == 1)
				{
					System.out.print("Enter new word: ");
					String newWord = scanner.nextLine();
					word.setWord(newWord);
				}
				else if (changeMenu == 2)
				{
					System.out.print("Enter new meaning: ");
					String newMeaning = scanner.nextLine();
					word.setMeaning(newMeaning);
				}
				else if (changeMenu == 3)
				{
					System.out.print("Enter new level(1~3): ");
					int level = scanner.nextInt();
					scanner.nextLine();
					if (level < 1 || level > 3) { System.out.println("Invalid level!"); }
					else { word.setLevel(level); }
				}
				else { System.out.println("Invalid choice!"); }
				return ;
			}
		}
		System.out.println("No such word exists!");
	}

	public void deleteWord()
	{
		boolean found = false;
		System.out.print("Which word would you like to update?: ");
		String forDelete = scanner.nextLine();
		found = words.removeIf(word -> word.getWord().toLowerCase().equals(forDelete.toLowerCase()));
		if (found)
			System.out.println("Word deleted!");
		else
			System.out.println("No such word exists!");
	}

	public Word getWord()
	{
		return new Word(1, "", "", 0);
	}

	public void loadFile() {
		int index = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;

			while (true)
			{
				line = br.readLine();
				if (line == null) break ;
				String[] data = line.split("\\|");
				int level = Integer.parseInt(data[0]);
				String word = data[1];
				String meaning = data[2];
				words.add(new Word(id++, word, meaning, level));
				index++;
			}
			br.close();
			System.out.println(index + " Words loaded!");
		}
		catch (IOException e) { e.printStackTrace(); }
	}

	public void saveFile() {
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("test.txt"));

			for (Word word : words) {
				pr.write(word.Level + "|" + word.word + "|" + word.meaning + "\n");
			}
			pr.close();
			System.out.println("===> 데이터 저장 완료");
		} catch (IOException e) { e.printStackTrace(); }
	}
}
