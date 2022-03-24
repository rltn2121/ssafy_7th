package java8.functionalInterface;


// 메서드를 하나만 가지면 functional interface라고 함
// 특정 기능 하나만 가짐
@FunctionalInterface
public interface MyFuncIF {
	int proc1(int n1, int n2);
	
	// 다른 메서드 추가하려면 default method로 만들어야 함
	default int proc2(int n1, int n2) {
		return n1 - n2;
	}
}
