package design.methodchain;

public class Calculator {
	
//	메서드 체인 방식을 사용하기 위해서는 setter에서 자기 자신을 리턴해줌
	private int first;
	private int second;
	
	
//	***** Getter, Setter *****
	public int getFirst() {
		return first;
	}
	public Calculator setFirst(int first) {
		this.first = first;
		return this;
	}
	public int getSecond() {
		return second;
	}
	public Calculator setSecond(int second) {
		this.second = second;
		return this;
	}
	
	public Calculator showAdd() {
		System.out.println(this.first + this.second);
		return this;
	}
	public Calculator showSub() {
		System.out.println(this.first - this.second);
		return this;
	}
}
