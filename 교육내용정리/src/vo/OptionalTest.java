package vo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
	
	public static Optional<String> getValueatIndex(List<String> list, int index){
		// 배열 길이값 안에 index가 있는지 체크
		// 있을때 또는 없을때 리턴 어떻게 할건가
		if(index >= 0 && index < list.size()) {
		return Optional.ofNullable(list.get(index));
		}
		return Optional.empty(); // 값이 없거나 배열을 벗어나면 리턴하는 값
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple","Banana","Cherry",null);
		
		// 리스트를 조회하는 메서드 호출
		Optional<String> optionalValue = getValueatIndex(list, 1);

		// 리스트 조회하는 메서드 호출후 값이 없으면 문자출력
		optionalValue = Optional.ofNullable(getValueatIndex(list, 4).orElse("값이 없음"));
		
		// 조회한 값을 출력
		optionalValue.ifPresent(System.out::println);
		
		

		
		
	}

}
