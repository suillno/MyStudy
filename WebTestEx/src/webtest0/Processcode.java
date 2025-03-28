package webtest0;

import java.lang.reflect.Array;

class Solution { // 나의풀이
	public String solution(String code) {
		String answer = "";
		// 스트링빌더사용 문자열 더하기
		StringBuilder str = new StringBuilder();
		// 모드 0과 1전환위해 선언
		int mode = 0;

		for (int i = 0; i < code.length(); i++) {
			// 변수 a 에 code를 한글자씩 담는다
			char a = code.charAt(i);
			// 모드전환 코드
			if (a == '1') {
				mode = 1 - mode;
				// 숫자는 출력되지 않게 해야하므로 해당 if문 실행하면 반복문의 처음으로 돌아가게 설정
			} else {
				// mode가 0 이면 i가 짝수일때 str에 문자열 더하기
				if ((mode == 0) && (i % 2 == 0)) {
					str.append(a);
					// mode가 1 이면 i가 홀수일때 str에 문자열 더하기
				} else if ((mode != 0) && (i % 2 != 0)) {
					str.append(a);
				}
			}
		}
		// 스트링 빌더를 answer에 스트링형태로 변환하여 담기
		answer = str.toString();
		// answer의 값이 비어있다면 "EMPTY" 아니면 answer 리턴
		return answer.isEmpty() ? "EMPTY" : answer;
	}
}

class OtherSolution { // 배우고 싶은 다른사람의 풀이
	public String solution2(String code) {
		// answer를 스트링빌더로 선언
		StringBuilder answer = new StringBuilder();
		int mode = 0;

		for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            
            if (current == '1') {
            	// 모드가 0 이면 1로전환 0이아니면 다시 1로전환
                mode = mode == 0 ? 1 : 0;
                //모드 전환후 continue를 사용해 i값 카운트증가
                continue;
            }
            // mode 값을 통해 홀짝 문자열을 더하는 구문 (알아두면 잘쓸거같다)
            if (i % 2 == mode) {
                answer.append(current);
            }
        }
		// answer의 길이가 0 이면 "EMPTY" 아니면 answer를 String 형태로 변환하여 리턴
        return answer.length() == 0 ? "EMPTY" : answer.toString();
	}

	public class Processcode {

		public static void main(String[] args) {


			/**
			 * 문제 문자열 code가 주어집니다. code를 앞에서부터 읽으면서 만약 문자가 "1"이면 mode를 바꿉니다. mode에 따라 code를
			 * 읽어가면서 문자열 ret을 만들어냅니다.
			 * 
			 * mode는 0과 1이 있으며, idx를 0 부터 code의 길이 - 1 까지 1씩 키워나가면서 code[idx]의 값에 따라 다음과 같이
			 * 행동합니다.
			 * 
			 * mode가 0일 때 code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
			 * code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다. mode가 1일 때 code[idx]가 "1"이 아니면 idx가 홀수일
			 * 때만 ret의 맨 뒤에 code[idx]를 추가합니다. code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다. 문자열 code를
			 * 통해 만들어진 문자열 ret를 return 하는 solution 함수를 완성해 주세요.
			 * 
			 * 단, 시작할 때 mode는 0이며, return 하려는 ret가 만약 빈 문자열이라면 대신 "EMPTY"를 return 합니다.
			 */

		}

	}
}
