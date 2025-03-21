package main;

// 아메리카노, 아이스 아메리카노, 카페라떼
enum CoffeeType {
	AMERICANO,
	ICE_AMERICANO,
	CAFE_LATTE
}

public class FinalEnum {

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 상수 집합 : eNum
		System.out.println(CoffeeType.AMERICANO);
		System.out.println(CoffeeType.CAFE_LATTE);
		System.out.println(CoffeeType.values());
		
		for(CoffeeType type : CoffeeType.values()) {
			System.out.println(type);
		}
		
	}

}
