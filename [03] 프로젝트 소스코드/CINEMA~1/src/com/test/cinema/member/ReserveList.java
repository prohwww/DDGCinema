package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReserveList {
	

	static void view() {
		//예매 내역 보기 
		while(true) {
			try {
				
				BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\마이페이지_Dummy_Ticket.txt"));
			
				String text = " ";
				String[] textSplit = null;
				
				while((text = reader.readLine())!= null) {
					
					//예매 정보 배열에 담기 
					textSplit = text.split("■");
				
				}//while
			
			
				System.out.println();
				System.out.println("==============================");
				
				//예매 내역: 날짜 , 지점 , 영화이름, 관 수 , 시간 
//				System.out.printf("예매 내역:%s %s '%s' %s %s\n" 
//						, textSplit[1],  textSplit[2],  textSplit[3] ,  textSplit[4] ,  textSplit[5]  );
//				
//				
//				//날짜 
//				String[] dateList = {"2020-05-18", "2020-05-19", "2020-05-20", "2020-05-21", "2020-05-22"};
//				System.out.printf("예매 내역:%s %s '%s' %s %s\n" 
//						, dateList[CommonTicketing.num-1],  textSplit[2],  textSplit[3] ,  textSplit[4] ,  textSplit[5]  );
				
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
						, Pay.adultNum  , Pay.youthNum , Pay.oldNum );

				
				System.out.printf("예약 번호:%s\n",Pay.ticketNumber[(int)(Math.random()*Pay.ticketNumber.length)]);
				System.out.printf("결제한 금액:%,d원\n",  Pay.totalPay );
				System.out.println("***영화 시작 10분 전 까지 입장해 주시기 바랍니다.***");
				System.out.println("==============================");
				System.out.println("1.취소하기\n2.뒤로가기\n3.처음으로 가기\n");
				System.out.println("==============================");
				System.out.println("메뉴 선택: ");
				
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				
				
				switch(input) {
				
				case 1:
					//취소하기
					PayCancel.cancel();

				case 2:
					//뒤로가기
					//예매하기로 이동 
					MemberStart.First();
					
					
				case 3:
					//처음으로 가기
					MemberStart.First();
					
				}
				
				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}//catch
			
			
			
	
		}//view
	
	}//while

}//ReserveList
