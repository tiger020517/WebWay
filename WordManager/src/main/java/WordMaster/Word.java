package WordMaster;

public class Word {
	int id;
	String word;
	String meaning;
	int Level;

	Word(int id, String word, String meaning, int level) {
		this.id = id;
		this.word = word;
		this.meaning = meaning;
		this.Level = level;
	}

	String getWord() {
		return word;
	}
	String getMeaning() {
		return meaning;
	}
	int getLevel() {
		return Level;
	}
	void setLevel(int level) {
		this.Level = level;
	}
	void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "[lv" + Level + "] " + word + " : " + meaning;
	}
}
