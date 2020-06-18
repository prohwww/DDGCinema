package com.test.cinema.member;

import java.util.Scanner;

import com.test.cinema.Member;

public class MoviePaymentMenu {
	
	//영화 결제 메뉴
	//MoviePaymentMenu.payMentMenu();
	public static void payMentMenu() {
		
		System.out.println("==============================");
		System.out.println("좌석을 선택 하셨습니다.");
		System.out.println("==============================");
		System.out.println("1.결제하기\n2.카드 잔액 조회\n3.금액 충전하기\n4.금액 인출하기\n5.뒤로가기\n6.처음으로 가기\n");
		System.out.println("==============================");
		System.out.println("메뉴 선택: ");
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch(input) {
		
		case 1:
			//결제하기
			Pay.payPay();
			
		case 2:
			//카드 잔액 조회
			//MyCard.moneyCheck();
			System.out.println("==============================");
			System.out.printf("현재 카드 잔액 : %,d\n", Member.mCard);
			System.out.println("==============================");
			System.out.println();
			payMentMenu();
			
			
		case 3:
			//금액 충전하기
			//MyCard.moneyIn();
			System.out.println("==============================");
			System.out.println("카드 금액 충전");
			System.out.println("충전할 금액을 입력해 주세요: ");
			
			scan = new Scanner(System.in);
			int addMoney = scan.nextInt();
			Member.mCard += addMoney;
			
			System.out.println("==============================");
			System.out.println("충전이 완료 되었습니다.");
			System.out.printf("충전 후 카드 잔액 : %,d\n",Member.mCard);
			System.out.println("==============================");
			payMentMenu();
			
		case 4:
			//금액 인출하기
			//MyCard.moneyOut();
			
			System.out.println("==============================");
			System.out.println("카드 금액 인출");
			System.out.println("인출할 금액을 입력해 주세요. :");
			
			scan = new Scanner(System.in);
			int outMoney = scan.nextInt();
			Member.mCard -= outMoney;
			
			System.out.println("==============================");
			System.out.println("인출이 완료 되었습니다.");
			System.out.printf("인출 후 카드 잔액 : %,d\n", Member.mCard);
			System.out.println("==============================");
			payMentMenu();
			
			
		case 5:
			//뒤로가기
			//좌석 선택
			Seat.seatChoice();
			
		case 6:
			//처음으로 가기
			MemberStart.First();
		
		}
		

	}//payMentMenu
	

}//MoviePaymentMenu
