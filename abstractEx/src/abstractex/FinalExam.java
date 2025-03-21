package abstractex;

class AAAAAA {
	final double PI = 3.14; // 상수
}

interface Constans { // 상수
	String API_KEY = "1234";
}

public class FinalExam {

	public static void main(String[] args) {
		
		String key = Constans.API_KEY; // interface를 활용해 상수처럭 사용
		
	}

}
