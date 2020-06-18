package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Member;

public class MyTicketCheck {
			
	
	//예매티켓 화면출력
	public void printMyTicketCheck() {
		
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
				
		System.out.print("예매내역: \n");
		 
		 //" 2020년 1월 1일 강남점 '어벤져스' 3관 13시50분 " 
		 //환불 예정 금액 : 20,000원 ( 취소시 자동으로 카드에 충전됩니다.)** 
		System.out.println("날짜\t지점\t\t영화제목\t\t\t관\t시간");
		
		myTicketCheck(); //예매티켓 정보
		
		System.out.println("==============================");
//		System.out.println("1. 취소하기");
//		System.out.println("2. 다시 예매하기");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
				
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //뒤로
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
			Mypage.printmypage();
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		case 2:	//처음
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			MemberStart.First();
//			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//		case 3:	//뒤로가기	
//			Mypage.printmypage();
//		case 4: //처음으로가기
//			MemberStart.First();
		
		}//switch
		
		}//for
		
	}//printMyTicketCheck()

	
	// 예매티켓 정보
	private void myTicketCheck() {

		System.out.println();
		System.out.println("==============================");

		System.out.println("*******예매 내역*******");

		// 예매 날짜
		System.out.printf("예매 날짜 :%s\n", CommonTicketing.numDate);

		// 지역 , 지점
		System.out.printf("지역,지점: %s %s\n", MovieTheater.cityName, MovieTheater.TheaterName);

		// 영화 이름
		System.out.printf("영화이름: %s\n", MovieTheater.MovieName);

		// 관,시간
		System.out.printf("관,시간: %s(관) %s\n", CommonTicketing.placeName, CommonTicketing.timeName);

		// 좌석
		System.out.printf("좌석: %s\n", CommonTicketing.seatName);

		System.out.printf("인원: 성인(%s명) ,청소년(%s명) ,우대(%s명) \n", Pay.adultNum, Pay.youthNum, Pay.oldNum);

		System.out.printf("예약 번호:%s\n", Pay.ticketNumber[(int) (Math.random() * Pay.ticketNumber.length)]);
		System.out.printf("결제한 금액:%,d원\n", Pay.totalPay);
		System.out.println("***영화 시작 10분 전 까지 입장해 주시기 바랍니다.***");
		System.out.println("==============================");
		System.out.println("1.취소하기\n2.뒤로가기\n3.처음으로 가기\n");
		System.out.println("==============================");
		System.out.println("메뉴 선택: ");

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		if (input == 1) {
			// 취소하기
			PayCancel.cancel();
		} else if (input == 2) {
			// 뒤로가기
			return;

		} else if (input == 3) {
			// 처음으로가기
			MemberStart.First();
		}

	}// myTicket()

}
