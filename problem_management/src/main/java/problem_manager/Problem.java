package problem_manager;

public class Problem {
	private int id;
	private int userId;
	private String username;
	private String title;
	private String description;
	private String createAt;

	public Problem(int id, int userId, String username, String title, String description, String createAt) {
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.title = title;
		this.description = description;
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return String.format("[%d] %s (by %s) - Created: %s\n    > %s",
				this.id, this.title, this.username, this.createAt.substring(0, 10), this.description);
	}

	public int getId() { return id; }
	public int getUserId() { return userId; }
	public String getUsername() { return username; }
	public String getTitle() { return title; }
	public String getDescription() { return description; }
	public String getCreateAt() { return createAt; }
}
