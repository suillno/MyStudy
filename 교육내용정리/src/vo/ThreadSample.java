package vo;

import java.util.ArrayList;
import java.util.List;

import main.스레드;

// 스레드와 동일 클레스로 인터페이스로 받을땐 Runnable을 사용
// 상속대신 인터페이스를 사용하므로 상속도 받을수있음 스레드를 사용할 때에는 가능하면 Runnable을 사용하자
public class ThreadSample implements Runnable {

	private int seq;

	public ThreadSample(int seq) {
		this.seq = seq;
	}

	public void run() {
		// Thread를 상속하면 run 메서드를 구현해야 한다.
		System.out.println(this.seq + " thread run.");
		try { // 1000 밀리세컨드 대기후 다음코드 실행
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.seq + " thread end.");
	}

	public static void main(String[] args) {
		
	List<Thread> threads = new ArrayList<>(); // 배열에 스레드에서 생성된 값추가
		
		for(int i = 0; i < 10; i++) {
			스레드 main = new 스레드(i);
			main.start();
			threads.add(main);
		}
		

		for(int i = 0; i < threads.size(); i++) {
			Thread t = new Thread(new ThreadSample(i)); // Thread와 완전 동일하나 이부분만 코드가 다름
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("반복문 종료");

	}
}