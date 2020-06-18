package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Login;

public class ProductSearch {

	public static void produckSearch() throws Exception  { //상품보기 페이지
	
	System.out.println("상품보기를 선택하셨습니다.카테고리를 선택하여주세요.");
	System.out.println("==============================");	
	System.out.println("1.팝콘\n2.스낵\n3.음료\n4.세트메뉴\n5.뒤로가기\n6.처음으로가기\n");
	System.out.println("==============================");
	System.out.print("메뉴 선택:");
	
	
	Scanner scan = new Scanner(System.in);
	int num = scan.nextInt();
	scan.skip("\r\n");
	
	//addList(ArrayList<String>pNamelist2,ArrayList<String>pPricelist2,String pName,int pPrice)
	
	
	switch(num) {
	case 1:
		//팝콘목록 화면으로
		Popcorn p = new Popcorn();
		p.popcorn();
		
		//팝콘 목록 메소드호출하기
		
		break;
		
	case 2:
		//스낵목록 화면으로
		Snack s= new Snack();
		s.snack();
		
		break;
		
	case 3:
		//음료목록 화면으로
		Drink d= new Drink();
		d.drink();
		break;
		
	case 4:
		//세트메뉴 화면으로
		SetMenu set = new SetMenu();
		set.SetMenu();
		break;
		
	case 5:
		//뒤로가기
		//아직 안만듬!!!!!
		
	case 6:
		//처음으로가기
		MemberStart.First();
		
	default :
		System.out.println("올바른 메뉴번호를 입력하세요.");
	}
	
	
	
	}//main
	
	


}//class