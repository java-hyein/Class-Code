package day1122;

import java.util.Scanner;
import java.util.Vector;

class WordGenerator extends Thread {
	
	Vector words = new Vector();
	String[] data;
	int interval = 2 * 1000; // 2초	
	
	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public Vector getWords() {
		return words;
	}

	public void setWords(Vector words) {
		this.words = words;
	}

	public void run() {
		
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1.interval(2초)마다 배열 data의 값 중 하나를 임의로 선택해서 
		 * 2.words에 저장한다.
		 */
		while(true) {
			int rand = (int)(Math.random()*data.length);

			words.add(data[rand]);			

			try {
				Thread.sleep(interval);
			} catch(Exception e) { }

		}

	}
}

class Exercise13_8  {

	
	static String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };

	public static void main(String args[]) {
		
		//Exercise13_9 game = new Exercise13_9();
		//game.wg.start();
		//Vector words = game.words;
		WordGenerator wg = new WordGenerator();
		Vector words = wg.getWords();
		wg.setData(data);
		wg.start();

		while (true) {
			System.out.println(words);
			String prompt = ">>";
			System.out.print(prompt);
			// 화면으로부터 라인단위로 입력받는다.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = words.indexOf(input);

			if (index != -1) {
				words.remove(index);
			}

		}

	}
}