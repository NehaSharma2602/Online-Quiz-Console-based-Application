package model.entity;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String createdAt;
	
	public User() {
		super();
	}

	public User(String name, String email, String password, String createdAt) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}

	public User(Integer id, String name, String email, String password, String createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", createdAt="
				+ createdAt + "]";
	}
	
	


}
