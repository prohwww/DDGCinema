package com.test.cinema.member;

import java.util.Scanner;

public class Ticketing {

//	public static void main(String[] args) {
//		TicketingStart();
//	}
	
	public static void TicketingStart() {
	 
		System.out.println();
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1. 영화별 선택");
		System.out.println("2. 극장별 선택");
		System.out.println("3. 뒤로가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
		Scanner scan = new Scanner(System.in);
	
		int num = scan.nextInt();
		
		switch(num) {
		case 1:
			MovieTheater.MovieChoice();
			break;
		case 2:
			MovieTheater.TheaterChoice();
			break;
		case 3:
			MemberStart.First();
			
		}
		
		scan.close();
	}
	
	
	
}
