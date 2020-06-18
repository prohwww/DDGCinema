package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Login;

public class SetMenu {

public static void SetMenu() throws Exception { //세트 목록 화면
		
		ArrayList <String> setMenuName = new ArrayList<String>();
		ArrayList <Integer> setMenuPrice = new ArrayList<Integer>();
		
	System.out.println("세트를 선택하셨습니다.구매하실 음식을 선택하여주세요.");
	System.out.println("==============================");
	
	
	
		try {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\상품_setlist.txt"));
		String line = null; //세트메뉴 목록 저장된 텍스트파일 출력
		
		
		int i =1;
		
		while((line = reader.readLine()) != null) {
			
			String[] setMenu = new String[10];
			setMenu = line.split("■");
			
			System.out.println(i+"."+setMenu[1]+"   "+setMenu[2]);
			i++;
			
			setMenuName.add(setMenu[1]);
			setMenuPrice.add((Integer.parseInt(setMenu[2])));
			
		}	

		
		
		System.out.println("5.뒤로가기\n6.처음으로가기\n");
		System.out.println("==============================");
		System.out.print("메뉴 선택:");
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		switch(num) { //세트메뉴 종류 선택 번호
		
		case 1:
			
			//선택 후 장바구니에 담겨서 출력되야함
			Cart.addList(setMenuName.get(0), setMenuPrice.get(0));
			break;
			
		case 2:
			
			Cart.addList(setMenuName.get(1), setMenuPrice.get(1));
			break;
			
		case 3:
			Cart.addList(setMenuName.get(2), setMenuPrice.get(2));
			break;
			
		case 4:
			Cart.addList(setMenuName.get(3), setMenuPrice.get(3));
			break;
		
				
		case 5 :
			//뒤로가기
			//상품보기 페이지로
//			ProductSearch p = new ProductSearch();
//			p.produckSearch(pName,pPrice);
			
		case 6 : 
			//처음으로가기
			MemberStart.First();
			
		default :
			System.out.println("올바른 메뉴번호를 입력하세요.");
			
		} 
		
	//	reader.close();
		
	} catch (Exception e) {
		
	 }//try-catch
	}

	
}//class
