package com.test.cinema.system;

import java.util.Scanner;

public class SystemStart {

	private static SystemOutput output;
	
	static {
		output = new SystemOutput();
	}
	
//	public static void main(String[] args) {
	public void systemMenu() {
	
		Scanner scan = new Scanner(System.in);

		while (true) {

			output.menu();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 극장별 영화 관리
				output.title(1);
				CinemaManagement cinemas = new CinemaManagement();
				cinemas.CinemaList();
				
			} else if (sel.equals("2")) {
				// 회원 정보 관리
				output.title(2);
				CustomerManagement customers = new CustomerManagement();
				customers.customerList();
			
			} else if (sel.equals("3")) {
				// 리뷰 관리
				output.title(3);
				ReviewManagement reviews = new ReviewManagement();
				reviews.SReivewPrint();
			
			} else if (sel.equals("4")) {
				// 극장별 매출 관리
				output.title(4);
				SySalesManagement sales = new SySalesManagement();
				sales.salesPrint();
				
			} else if (sel.equals("5")) {
				// 로그아웃
				output.title(5);
				break;
			} else {
				// 프로그램 종료
				break;
			}

		} // while


	}//main

	
}
