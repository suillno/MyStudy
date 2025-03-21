package main;

import java.util.ArrayList;
import java.util.List;

public class 스레드 extends Thread {

	private int seq;
	
	
	public 스레드(int seq) {
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
	
	
	public static void main(String[] args) throws InterruptedException {
		// 동작하고 있는 프로그램 : 프로세스 process
		// 한개의 프로세스에느 한가지의 일을 수행한다
		// 하지만 스레드 thread를 이용하면 프로세스 내에서 
		// 두가지 또는 그 이상의 일을 동시 수행할수있다.
		
		// 스레드는 순서와 상관없이 랜덤하게 실행됨
		List<Thread> threads = new ArrayList<>(); // 배열에 스레드에서 생성된 값추가
		
		for(int i = 0; i < 10; i++) {
			스레드 main = new 스레드(i);
			// start() 메서드로 thread를 실행
			main.start();
			threads.add(main);
		}
		
		// 추가한 베열의 길이만큼 반복문실행
		// 각각 베열의 호출후 join을 통헤 스레드 종료후 다음작업 진행
		for(int i = 0; i < threads.size(); i++) {
			Thread t = threads.get(i);
			t.join();
		}
		System.out.println("반복문 종료");
		
		
	}

}
