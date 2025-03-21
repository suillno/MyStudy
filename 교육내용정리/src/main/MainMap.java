package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Person{
	String name;
	String birth;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

public class MainMap {


	public static void main(String[] args) {
		// 맵 : 사전과 비슷하다
		// people : 사람, baseball : 야구
		// name : 최종선, birth : 2000101
		// key : value
		// key와 value가 쌍으로 이루어진것을 map이라고 한다
		// map : HashMap, LinkedHashMap, Treemap 등등
		// VO, HashMap
		
		// 클레스를 통해 값 입력 (getter,setter)
		Person p = new Person();
		p.setName("노수일");
		p.setBirth("19910824");
		p.setAge(33); // class 의 경우 int값도 동일하게 작성가능
		String name = p.getName();
		String birth = p.getBirth();
		List<Person> list = new ArrayList<>();
		list.add(p);
		
		// 클레스 없이 값 생성 가능 HashMap : 순서 상관없이 저장
		HashMap<String, Object> hashmap = new HashMap<>(); // HashMap의 경우 특정 자료형을 지정해버리면 값이 고정됨 따라서 모든 최상위클레스인 Object를 넣어줌
		hashmap.put("name", "노수일"); // key, value 입력
		hashmap.put("birth", "19910824");
		hashmap.put("age", 10);
		String name2 = (String) hashmap.get("name"); // key로 값 가져오기 (Object에서 가져올 값으로 String으로 형변환 )
		String birth2 = (String) hashmap.get("birth");
		int age = (int) hashmap.get("age");
		List<HashMap<String, Object>> hashMapList = new ArrayList<>();
		hashMapList.add(hashmap);
		
		// contaninsKey : 맵에 해당 key가 있는지 true, false로 리턴
		System.out.println(hashmap.containsKey("birth"));
		
		// size : 맵의 요소 갯수 리턴
		System.out.println(hashmap.size());
		
		// keyset : 맵의 모든 key를 모아서 리턴한다
		System.out.println(hashmap.keySet());
		
		// key리스트를 arraylist로 생성가능
		List<String> keyList = new ArrayList<>(hashmap.keySet());
		System.out.println(keyList);
		
		// values : 맵의 모든 values를 모아서 리턴한다
		System.out.println(hashmap.values());
		
		// remove : 맵의 항목을 삭제한다. 해당 key로 항목을 삭제후 value를 리턴함
		System.out.println(hashmap.remove("name"));
		

		// map : HashMap, LinkedHashMap, TreeMap
		// HashMap : 순서 상관없이 데이터를 저장
		// LinkedHashMap : 입력된 순서대로 대이터를 저장
		// TreeMap : 입력된 key 오름차순으로 데이터를 저장
		
		// JSON : JavaScript Object Notation
		
		
	}

}
