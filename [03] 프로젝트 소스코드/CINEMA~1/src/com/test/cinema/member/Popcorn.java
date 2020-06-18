package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Login;

public class Popcorn {

	public static void popcorn() throws Exception { //팝콘 목록 화면
		
		ArrayList <String> popcornName = new ArrayList<String>();
		ArrayList <Integer> popcornPrice = new ArrayList<Integer>();
		
		System.out.println("팝콘을 선택하셨습니다.구매하실 음식을 선택하여주세요.");
		System.out.println("==============================");
		
		
		try {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\상품_popcornlist.txt"));
		String line = null; //팝콘 목록 저장된 텍스트파일 출력
		
		
		int i =1;
		
		while((line = reader.readLine()) != null) {
			
			String[] popcorn = new String[10];
			popcorn = line.split("■");
			System.out.println(i+"."+popcorn[1]+"   "+popcorn[2]);
			
			i++; 
			//팝콘 목록 콘솔창에 출력
			
			popcornName.add(popcorn[1]); //팝콘종류 장바구니로 가져가기
			popcornPrice.add((Integer.parseInt(popcorn[2]))); //팝콘가격 장바구니로 가져가기
			
		}

		
		System.out.println("9.뒤로가기\n10.처음으로가기\n");
		System.out.println("==============================");
		System.out.print("메뉴 선택:");
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		
		
		switch(num) { //팝콘종류 선택 번호
		case 1:
			//선택 후 장바구니에 담겨서 출력
	
			Cart.addList(popcornName.get(0),popcornPrice.get(0));
			break;
			
		case 2:
			
			Cart.addList(popcornName.get(1),popcornPrice.get(2));
			break;
			
		case 3:
			
			Cart.addList(popcornName.get(2),popcornPrice.get(2));
			break;
			
		case 4:
			Cart.addList(popcornName.get(3),popcornPrice.get(3));
			break;
			
		case 5:
			Cart.addList(popcornName.get(4),popcornPrice.get(4));
			break;
			
		case 6:
			Cart.addList(popcornName.get(5),popcornPrice.get(5));
			break;
			
		case 7 :
			Cart.addList(popcornName.get(6),popcornPrice.get(6));
			break;
			
		case 8 :
			Cart.addList(popcornName.get(7),popcornPrice.get(7));
			break;
			
			
		case 9 :
			//뒤로가기
			//상품보기 페이지로
//			ProductSearch p = new ProductSearch();
//			p.produckSearch(pName,pPrice); 
			
		case 10 : 
			
			//처음으로가기
			MemberStart.First();
			
		default :
			System.out.println("올바른 메뉴번호를 입력하세요.");
			
		} 
		
	reader.close();
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	 }//try-catch
		
	}//popcorn

	

}//class
