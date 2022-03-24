package oop.inter;

public class Airplane extends Transportation implements Fly{

	@Override
	public void howToFly() {
		System.out.println("By Engine!!");
	}

	@Override
	public void howFastFly() {
		System.out.println("500km/h");
	}
	
}
