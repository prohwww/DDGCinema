package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.test.cinema.Member;

public class MyMileage {
		
	//마일리지 화면출력
	public void printMyMileage() {
		
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("마일리지에 들어왔습니다. 번호를 선택하여주세요.");
		System.out.println("==============================");				
		System.out.println("1. 누적/현재 마일리지 보기");
		System.out.println("2. 회원 등급 보기");
		System.out.println("3. 뒤로가기");
		System.out.println("4. 처음으로가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
				
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //누적/현재 마일리지 보기
			mileageCheck();					
			break;
		case 2:	//회원 등급 보기
			mileageLevel();		
			break;
		case 3:	//뒤로가기	
			return;			
		case 4: //처음으로가기
			MemberStart.First();
		}//switch
		
		}//for
		
		
	}
	
	//현재 회원 등급 보기
	public void mileageLevel() {
		
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("회원 등급 보기에 들어왔습니다. 번호를 선택하여주세요.");
		System.out.println("==============================");			
		System.out.printf("현재 %s님의 회원 등급은 : \"%s\"입니다.\n"
				//회원 이름, 회원등급
				, Member.getmName(), Member.getmGrade()); 
		
		System.out.printf("다음 등급까지 \"%,d\"점 남았습니다.\n" 
				//다음 등급까지 점수 계산 
				, Member.getmGrade() == "골드" ? 100000 - Member.getmMileage()
						: Member.getmGrade() == "실버" ?  50000 - Member.getmMileage() : 0);
			
		System.out.println("1. 회원 등급표 보기");
		System.out.println("2. 뒤로가기");
		System.out.println("3. 처음으로가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
				
		
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //회원 등급표 보기
			membergrade();		
		case 2:	//뒤로 가기
			return;				
		case 3:	//처음으로 가기
			MemberStart.First();		
		}//switch
		
		}//for
		
	}
	
	//회원 등급 표
	private void membergrade() {
		
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("회원 등급 표에 들어왔습니다. 번호를 선택하여주세요.");
		System.out.println("==============================");			
			
		System.out.println("조건\t\t마일리지");
		System.out.println("플레티넘\t\t100,000");
		System.out.println("골드\t\t50,000");
		System.out.println("실버\t\t0~4,9999");
		System.out.println("*등급별로 할인과 적립되는 금액이 다릅니다.*");
		System.out.println("\'실버\'등급 - 할인금액 : 결제 금액의 5% 할인");
		System.out.println("	   - 적립금액 : 결제 금액의 3% 적립");
		
		System.out.println("\'골드\'등급 - 할인금액 : 결제 금액의 10% 할인");
		System.out.println("	   - 적립금액 : 결제 금액의 5% 적립");
		
		System.out.println("\'플레티넘\'등급 - 할인금액 : 결제 금액의 20% 할인");
		System.out.println("	   - 적립금액 : 결제 금액의 7% 적립");
				
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
				
		
		int num = scan.nextInt();
		
		switch(num) {
		
		case 1:	//뒤로 가기
			return;				
		case 2:	//처음으로 가기
			MemberStart.First();
		}//switch
		
		}//for
		
		
	}

	//현재 마일리지 보기
	private void mileageCheck() {
								
		Scanner scan = new Scanner(System.in);
		
		System.out.println("누적/현재 마일리지 보기에 들어왔습니다.");
		System.out.println("==============================");					
		System.out.printf("현재 마일리지 : \"%s\"점\n"
				, Member.getmMileage()); //현재 마일리지
		System.out.println("*영화티켓,상점 이용시 현금처럼 사용 가능합니다*\n");
		System.out.println("*마일리지 사용조건*");
		System.out.println("총 결제금액이 만원 이상 일시.");
		System.out.println("5,000점 부터 천 단위로 사용하실 수 있습니다.\n");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
						
		int num = scan.nextInt();
		
		switch(num) {
		
		case 1: //뒤로가기
			return;	
		case 2:	//처음으로 가기
			MemberStart.First();
						
		}//switch
		
	
		
	}
		
	
}//class MyMileage
