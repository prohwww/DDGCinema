package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CommonTicketing {
	
	public static String numDate;	//예매 날짜 
	//public static int numTime;	//상영관,시간
	public static String date;	//상영관,시간
	public static String seatName;	//선택한 좌석 
	public static int placeName;
	public static String timeName;
	

	static Scanner scan = new Scanner(System.in);
	
	//상영 날짜 목록 출력하는 메소드
	public void DataChoice(String movieName, String data) {
		
		
		
		String[] dateList = {"2020-05-18", "2020-05-19", "2020-05-20", "2020-05-21", "2020-05-22"};
		
		System.out.println();
		System.out.printf("'%s'을(를) 선택하였습니다. 날짜를 선택해주세요.\n", data);
		System.out.println("==============================");
		for(int i=0;i<dateList.length;i++) {
			System.out.printf("%d. %s\n", i+1, dateList[i]);
		}
		
		
		System.out.println("6. 뒤로가기");
		System.out.println("7. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		
		switch(num) {
		case 6:
			//뒤로가기
			break;
		//처음으로 가기
		case 7:
			MemberStart.First();
			break;
		//그 외 상영날짜를 선택한 경우
		default:
			numDate=dateList[num-1];
			TimeChoice(movieName, dateList[num-1]);
			break;
		}
	}
	
	
	//상영 시간 목록 출력하는 메소드
	public static void TimeChoice(String movieName, String date) {
		
		System.out.println();
		System.out.printf("%s를 선택하였습니다. 상영관과 시간을 선택해주세요.\n", date);
		System.out.println("==============================");
		
		int moviePlace = 0;
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\현재 상영 영화 목록.txt"));
			
			String line = null;
			
			try {
				while((line=reader.readLine()) != null) {
					String[] list = new String[4];
					list=line.split("■");
					
					if(list[1].equals(movieName)) {
						moviePlace = Integer.parseInt(list[3]);
						placeName=moviePlace;
					}
				}
			} catch (IOException e) {
				System.out.println("파일 데이터가 존재하지 않습니다.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("현재 상영 영화 목록.txt 파일이 존재하지 않습니다.");
		}
		
		System.out.printf("1. %d 상영관 08:00\n", moviePlace);
		System.out.printf("2. %d 상영관 12:00\n", moviePlace);
		System.out.printf("3. %d 상영관 15:00\n", moviePlace);
		System.out.printf("4. %d 상영관 18:00\n", moviePlace);
		System.out.printf("5. %d 상영관 21:00\n", moviePlace);
		System.out.println("6. 뒤로가기");
		System.out.println("7. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		
		switch(num) {
		//뒤로가기
		case 6:
			break;
		//처음으로 돌아가기
		case 7:
			MemberStart.First();
			break;
		//그 외 상영관과 시간을 선택한 경우
		default:
			
			//상영관 , 시간 텍스트값 예매 내역 보기로 전해 주기 위한 텍스트추출 
			String[] timeList = {"08:00","12:00","15:00","18:00","21:00"};
			timeName=timeList[num-1];
			
			seatChoice( movieName,  date);
			break;
		}
		
	}
	
	
	//상영 좌석 선택하는 메소드
	public static void seatChoice(String movieName,  String date) {

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
		

			if(seatInput.equals("1")) {
			//뒤로가기
				TimeChoice(movieName,  date);
			
			
			
			
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
						seatName=seatInput;
						
						
						//좌석 입력 하였을 때 
						//성인,청소년,우대 각 인원수 입력 받아야 함.
						
						System.out.print("성인(명): ");
						scan = new Scanner(System.in);
						Pay.adultNum = scan.nextInt();
						
						if(Pay.adultNum > 10) {
							//10명 이상 입력하면 
							System.out.println("==============================");
							System.out.println("한번에 예매 할 수 있는 최대 인원수는 10명 입니다.");
							System.out.println("다시 입력해 주세요.");
							System.out.println("==============================");
							seatChoice(seatInput, seatInput);
							
						}
						
						System.out.print("청소년(명): ");
						scan = new Scanner(System.in);
						Pay.youthNum = scan.nextInt();
						
						if(Pay.youthNum > 10) {
							//10명 이상 입력하면 
							System.out.println("==============================");
							System.out.println("한번에 예매 할 수 있는 최대 인원수는 10명 입니다.");
							System.out.println("다시 입력해 주세요.");
							System.out.println("==============================");
							seatChoice(seatInput, seatInput);
							
						}
						
						
						System.out.print("우대 (명) *어린이[7~10살], 노인[65~100세]* : ");
						scan = new Scanner(System.in);
						Pay.oldNum = scan.nextInt();
						
						if(Pay.oldNum > 10) {
							//10명 이상 입력하면 
							System.out.println("==============================");
							System.out.println("한번에 예매 할 수 있는 최대 인원수는 10명 입니다.");
							System.out.println("다시 입력해 주세요.");
							System.out.println("==============================");
							seatChoice(seatInput, seatInput);
							
						}
						
						
						
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
			
			if(  !seatInput.contains(list) ) {
				//존재 하지 않는 좌석 입력 하였을 때 
				System.out.println("좌석번호를 잘못 입력하였습니다.");
				System.out.println("다시 입력해 주세요 .");
				seatChoice(movieName,  date);
				
				
			} else if( seatInput.equals(seat[a][b]) ) {
				//이미 예매 된 좌석을 선택 했을 때 
				System.out.println("이미 예매 된 좌석을 선택 하였습니다.");
				System.out.println("다시 입력해 주세요.");
				seatChoice(movieName,  date);
			}
			
			
			
			
		}//else 
		
		

	}//seatChoice

	public static void MoviePaymentMenu() {}



	
}
