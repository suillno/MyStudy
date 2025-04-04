package webtest0;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class 입출력시험 {
	
	public void output1() {
		
		
	}

	public static void main(String[] args) {
		
		FileOutputStream fow = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:/java/test2.txt");
			fow = new FileOutputStream("C:/java/test.txt");
			
			String str = "안녕하세요!";
			
			
			
			for(int i = 0; i <str.length(); i++) {
				fw.write(str.charAt(i));
				fow.write(str.charAt(i));
			}
			fw.close();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}


