package com.test.cinema.nonmember;

import java.util.Scanner;

import com.test.cinema.Join;
import com.test.cinema.Start;
import com.test.cinema.member.MemberStart;
import com.test.cinema.member.MovieTheater;

public class NonTicketing {

	public static void nonTicketingStart() {
		 
		System.out.println();
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1. 현재 상영작");
		System.out.println("2. 상영관 별 상영작 보기");
		System.out.println("3. 회원가입");
		System.out.println("4. 처음으로 가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
		Scanner scan = new Scanner(System.in);
	
		int num = scan.nextInt();
		
		switch(num) {
		//현재 상영작
		case 1:
			NonMovieTheater.nonMovieChoice();
			//현재 상영작 출력 , 회원가입 or 뒤로가기 
			
			
			break;
		//상영관 별 상영작 보기
		case 2:
			NonMovieTheater.nonTheaterChoice();
			break;
		//회원가입
		case 3:
			Join j = new Join();
			j.printJoin();
			break;
		//처음으로 가기
		case 4:
			NonmemberStart.nonFirst();
			break;
		}
		
		scan.close();
	}
	
}
