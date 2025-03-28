package webtest0;

import java.util.stream.IntStream;

public class 등차수열 {

	class Solution { // 나의 풀이
	    public int solution(int a, int d, boolean[] included) {
	        int answer = 0;
	        
	        // included의 길이만큼 루프를 돌고
	        for(int i = 0; i < included.length; i++) {
	        	// included의 i 번째가 true 라면 answer에 a값을 더함
	        	if(included[i]) {
					answer += a;
				}
	        	// a를 한번루프가 돌때마다 d만큼 증가시켜야하므로 루프종료시마다 a에 d값을 더해줌
				a += d;
	        }
	        return answer;
	    }
	}
	    
	    class Other { // 배우고 싶은 다른사람 풀이
	    	 public int solution(int a, int d, boolean[] included) {
	 	        int answer = 0;
	 	        // 루프도는거는 동일함
	    	 for(int i = 0; i < included.length; i++){
	    		 // 다만 등차수열 계산을 수학공식으로함 
	             if(included[i]){
	                 answer +=  a + (d*i);
	             }
	         }
	         return answer;
	    }
	}
	    class Other2 { // 배우고 싶은 다른사람 풀이
	        public int solution(int a, int d, boolean[] included) {
	        	
	        	// 인트스트림을 통해 배열의 0자리부터 included길이만큼 순회
	            return IntStream.range(0, included.length)
	            		// 배열을 순회하며 i값을 증가시키고 배열의[i] 번째가 true일경우 a+(i*d)를 false일경우 0을 반환한다 그후 모든 값을 더한다.
	            		.map(i -> included[i]?a+(i*d):0)
	            		.sum();
	        }
	    }
	
	public static void main(String[] args) {
		

		int a = 1;
		int d = 4;
		boolean[] included = {true, true, false, true, true};
		
		int c = IntStream.range(0, included.length)
				.map(i -> included[i]&&i%2==0?a+(i*d):0)
				.sum();
				
		System.out.println(c);
		/**
		 * 두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다. 
		 * 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때, 
		 * 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
		 */
		
	}

	}
