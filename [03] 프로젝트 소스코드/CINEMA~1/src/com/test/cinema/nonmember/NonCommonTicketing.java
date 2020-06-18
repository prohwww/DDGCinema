package com.test.cinema.nonmember;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.test.cinema.Join;
import com.test.cinema.member.MemberStart;

public class NonCommonTicketing {

	static Scanner scan = new Scanner(System.in);
	
	//상영 날짜 목록 출력하는 메소드
	public void nonDataChoice(String movieName, String data) {
		
		
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
			NonmemberStart.nonFirst();
			break;
		//그 외 상영날짜를 선택한 경우
		default:
			nonTimeChoice(movieName, dateList[num-1]);
			break;
		}
	}
	
	
	//상영 시간 목록 출력하는 메소드
	public static void nonTimeChoice(String movieName, String date) {
		
		System.out.println();
		System.out.printf("%s를 선택하였습니다. 상영관과 시간을 확인해주세요.\n", date);
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
					}
				}
			} catch (IOException e) {
				System.out.println("파일 데이터가 존재하지 않습니다.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("현재 상영 영화 목록.txt 파일이 존재하지 않습니다.");
		}
		
		System.out.printf("%d상영관 08:00\n", moviePlace);
		System.out.printf("%d상영관 12:00\n", moviePlace);
		System.out.printf("%d상영관 15:00\n", moviePlace);
		System.out.printf("%d상영관 18:00\n", moviePlace);
		System.out.printf("%d상영관 21:00\n", moviePlace);
		System.out.println("==============================");
		System.out.println("예매하시려면 회원가입을 해주세요.");
		System.out.println("1. 회원가입하기");
		System.out.println();
		System.out.println("2. 뒤로가기");
		System.out.println("3. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		
		switch(num) {
		//회원가입하기
		case 1:
			Join j = new Join();
			j.printJoin();
			break;
		//뒤로가기
		case 2:
			break;
		//처음으로 가기
		case 3:
			NonmemberStart.nonFirst();
			break;
		}
		
	}
		
		
}

