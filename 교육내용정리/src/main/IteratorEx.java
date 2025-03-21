package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import vo.Calc;
import vo.Student;


public class IteratorEx {

	public static void main(String[] args) {
		
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 85));
		students.add(new Student("홍길순", 40));
		students.add(new Student("이순신", 60));
		students.add(new Student("강감찬", 30));
		students.add(new Student("전현무", 45));
		
		System.out.println(students);
		
		Iterator<Student> s1 = students.iterator();
		while(s1.hasNext()) {
			Student s = s1.next();
			if(s.getScore() < 50) {
				s.setScore(90);;
			}
		}
		System.out.println(students);
		
		
		// 점수가 50 이하인 학생들을 삭제하는 매서드를 만들어서 호출

		// Iterator >> 향상된 for문과 동일함
		// 컬랙션 객체에서 요소를 순차적으로 접근하고 저거하는 방법을 제공하는 인터페이스이다
		// 컬랙션 내부 구조에 의존하지 않고도 요소를 순차적으로 탐색 가능

		// 메서드
		// hasNext() : 다음 요소가 있는지 확인후 true, false
		// next() : 컬랙션에서 다음 요소를 반환하고, 그 다음 요소로 이동한다
		// remove() : 요소 삭제 (next()로 반환한 요소를 컬렉션에서 제거)

		// 리스트 생성
		List<String> strList = new ArrayList<>(Arrays.asList("apple", "banana"));

		// Iterator 객체 생성 (자료형을 Iterator 형태로 변환)
		Iterator<String> iterator = strList.iterator();

		// Iterator을 사용 요소 출력
		while (iterator.hasNext()) {
			String item = iterator.next();
			if(item.equals("apple")) {
				iterator.remove();
			}
		}
		System.out.println(strList);

		//특징
		/**
		 * 컬랙션 변경 : Iterator 컬랙션을 순회하는 동안 안전하게 요소를 제거할수있다
		 * next() => remove()제거
		 * for loop 차이 : 순회 방식과 컬랙션 변경시 더 안전하다 (배열순회중 배열의 길이가 변경되어버리면 오류가 발생할수있음)
		 * for : index 기반 / index를 사용해서 요소에 접근 할때, 컬랙션 변경이 없을때 유용
		 * Interator : index 생성 안함, 성능이 더 좋음 / 컬랙션을 순회하면서 안전하게 제거 또는 변경할때 유용
		 */
	
		
		
	}
}