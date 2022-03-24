
public class triangletest {
	
	static double degrees[] = {0.0, 30.0, 45.0, 60.0, 90.0};
	public static void main(String[] args) {
		for(int i = 0; i<5; i++) {
			System.out.println("Sin " + degrees[i] + "도: " + Math.sin(Math.toRadians(degrees[i])));
		}
		for(int i = 0; i<5; i++) {
			System.out.println("Cos " + degrees[i] + "도: " + Math.cos(Math.toRadians(degrees[i])));
		}
		for(int i = 0; i<5; i++) {
			System.out.println("Tan " + degrees[i] + "도: " + Math.tan(Math.toRadians(degrees[i])));
		}
		
	} 
	
	
	static double getAngle(Point p1, Point p2) {
		double dy = p2.y-p1.y;
		double dx = p2.x-p1.x;
		
		return Math.atan2(dy, dx) * (180.0 / Math.PI);
	}
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
