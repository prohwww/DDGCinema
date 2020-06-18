package com.test.cinema.member;

import java.util.Scanner;

import com.test.cinema.Member;

public class Mileage {
	

		static void mileageSuccess()  {
		
		//마일리지 사용 가능 고객 
		System.out.println();
		System.out.println("==============================");
		System.out.printf("고객님의 현재 마일리지는 %,d점 입니다.\n",Member.mMileage);
		System.out.println("1,000원 단위로 사용가능합니다.");
		System.out.println("사용하실 마일리지를 입력해 주세요");
		
		System.out.println("입력: ");
		
		Scanner scan = new Scanner(System.in);
		int inputMileage = scan.nextInt();
		
		if(inputMileage > Member.mMileage) {
			//입력한 마일리지가 보유한 마일리지보다 크면 
			System.out.println("입력한 마일리지가 더 많아 사용하실 수 없습니다.");
			System.out.println("마일리지를 다시 입력해 주세요.");
			mileageSuccess();
			
		}
		
		//마일리지 사용후 남은 결제 금액 
		int etcMoney = Pay.totalPay - inputMileage;
		
		//마일리지 사용후 남은 마일리지
		Member.mMileage -= inputMileage;
		
		
		//1000원 단위로 사용 가능 
		if(inputMileage % 1000 == 0) {
			
			if(etcMoney == 0) {
				//더이상 결제할 금액 없을 때 
				//결제 완료 
				ChoicePay.mileagePaySuccess( );
				
			} else {
				//마일리지 사용 후에도 결제할 금액이 남아있을 때 
				//int etcMileageMoneyPay= Pay.totalPay - inputMileage;	//총 결제 금액 - 사용할 마일리지
				
				ChoicePay.mileagePayFail( etcMoney );

			}
		
		} else {
			//마일리지는 1000단위로 사용가능 해요 ,,,,, 이거 안됩니다 ! 
			System.out.println("마일리지를 잘못 입력하였습니다.");
			System.out.println("마일리지는 1,000 단위로 사용 가능합니다.");
			System.out.println("결제 화면으로 넘어갑니다.");
			System.out.println("==============================");
			mileageSuccess();
			
		}
		

		
		
		

	}
	

	static void mileageFail() {
		
		while(true) {
			//마일리지 사용 불가능 고객 
			System.out.println("==============================");
			System.out.printf("고객님의 현재 마일리지는 %d점 입니다.\n",Member.mMileage);
			System.out.println("마일리지는 5,000점 이상 있을 때 사용 가능합니다.");
			System.out.println("==============================");
			System.out.println("1.뒤로가기\n2.처음으로 가기");
			
			System.out.print("입력: ");
			
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			
			switch(input) {
			case 1:
				//뒤로가기
				Pay.payPay();
				
			case 2:
				//처음으로 가기
				MemberStart.First();
				

			}

		}
		
	}//while
	
}
