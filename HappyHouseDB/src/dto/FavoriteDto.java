package dto;


public class FavoriteDto {
	private int NO;
	private String userId;
	private String dongCode;
	private int flag;
	public FavoriteDto(String userId, String dongCode, int flag) {

		this.userId = userId;
		this.dongCode = dongCode;
		this.flag = flag;
	}
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
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Favorite [NO=" + NO + ", userId=" + userId + ", dongCode=" + dongCode + ", flag=" + flag + "]";
	}
	public FavoriteDto() {
	}

}
