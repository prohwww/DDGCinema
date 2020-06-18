package com.test.cinema.nonmember;

import java.util.Scanner;

import com.test.cinema.Join;
import com.test.cinema.member.RankMovie;

public class NonmemberStart {

	
//	public static void main(String[] args) {
//		nonFirst();
//	}
	
	//비회원 시작 페이지
	public static void nonFirst() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            비회원            ");
		System.out.println();
		System.out.println("==============================");
		System.out.println("1. 현재 상영작/상영관");
		System.out.println("2. 영화순위");
		System.out.println("3. 회원가입");
		System.out.println("4. 프로그램 종료");
		System.out.println("==============================");
		System.out.print("메뉴 : ");
		int num = scan.nextInt();
		
		switch(num) {
		//현재 상영작/상영관
		case 1:
			NonTicketing nt = new NonTicketing();
			nt.nonTicketingStart();
			break;
		//영화순위
		case 2:
			//Ranking.class
			RankMovie r = new RankMovie();
			try {
				r.rankmovie();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		//회원가입
		case 3:
			Join j = new Join();
			j.printJoin();
			break;
		//프로그램 종료
		case 4:
			System.out.println("프로그램 종료");
			break;
		}
		
		
	}
	
}

