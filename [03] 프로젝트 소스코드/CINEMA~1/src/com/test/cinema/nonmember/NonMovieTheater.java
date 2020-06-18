package com.test.cinema.nonmember;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.test.cinema.Join;
import com.test.cinema.member.CommonTicketing;
import com.test.cinema.member.MemberStart;

public class NonMovieTheater {

	//Case1
	//현재 상영 영화
	static void nonMovieChoice() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            현재 상영작            ");
		System.out.println();
		System.out.println("영화를 선택해주세요.");
		System.out.println("==============================");
		
		
	
		//영화 목록 번호 출력하기 위한 변수
		int num = 0;
		
		//영화 목록을 순서대로 저장하기 위한 list변수
		String[] movieNameList = new String[20];
		
		//현재 상영 영화 목록 읽어오기
		try {
			//BufferedReader reader = new BufferedReader(new FileReader("E:\\고객.직원.더미데이터\\현재 상영 영화 목록.txt"));
			BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\현재 상영 영화 목록.txt"));
		
			String line = null;

			//현재 상영 영화 목록 한줄씩 읽어오기
			try {
				while((line=reader.readLine()) != null) {
					int index1 = line.indexOf("■");
					int index2 = line.indexOf("■", index1+1);
					
					String movieName = line.substring(index1+1, index2);
					movieNameList[num] = movieName;
					num++;
					System.out.printf("%02d. %s\t\t", num, movieName);
					
					if(num % 2 == 0) {
						System.out.println();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		System.out.printf("%02d. 뒤로가기\n", ++num);
//		System.out.printf("%02d. 처음으로 가기\n", ++num);
		System.out.println("==============================");
		System.out.println("1. 회원가입");
		System.out.println("2. 뒤로가기");
		System.out.println("3. 처음으로 가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		
		switch(menu) {
		//회원가입
		case 1:
			Join j = new Join();
			j.printJoin();
			
		//뒤로가기
		case 2:
			return;
			
			//처음으로 가기
		case 3:
			NonmemberStart.nonFirst();
			break;

		}
	}
	


	
	//Case2
	//상영관 별 상영작 확인하는 메소드
	public static void nonTheaterChoice() {
		Scanner scan = new Scanner(System.in);
		
		String[] cityList = {"서울", "경기", "인천", "강원", "대전", "대구", "부산"};
		String[][] regionList = {{"강남점", "강변점", "건대입구점", "구로점", "대학로점", "동대문점"}
		,{"경기광주점", "판교점", "일산점", "구리점", "김포운양점", "동백점", "동탄점"}
		,{"계양점", "부평점", "인천점", "인천공항점", "청라점", "남주안점", "연수역점"}
		,{"강릉점", "원주점", "인제점", "춘천점", "춘천명동점"}
		,{"대전점", "보령점", "서산점", "세종점", "천안점", "청주점", "당진점"}
		,{"대구점", "대구수성점", "대구월성점", "대구칠곡점", "대구한일점"}
		,{"남포점", "대연점", "대한점", "동래점", "서면점", "해운대점"}};
		
		System.out.println();
		System.out.println("극장을 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1. 서울");
		System.out.println("2. 경기");
		System.out.println("3. 인천");
		System.out.println("4. 강원");
		System.out.println("5. 대전");
		System.out.println("6. 대구");
		System.out.println("7. 부산");
		System.out.println("8. 뒤로가기");
		System.out.println("9. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		int i=0;
		
		switch(num) {
		//뒤로가기
		case 8:
			break;
		case 9:
			MemberStart ms = new MemberStart();
			ms.First();
			break;
		default:
			System.out.println();
			System.out.printf("'%s'을 선택하였습니다. 영화관을 선택해주세요.\n", cityList[num-1]);
			System.out.println("==============================");
			for(i=0;i<regionList[num-1].length;i++) {
				//영화관 출력 
				System.out.printf("%d. %s\n", i+1, regionList[num-1][i]);
			}
			System.out.println("1. 뒤로가기\n");
			System.out.println("2. 처음으로 돌아가기\n");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
			int num1 = scan.nextInt();
			
			//뒤로가기
			if(num1 == --i) {
				break;
			} 
			//처음으로 가기
			else if(num1 == ++i) {
				NonmemberStart.nonFirst();
				break;
			}
			//그 외 지역을 선택한 경우, 지역 string값을 날짜 선택하는 함수의 인자로 보내준다.
			else {
				nonMovieChoice(regionList[num-1][num1-1]);
			}
			break;
		}
	}

	//상영관을 선택한 후의 영화 선택하는 메소
	public static void nonMovieChoice(String regionName) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.printf("'%s'을 선택하였습니다. 영화를 선택해주세요.\n", regionName);
		System.out.println("==============================");
		
		//영화 목록 번호 출력하기 위한 변수
		int num = 0;
		
		//영화 목록을 순서대로 저장하기 위한 list변수
		String[] movieNameList = new String[20];
		
		//현재 상영 영화 목록 읽어오기
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\현재 상영 영화 목록.txt"));
		
			String line = null;

			//현재 상영 영화 목록 한줄씩 읽어오기
			try {
				while((line=reader.readLine()) != null) {
					int index1 = line.indexOf("■");
					int index2 = line.indexOf("■", index1+1);
					
					String movieName = line.substring(index1+1, index2);
					movieNameList[num] = movieName;
					num++;
					System.out.printf("%02d. %s\t\t", num, movieName);
					
					if(num % 2 == 0) {
						System.out.println();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("==============================");
		System.out.println("1. 회원가입");
		System.out.println("2. 뒤로가기");
		System.out.println("3. 처음으로 가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		
		switch(menu) {
		
		case 1:
			//회원가입
			Join j = new Join();
			j.printJoin();
			
		//뒤로 가기
		case 2:
			NonmemberStart.nonFirst();
			break;
		
		case 3: 
			//처음
			NonmemberStart.nonFirst();
			break;
	
		}
		
	}
	
	
}
