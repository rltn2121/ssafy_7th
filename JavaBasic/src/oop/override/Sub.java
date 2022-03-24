package oop.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Sub extends Super{
	
	@Override
	int m() {
		System.out.println("Sub - m()");
		return 1;
	}
	
	C m2() {
		System.out.println("Sub - m2()");
		return new C();
	}
	
//	 접근 제한자가 부모보다 좁으면 안됨
//	-	부모가 protected이면 자식은 protected, public 둘 중 하나
//	-	부모가 default이면 자식은 default, protected, public 셋 중 하나
	protected void m3() {
		System.out.println();
	}
	
//	 throws가 부모보다 넓으면 안됨 (더 구체적이어야 함)
//	 Exception -> IOException -> FileNotFoundException
//	-	부모가 Exception이면 자식은 Exception, IOException, FileNotFoundException
//	-	부모가 IOException이면 자식은 IOException, FileNotFoundException
	void m4() throws FileNotFoundException {
		System.out.println("Super - m4()");
	}
}
