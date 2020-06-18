package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Login;

public class Product {

	
//	public static void main(String[] args) throws Exception {
//		
////		ArrayList<String> pNamelist2 =new ArrayList<String>();
////		ArrayList<String> pName =new ArrayList<String>();
////		ArrayList<Integer> pPricelist2 =new ArrayList<Integer>();
////		ArrayList<Integer> pPrice =new ArrayList<Integer>();
//		
//		produck();
//		
//	}
	
	public static void produck() throws Exception {

		
		System.out.println("번호를 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1.상품보기\n2.뒤로가기\n3.처음으로가기");
		System.out.println("==============================");

		System.out.print("메뉴 선택:");
		
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		switch (num) {
		
		case 1:
			//상품보기 페이지로
			ProductSearch p = new ProductSearch();
			p.produckSearch(); 
			break;

			
		

		case 2:
			// 뒤로가기
			// 어디로가야하지..

		case 3:
			//처음으로가기
			MemberStart.First();

		default:
			System.out.println("올바른 메뉴번호를 입력하세요.");

		}// switch문 종료

	}// main

	


}// class product
