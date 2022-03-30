package servlet.datagokr;

public class HouseDeal {
	
	/*법정동읍면동코드 */
	private int code;

	/*법정동 */
	private String dong;

	/*아파트 이름 */
	private String aptName;

	/**거래 금액 */
	private String dealAmount;
	public HouseDeal() {
		super();
	}

	
	public HouseDeal(int code, String dong, String aptName, String dealAmount) {
		super();
		this.code = code;
		this.dong = dong;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
	}


	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	

	
}




