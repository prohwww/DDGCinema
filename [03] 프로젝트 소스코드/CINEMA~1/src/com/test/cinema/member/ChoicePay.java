package com.test.cinema.member;

import java.util.Scanner;

import com.test.cinema.Member;

public class ChoicePay {

	static void choicePaySuccess(int number) {
		//결제 성공 
		
		while(true) {
			
			//number = 1 : 영화예매에서 온 결제 성공 
			//number = 2 : 상품에서 온 결제 성공 
			if(number == 1) {
				
				//결제 
				//카드 잔액에서 영화 결제 금액 빼서 누적.
				Member.mCard -= Pay.totalPay; 
				
				System.out.println();
				System.out.println("==============================");
				System.out.println("영화 예매 결제가 성공적으로 완료되었습니다.");
				System.out.printf("결제 후 남은 금액은 %,d원 입니다.\n", Member.mCard );
				System.out.printf("금액 %,d원의 %,d마일리지가 적립되었습니다.\n", Pay.totalPay ,(int)(Pay.totalPay*Pay.point));
				System.out.println("==============================");
				System.out.println("1.예매 내역 보기\n2.결제 취소\n3.뒤로 가기\n4.처음으로가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택: ");
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				
	
				
				//마일리지 적립
				Member.mMileage +=(int)(Pay.totalPay*Pay.point);
				
				
				switch(input) {
				case 1:
					//예매 내역보기
					ReserveList.view();
					
				case 2:
					//결제 취소
					PayCancel.cancel( );
					
				case 3:
					//뒤로가기
					Pay.payPay();
					
				case 4:
					//처음으로 가기 
					MemberStart.First();
				}
			}//if 
			
			else if ( number == 2) {
				//상품 결제 성공 
				
				Member.mCard -= Pay.productTotalPay; 
				
				
				System.out.println();
				System.out.println("==============================");
				System.out.println("상품 결제가 성공적으로 완료되었습니다.");
				System.out.printf("결제 후 남은 금액은 %,d원 입니다.\n", Member.mCard );
				System.out.printf("금액 %,d원의 %,d마일리지가 적립되었습니다.\n", Pay.productTotalPay ,(int)(Pay.productTotalPay*Pay.point));
				System.out.println("==============================");
				System.out.println("1.결제 취소\n2.뒤로 가기\n3.처음으로가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택: ");
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				switch(input) {
				
					
				case 1:
					//결제 취소
					PayCancel.productCancel();
					
				case 2:
					//뒤로가기
					Pay.payPay();
					
				case 3:
					//처음으로 가기 
					MemberStart.First();
				}
				
				
				
			}//else 
			

		}//while

	}
	
	
	static void choicePayFail() {

		//결제 실패 
		while(true) {
			System.out.println();
			System.out.println("==============================");
			System.out.printf("%,d원이 부족하여 결제가 실패하였습니다.\n", Member.mCard - Pay.totalPay  );//총 금액 - 결제 금액 
			System.out.println("충전 하시겠습니까?");
			System.out.println("==============================");
			System.out.println("1.충전하기\n2.뒤로가기\n3.처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택: ");
			

			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			
			switch(input) {
			case 1:
				//충전하기
				System.out.println("충전할 금액을 입력해 주세요.");
				scan = new Scanner(System.in);
				int inputPay = scan.nextInt();
				
				Member.mCard += (inputPay);
				System.out.println("충전 후 금액 : "+ Member.mCard);
				//MyCard.moneyIn();
				
			case 2:
				//뒤로가기
				Pay.payPay();
				
			case 3:
				//처음으로 가기
				MemberStart.First();
			
			}

		}//while
	}
	
	
	
	
	
	

	static void mileagePaySuccess() {
		
		while(true) {
			//마일리지로 전액 사용 성공
			System.out.println();
			System.out.println("==============================");
			System.out.println("결제가 성공적으로 완료되었습니다.");
			System.out.println("마일리지는 0점 입니다.");
			System.out.println("마일리지로 전액 결제 한 경우 취소는 불가 합니다.");
			System.out.println("==============================");
			System.out.println("1.예매 내역 보기\n2.뒤로 가기\n3.처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택: ");
			
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			
			switch(input) {
			case 1:
				//예매 내역 보기
				ReserveList.view();
				
			case 2:
				//뒤로 가기
				Mileage.mileageSuccess();
				
			case 3:
				//처음으로 가기
				MemberStart.First();
				
			
			}

			

		}//while
		
	}

	static void mileagePayFail(int etcMoney) {
		//결제 실패 
		while(true) {
			System.out.println();
			System.out.println("==============================");
			System.out.printf("결제할 금액이 %,d원 남았습니다.\n", etcMoney);
			System.out.println("결제 하시겠습니까?");
			System.out.println("==============================");
			System.out.println("1.결제하기\n2.뒤로가기\n3.처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택: ");
			
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			
	
			
			
			switch(input) {
			case 1:
				//차액 결제 하기 
				mileageDifference(etcMoney);
				
			case 2:
				//뒤로 가기
				Mileage.mileageSuccess();
				
			case 3:
				//처음으로 가기
				MemberStart.First();
			
			}

			
		
		}//while
		
	}
	
	
	static void mileageDifference( int etcMoney) {
		
		//마일리지로 사용하고 남은 금액 카드로 결제 완료 
		while(true) {
			
			if(Member.mCard >= etcMoney) {
				
				Member.mCard -= etcMoney;
				
				//차액(etcMoney)이 카드 잔액(textSplitResult)보다 적어야 결제 가능.
				System.out.println();
				System.out.println("==============================");
				System.out.printf("마일리지 사용후 남은 금액 %,d원이 정상적으로 결제 되었습니다.\n",etcMoney);
				System.out.println("마일리지 사용시에는 마일리지 적립이 되지 않습니다.");
				System.out.println("==============================");
				System.out.println("1.예매 내역 확인\n2.뒤로가기\n3.처음으로 가기\n");
				System.out.println("메뉴 선택: ");
				
				
				
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				
				switch(input) {
				case 1:
					//예매 내역 확인 
					ReserveList.view();
					
				case 2:
					//뒤로가기
					mileagePayFail(etcMoney);
					
				case 3:
					//처음으로 가기 
					MemberStart.First();
				
				}
			
			}//if
			else {
				//차액 결제하려고 하는데 , 카드 잔액이 부족한 경우
				System.out.println("==============================");
				System.out.println("카드 잔액이 부족합니다.");
				System.out.println("==============================");
				System.out.println("1.충전하기\n2.뒤로가기\n3.처음으로 가기\n");
				System.out.println("메뉴 선택: ");
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				
				switch(input) {
				case 1:
					//충전 하기
					//차액 - 카드 잔액  을 충전 
					Member.mCard += (etcMoney-Member.mCard)*(-1);
					
					System.out.println("충전할 금액을 입력해 주세요.");
					scan = new Scanner(System.in);
					int inputMoney = scan.nextInt();
					
					Member.mCard += inputMoney;


					
				case 2:
					//뒤로가기
					mileagePayFail(etcMoney);
					
				case 3:
					//처음으로 가기 
					MemberStart.First();
				
				}
				
			}

			
		}//while
	}
	
	
	

}
