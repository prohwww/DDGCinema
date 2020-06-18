package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.test.cinema.Member;

public class PayCancel {
	
	//예매 취소
	
	static void cancel() {

		// 예매 취소
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\마이페이지_Dummy_Ticket.txt"));
		
		
			String text = " ";
			String[] textSplit = null;
			
			while((text = reader.readLine())!= null) {
				
				//예매 정보 배열에 담기 
				textSplit = text.split("■");
				
				System.out.println();
				System.out.println("==============================");
				//예매 날짜 
				System.out.printf("예매 날짜 :%s\n",CommonTicketing.numDate);
				
				//지역 , 지점 
				System.out.printf("지역,지점: %s %s\n", MovieTheater.cityName,  MovieTheater.TheaterName);
				
				//영화 이름
				System.out.printf("영화이름: %s\n",MovieTheater.MovieName);
				
				//관,시간 
				System.out.printf("관,시간: %s(관) %s\n",CommonTicketing.placeName, CommonTicketing.timeName);
				
				//좌석
				System.out.printf("좌석: %s\n", CommonTicketing.seatName);
				
				System.out.printf("인원: 성인(%s명) ,청소년(%s명) ,우대(%s명) \n"
						,  Pay.adultNum  , Pay.youthNum , Pay.oldNum  );
				
				System.out.printf("환불 예정 금액: %,d원\n", Pay.totalPay);
				System.out.println("예매하신 내역을 취소하시겠습니까?\n");
				System.out.println("==============================");
				System.out.println("1.취소하기\n2.뒤로가기\n3.처음으로가기\n");
				System.out.println("==============================");
				System.out.println("메뉴 선택:");
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				
				switch(input) {
				case 1:
					//취소하기
					cancelSuccess();

				case 2:
					//뒤로가기
					//예매 내역 보기로 이동
					ReserveList.view();

					
				case 3: 
					//처음으로 가기
					MemberStart.First();

				}
				
				
				
			}//while
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		

	}//cancel
	
	
	
	static void cancelSuccess() {
		// 취소 성공
	try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\마이페이지_Dummy_Ticket.txt"));
		
		
			String text = " ";
			String[] textSplit = null;
			
			while((text = reader.readLine())!= null) {
				
				//예매 정보 배열에 담기 
				textSplit = text.split("■");
				
				//환불 할 금액 = 총 결제한 금액  = 카드에 충전 할 금액 
				//Member클래스에 mCard 변수에 누적 
				//환불금액 = 총 결제 금액 
				Pay.refund = Pay.totalPay;
				Member.mCard += Pay.refund;
				
				
				System.out.println();
				System.out.println("==============================");
				System.out.println("예매 취소를 선택 하였습니다.");
				//예매 날짜 
				System.out.printf("예매 날짜 :%s\n",CommonTicketing.numDate);
				
				//지역 , 지점 
				System.out.printf("지역,지점: %s %s\n", MovieTheater.cityName,  MovieTheater.TheaterName);
				
				//영화 이름
				System.out.printf("영화이름: %s\n",MovieTheater.MovieName);
				
				//관,시간 
				System.out.printf("관,시간: %s(관) %s\n",CommonTicketing.placeName, CommonTicketing.timeName);
				
				//좌석
				System.out.printf("좌석: %s\n", CommonTicketing.seatName);
				
				System.out.printf("인원: 성인(%s명) ,청소년(%s명) ,우대(%s명) \n"
						,  Pay.adultNum  , Pay.youthNum , Pay.oldNum  );
				
				System.out.printf("환불 금액: %,d원\n",Pay.totalPay);
				System.out.println("카드에 정상적으로 환불 되었습니다.\n");
				System.out.println("==============================");
				System.out.println("1.예매하기\n2.카드 잔액 확인\n3.뒤로가기\n4.처음으로 가기\n");
				System.out.println("메뉴 선택: ");
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				switch(input) {
				case 1:
					//예매 하기
					MemberStart.First();
					
				case 2:
					//잔액 확인
					//MyCard.moneyCheck();
					System.out.println("==============================");
					System.out.printf("현재 카드 잔액은 %d원 입니다.\n",Member.mCard);
					System.out.println("==============================");
					//환불 후 처음화면으로 이동
					MemberStart.First();
					
					
					
				case 3: 
					//뒤로가기
					cancel();
					
				case 4:
					//처음으로 가기
					MemberStart.First();
				}
				
				
				
			}//while
			
			}	catch (Exception e) {
				
				e.printStackTrace();
			}

	

	}//cancelSuccess
	
	
	
	
	
	public static void productCancelMenu(int number) {
		
		//상품 결제 취소 메뉴
		
		System.out.println("==============================");
		System.out.printf("환불 예정 금액: %d",Pay.productTotalPay);
		System.out.println("취소 하시겠습니까?");
		System.out.println("1.취소하기\n2.뒤로가기\n3.처음으로 가기");
		System.out.println("==============================");
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch(input) {
		
		case 1:
			//취소하기
			productCancel();
			
		case 2:
			//뒤로가기
			//choicePaySuccess 호출할 떄 예매 (1) ,  상품(2) 매개변수 가지고 호출해야 함.
			ChoicePay.choicePaySuccess(2);
			
		case 3:
			//처음으로 가기
			MemberStart.First();
		}
		
		
	}
	
	
	public static void productCancel() {
		
		//상품 결제 취소
		System.out.println("==============================");
		System.out.println("상품 결제 취소를 선택 하였습니다.");
		System.out.printf("환불 금액: %,d원\n",Pay.productTotalPay);
		System.out.println("==============================");
		Member.mCard += Pay.productTotalPay;
		System.out.println("카드에 정상적으로 환불 되었습니다.");
		System.out.println("==============================");
		System.out.println("1.카드 잔액 확인하기\n2.뒤로가기\n3.처음으로 가기\n");
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch(input) {
		
		case 1:
			//카드 잔액 확인 
			System.out.println("==============================");
			System.out.printf("현재 카드 잔액은 총 %d,원 입니다.\n",Member.mCard);
			System.out.println("==============================");
			System.out.println("1.충전하기\n2.뒤로가기\n3.처음으로가기");
			
				Scanner scan1 = new Scanner(System.in);
				int input1 = scan1.nextInt();
				
				if(input1 == 1) {
					//충전하기
					
					System.out.println("충전할 금액을 입력해 주세요.");
					Scanner scan2 = new Scanner(System.in);
					int input2 = scan1.nextInt();
					
					Member.mCard += input2;
					
					System.out.println("충전이 정상적으로 완료 되었습니다.");
					System.out.printf("충전 후 카드 잔액은 총 %,d원 입니다.\n",Member.mCard);
					break;
					
					
				} else if ( input1 == 2 ) {
					
					//뒤로가기
					Pay.payPay();
					
				} else if ( input1 == 3 ) {
					
					//처음으로 가기 
					MemberStart.First();
				}
			
		case 2:
			//뒤로 가기
			Pay.payPay();
			
		case 3:
			//처음으로 가기 
			MemberStart.First();
			
			
		}
		
		

	}
	
	
}
