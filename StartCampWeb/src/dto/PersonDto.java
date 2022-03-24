package dto;

public class PersonDto {
	private int personId;
	private String personNm;
	private int personAge;
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonNm() {
		return personNm;
	}
	public void setPersonNm(String personNm) {
		this.personNm = personNm;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	@Override
	public String toString() {
		return "PersonDto [personId=" + personId + ", personNm=" + personNm + ", personAge=" + personAge + "]";
	}
	
}
