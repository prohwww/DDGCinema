package com.test.cinema;

import java.io.IOException;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;
import com.test.cinema.nonmember.NonmemberStart;


public class Start {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		while (true) {

			String asciiArt1;
			try {
				asciiArt1 = FigletFont.convertOneLine("DDG CINEMA");
				System.out.println(asciiArt1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("============================================================");
			System.out.println("		  1. 회원 로그인");
			System.out.println("		  2. 비회원 로그인");
			System.out.println("		  3. 회원가입");
			System.out.println("		  4. 프로그램 종료");
			System.out.println("============================================================");
			System.out.print("		  메뉴 선택 : ");

			int num = scan.nextInt();
			scan.skip("\r\n");
			

			switch (num) {
			case 1:
				Login l = new Login();
				l.printLogin();
				break;
			case 2:
				NonmemberStart.nonFirst();
				break;
			case 3:
				Join j = new Join();
				j.printJoin();
				break;
			case 4:
				return;
			}

		}//while
	}
	
}
