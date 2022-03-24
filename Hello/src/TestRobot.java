import robot.Robot4;

public class TestRobot {

	public static void main(String[] args) {
		Robot1 one = new Robot1();	
		one.move();
		
		Robot2 two = new Robot2();
		two.move();
		two.setName("ssafy");
		two.setLevel(5);
		two.move();
		
		Robot3 three = new Robot3();
		three.move();
		three.setName("ssafy");
		three.setLevel(15);
		three.move();
		
		System.out.println(three);
		
		Robot4 four = new Robot4();
	}
}
