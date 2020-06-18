package com.test.cinema.store;

import java.util.Scanner;

public class MovieManagement {

	Scanner scan = new Scanner(System.in);
	
	public void mSearch() throws Exception{
		
		System.out.println("==================================================================");
		System.out.println("1. 상영 영화 조회");
		System.out.println("2. 상영 영화 수정");
		System.out.println("3. 뒤로가기");
		System.out.println("4. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		
		switch (num) {
			
			//상영 영화 조회
			case 1:
				SearchMovie s = new SearchMovie();
				s.nSearch();
				break;
			//상영 영화 수정
			case 2:
				EditMovie d = new EditMovie();
				d.nModify();
				break;
			//뒤로가기
			case 3:
				StoreStart a = new StoreStart();
				a.managerStart();
				break;
			//처음으로 돌아가기
			case 4:
				StoreStart q = new StoreStart();
				q.managerStart();
				break;

		}
		
		
	}
	
}
