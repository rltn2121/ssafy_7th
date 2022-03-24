package java7.objects;

import java.util.Objects;

public class B extends A{
	int n = 10;

	@Override
	public String toString() {
		return super.toString() + "B [n=" + n + "]";
	}
	
	
	public int hashCode() {
		// 멤버 변수만 전달하면 해시 값 자동적으로 리턴
		return Objects.hash(super.str, this.n);
	}
}
