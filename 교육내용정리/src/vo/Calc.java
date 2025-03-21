package util;

import java.util.Collections;
import java.util.List;

import vo.StudentVO;

public class Calc {

	public static void calcRank(List list) {
		// 리스트를 총점 기준 내림차순 정렬
		Collections.sort(list);
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		// 반복문을 이용해서 list에 저장된 Student 객체를 하나씩 읽는다.
		for (int i = 0; i < length; i++) {
			StudentVO s = (StudentVO) list.get(i);
			// 총첨 total이 이전 총점 prevTotal과 같으면 이전 등수 prevRank를 등수 schoolRank로 한다.
			if (s.getTotal() == prevTotal) {
				s.setSchoolRank(prevRank);
			} else {
				// 총점이 다르면 등수 schoolRank의 값을 알맞게 계산해서 저장한다. 이전에 동점자였다면 그 다음 등수는 동점자의 수를 고려해야한다.
				s.setSchoolRank(i + 1);
			}
			// 현재 총점과 등수를 이전 총첨 prevTotal과 이전 등수 prevRank에 저장한다.
			prevRank = s.getSchoolRank();
			prevTotal = s.getTotal();
		}
		
	}
	
}
