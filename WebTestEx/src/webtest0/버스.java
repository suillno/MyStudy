package webtest0;

public class 버스 {

	public static void main(String[] args) {
		
		String[][] passengers = {
				{"on","on","on"},
				{"Off", "On", "-"},
				{"Off", "-", "-"}
		};
		int seat = 5;
		
		
		int func = 1;
		int func2 = 0;
		int num_passenger = 0;
		for (int i = 0; i < passengers.length; i++) {
			for(int j = 0; j < passengers[i].length; j++) {
			if(passengers[i][j].equalsIgnoreCase("on")) {
			num_passenger += func;
			System.out.println(num_passenger);
			}
			else if(passengers[i][j].equalsIgnoreCase("off")) {
			num_passenger -= func;
			System.out.println(num_passenger);
			}
			}
		}
		func2 = seat - num_passenger;
		int answer = func2;
		System.out.println(answer);
	}
}
