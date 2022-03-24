package dto;


public class UserDto {
	private int NO;
	private String userId;
	private String password;
	private String email;
	private String name;
	private int age;
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public UserDto(String userId, String password, String email, String name, int age) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.name = name;
		this.age = age;
	}
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [NO=" + NO + ", userId=" + userId + ", password=" + password + ", email=" + email + ", name="
				+ name + ", age=" + age + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

