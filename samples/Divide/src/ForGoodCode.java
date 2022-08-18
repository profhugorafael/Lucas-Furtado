public class ForGoodCode {

	public static int divide(int x, int y) {
		int result = 0;

		while (x >= y) {
			System.out.println("X = " + x + " | y = " + y + " | result = " + result);
			x = x - y;
			result++;
		}
		
		System.out.println("resto = " + x);
		
		return result;
	}
	
	// D = d*q + r
	// 15 = 3*4 + 3
	// 18 - 4 = 14
	// 14 - 4 = 10
	// 10 - 4 = 6
	// 6 - 4 = 2
	// 2 - 4
	
	// 16 = 4*4 + 2

	public static void main(String[] args) {

		divide(18, 4);
		
	}

}