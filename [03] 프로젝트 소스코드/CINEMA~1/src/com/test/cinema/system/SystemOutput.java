package com.test.cinema.system;

public class SystemOutput {

	
	public void menu() {
		
//		System.out.println("시스템 관리자로 로그인하셨습니다.");
//		System.out.println("==============================");
		System.out.println("=======시 스 템 관 리 자======");
		System.out.println("1. 극장별 영화 관리");
		System.out.println("2. 회원 정보 관리");
		System.out.println("3. 리뷰 관리");
		System.out.println("4. 지역별 매출 관리");
		System.out.println("5. 로그아웃");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
	}
	
	public void title(int num) {

		switch(num) {
		
		case 1 : 
			System.out.println("======[극장별 영화관리]=======");
			break;
		case 2 : 
			System.out.println("========[회원 정보 관리]======");
			break;
		case 3 : 
			System.out.println("==========[리뷰관리]==========");
			break;
		case 4 : 
			System.out.println("======[극장별 매출 관리]======");
			break;
		case 5 :
			System.out.println("로그아웃 했습니다.");
			break;
		}
		
	}
	
}
