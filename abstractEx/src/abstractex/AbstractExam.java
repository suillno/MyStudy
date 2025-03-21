package abstractex;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.SwingPropertyChangeSupport;

class Calculator {
	
	// public 어디서든 접근
	// private 같은 클래스 내부
	// protected 상속 받는 클래스 및 같은 패키지 내 클래스들만
	
	protected int value;
	Calculator() {
		this.value = 0;
	}
	void add(int val) {
		this.value += val;
	}
	int getValue() {
		return this.value;
	}
	public boolean isOdd(int i) {
		
		
		return i % 2 == 1 ? true : false;
	}
	public int avg(int[] data1) {
		int num = 0;
		for(int i = 0; i < data1.length; i++) {
			num += data1[i];
		}
		return num / data1.length;
	}
	
	public int avg(ArrayList<Integer> data2) {
		int num = 0;
		for(int item : data2) { // data2의 배열을 가져와 item이란 변수에 담는다
			num += item;
		}

		return num /= data2.size();
	}
	
}
	
class UpgradeCalculator extends Calculator{
	
	void minus(int val) {
		this.value -= val;
	}
	
}

class MAxLimitCalculator extends Calculator{
	
	void add(int val) {
		this.value += val;
		if(this.value > 100) {
			this.value = 100;
		}
	}
	
}



public class AbstractExam {
	public static void main(String[] args) {

		Calculator cal = new Calculator();
		
		cal.add(10);
		System.out.println(cal.getValue());
		
		UpgradeCalculator ucal = new UpgradeCalculator();
		ucal.add(10);
		ucal.minus(3);
		System.out.println(ucal.getValue()); // 7
		
		System.out.println(cal.isOdd(3)); // true
		System.out.println(cal.isOdd(4));
		
		// 객체 변수 value가 100보다 큰 값을 가질수 없도록 제한하는 동작
		MAxLimitCalculator macal = new MAxLimitCalculator();
		macal.add(50);
		macal.add(60);
		System.out.println(macal.getValue());
		
		// 배열로 받는 파라미커의 평균을 정수 리턴
		int[] data1 = {1,3,5,7,9};
		int result1 = cal.avg(data1);
		System.out.println(result1);
		
		
		
		ArrayList<Integer> data2 = new ArrayList<>(Arrays.asList(1,3,5,7,9));
		int result2 = cal.avg(data2);
		System.out.println(result2);
		
		
		
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<Integer> b = new ArrayList<Integer>(a);
		
		a.add(4);
		
		System.out.println(a == b);
		System.out.println(a);
		System.err.println(b);
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		
	}

}