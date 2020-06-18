package com.test.cinema.member;

import java.util.Scanner;

import com.test.cinema.Member;

public class Mypage {
	
	//마이페이지 화면출력
	public static void printmypage() {
				
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("마이페이지에 들어왔습니다. 번호를 선택해주세요.");
		
		System.out.println("==============================");
		System.out.println("1. 내 정보 관리");
		System.out.println("2. 예매 티켓확인");
		System.out.println("3. 지금까지 본 영화 목록");
		System.out.println("4. 리뷰 작성 목록");
		System.out.println("5. 마일리지 확인");
		System.out.println("6. 카드 관리");
		System.out.println("7. 회원 탈퇴");
		System.out.println("8. 뒤로가기");
		System.out.println("9. 처음으로 가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
			
			
		int num = scan.nextInt();
	
		switch(num) {
		case 1: //내 정보 관리
			
			Myinfo myinfo = new Myinfo();
			myinfo.printMyinfo();
			break;	
			
		case 2:	//예매 티켓확인
			
			MyTicketCheck myticketcheck = new MyTicketCheck();
			myticketcheck.printMyTicketCheck();
			break;
			
		case 3:	//지금까지 본 영화목록
			MyMovieList mymovielist = new MyMovieList();
			mymovielist.printMyMovieList();
			break;
			
		case 4:
			Myreview myreview = new Myreview();
			myreview.printMyreview();
			break;
			
		case 5: //마일리지 확인
			MyMileage myMileage = new MyMileage(); 
			myMileage.printMyMileage();
			break;
					
		case 6: //카드관리
			MyCard mycard = new MyCard();
			mycard.printMyCard();
			break;
		case 7: //회원탈퇴
			MyOut myout = new MyOut();
			myout.myOutprint();
			break;
			
		case 8: //뒤로가기
			return;
		case 9: //처음으로 가기
			MemberStart.First();
	
	
		}//switch
				
		}//for	
		
		
	}//printmypage()
	
}//Mypage




















