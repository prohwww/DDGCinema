package com.test.cinema.member;

import java.util.Scanner;

import com.test.cinema.Logout;
import com.test.cinema.Start;

public class MemberStart {

//	public static void main(String[] args) {
//		First();
//	}
	
	public static void First() {
		

		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println();
		System.out.println("==============================");
		System.out.println("1. 예매하기");
		System.out.println("2. 영화순위");
		System.out.println("3. 상품");
		System.out.println("4. 마이페이지");
		System.out.println("5. 로그아웃");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
		
		int num = scan.nextInt();
		
		switch(num) {
		case 1:
			Ticketing t = new Ticketing();
			t.TicketingStart();
			break;
			
			
			
		case 2:
			RankMovie r = new RankMovie();
			try {
				r.rankmovie();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
			
			

			
			
			
			
		case 3:
			Product p = new Product();
			try {
				p.produck();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
			
			
			
		case 4:
			Mypage m = new Mypage();
			m.printmypage();
			break;
			
			
			
			
			
		case 5:
			Logout out = new Logout();
			out.logoutSave();
			System.out.println();
			System.out.println("로그아웃 되었습니다.");
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		}
		
		System.out.println();
	}
	
	
}
