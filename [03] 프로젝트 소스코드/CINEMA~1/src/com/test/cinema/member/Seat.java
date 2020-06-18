package com.test.cinema.member;

import java.util.Arrays;
import java.util.Scanner;

public class Seat {
	
//	public static void main(String[] args) {
//		
//		
//		seatChoice();
//		
//		}//main
	
	//좌석 선택 
	
	public static void seatChoice() {
		
		
		
		//좌석 10행10열 ( 100석 ) 
		String[][] seat = new String[10][10];
		
		//좌석 번호 
		String seatNum = " ";
		String resultNum = " ";
		
		String list = " ";
		String soldoutSeat = " ";	
		
		
		int a = 0;	//행 난수
		int b = 0;	//열 난수
		
		
		System.out.println("==============================");
		System.out.println("상영관과 시간을 선택하였습니다.");
		System.out.println("==============================");
		
		
		

		//행 ( A ~ ) 
		for(int i=0; i<seat.length; i++) {
			//1. A , B , C ,,,   
			seatNum =(char)(i+65) + "" ;
			
			//열
			for(int j=0; j<seat.length; j++) {
				//A1 A2 A3 ,,
				resultNum = (seatNum +(j+1));
				
				seat[i][j] = resultNum;
				
			}//열
			
			
		}//행
		
		

		
		
		
		
		
		//이미 예매 된 좌석 ( 30석 )
		for(int i=0; i<30; i++) {
			a = (int)(Math.random()*seat.length);	//행에 들어갈 난수
			b = (int)(Math.random()*seat.length);	//열에 들어갈 난수 
			
			//soldoutSeat = seat[a][b];	// 이미 예매 된 좌석의 좌석번호 
			
			seat[a][b] = "-";	//이미 예매 된 좌석에 "-" 표시 
			
		
		}
		
		
		//좌석 출력
		for(int i=0; i<seat.length; i++) {
			for(int j=0; j<seat.length; j++) {
				System.out.print(seat[i][j] + "\t");
			}//열
			System.out.println();
			
		}//행
		
		
		
		

		

		System.out.println(" '-' 으로 표시된 좌석은 선택 하실 수 없습니다. ");
		System.out.println("==============================");
		System.out.println("1.뒤로가기\n2.처음으로 가기\n");
		System.out.println("***좌석을 선택하려면 좌석번호를 입력해 주세요.***");
		System.out.println("==============================");
		System.out.println("(메뉴 or 좌석) 입력:");
		
		Scanner scan = new Scanner(System.in);
		//입력 받은 값
		String seatInput = scan.nextLine();
		
		//if(Integer.parseInt(seatInput) == 1) {
			if(seatInput.equals("1")) {
			//뒤로가기
			//시간 선택 화면 
			
		} else if ( seatInput.equals("2")) {
			//처음으로 가기
			MemberStart.First();
			
		} else {
			
			for(int i=0; i<seat.length; i++) {
				
				for(int j=0; j<seat.length; j++) {
					
					list = seat[i][j];

			
					if(seatInput.contains(list)) {
						//result가 true이면 
						
						//좌석을 알맞게 입력 하였을 때 
						
						
						//좌석 입력 하였을 때 
						//성인,청소년,우대 각 인원수 입력 받아야 함.
						
						System.out.print("성인(명): ");
						scan = new Scanner(System.in);
						Pay.adultNum = scan.nextInt();
						
						System.out.print("청소년(명): ");
						scan = new Scanner(System.in);
						Pay.youthNum = scan.nextInt();
						
						System.out.print("우대 (명) *어린이[7~10살], 노인[65~100세]* : ");
						scan = new Scanner(System.in);
						Pay.oldNum = scan.nextInt();
						
						System.out.println("==============================");
						System.out.println("입력이 완료 되었습니다.");
						System.out.println("결제 메뉴로 이동합니다.");
						System.out.println();
						System.out.println();
						
						//결제 메뉴 선택 화면으로 이동 
						MoviePaymentMenu.payMentMenu();
						
						
						
						
					} 

					
					
					
					
				}//for
			}//for
			
			if(  (!seatInput.contains(list)) || (seatInput.equals(seat[a][b]) )  ) {
				//존재 하지 않는 좌석 입력 하였을 때 
				
				
				System.out.println("좌석을 잘못 입력하였습니다.");
				System.out.println("다시 입력해 주세요 .");
				seatChoice();
				
				
			}//if 
			
			
			
			
		}//else 
		
		

	}//seatChoice


}//Seat
