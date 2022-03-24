package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private int userSeq;
	private String userName;
	private String userEmail;
	public UserDto(int userSeq, String userName, String userEmail) {
		super();
		this.userSeq = userSeq;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	public UserDto() {
		super();
	}
	
}