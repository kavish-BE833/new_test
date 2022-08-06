package WebServices.user;

public class Post {

	private int id;
	private String description;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
