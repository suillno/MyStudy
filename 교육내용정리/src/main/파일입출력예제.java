package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class 파일입출력예제 {

	public static void main(String[] args) throws IOException {
		/**
		 * 파일을 저장했다.
		 * 파일 : a.txt > 잘가
		 * 파일 : a.txt > 안녕
		 * 중복 안되게 할 조건 : 파일 이름이 중복되지 않게하는 처리
		 * c:/java/2025/03/28/abcd.txt : 날짜를 기준으로 랜덤파일이름 생성
		 */
		
		// 1, 사용자가 파일을 업로드하는 행위를 했다.
		// 2, 연월일 기본 폴더 생성
		LocalDate currentDate = LocalDate.now(); // 2025-03-28형식 출력
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // 출력형식 변경
		String formattedDate = currentDate.format(formatter); // 변경 출력형식 적용 2025/03/28
		System.out.println(formattedDate);
		
		File dirs = new File("c:/java/" + formattedDate); // 변경된 날짜로 폴더 생성
		
		if(!dirs.exists()) { // 폴더 경로가 없을시 생성 true/false 표기
			if(dirs.mkdirs()) { // 폴더 생성여부 확인 true/false 표기
				System.out.println("폴더 생성 완료");
			} else {
				System.out.println("생성 실패"); // 폴더 생성실패시 이후코드 실행필요 없음
				return;
			}
		}
		// 3, 파일 생성후 저장 (파일의 중복을 막기위해 파일명 랜덤생성)
		
		UUID uuid = UUID.randomUUID(); // 랜덤한 UUID(고유 식별자) 생성
		
		String fileName = uuid + ".txt"; // 파일이름 선언
		File file = new File(dirs, fileName); // 경로, 파일이름 생성
		String content = "It is a good day to die";
		
		// UTF-8 인코딩으로 파일에 문자열을 쓰기 위한 BufferedWriter 생성
		try (BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) { 
			write.write(content);
			System.out.println("저장완료");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
