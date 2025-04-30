package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import vo.PostVo;

public class MainAarryList {

	public static void main(String[] args) {
		// 컬렉션 프레임워크 Collection Framework
		// 자바에서 데이터를 저장하고 관리하는 방법을 제공하는 클래스, 인터페이스의 집합
		
		// 핵심 
		// 데이터 구조 : 데이터르 어떻게 저장하고 접근할건가의 구조 정의
		// 효율적 관리 : 데이터를 쉽게 추가, 삭제, 변경, 순회하는 작업을 효율적으로 할수있게
		
		// 컬레션 프레임워크 : 컬렉션, 맵 두가지로 나뉜다
		// 1, 컬렉션 : 여러게의 데이터를 하나의 객체로 다루는 방법을 제공
		// 2, 맵 : (key) 와 값 (value) 쌍으로 이루어진 데이터 구조이고 중복되지 않는 키를 사용헤서 값을 찿을수 있다.
		PostVo
		
		String[] num = new String[] {"7777","4444","5555"};
		List<String> num2 = new ArrayList<String>(Arrays.asList(num));
		// 오름차순 정리
		num2.sort(Comparator.naturalOrder());
		System.out.println(num2);
		
		// 내림차순 정리
		num2.sort(Comparator.reverseOrder());
		System.out.println(num2);
		
		// add 컬렉션에 데이터를 추가한다
		num2.add("444");
		System.out.println(num2);
		
		// size() 객수확인
		System.out.println(num2.size());
		
		// Interator
		
		
		// remove 제거 ("값을찿아 지우거나" 배열의 index를 받아 지울수있음)
		num2.remove("444");
		num2.remove(0);
		System.out.println(num2);
		
		// clear() 배열 값 제거
		num2.clear();
		System.out.println(num2);
		}
	}


