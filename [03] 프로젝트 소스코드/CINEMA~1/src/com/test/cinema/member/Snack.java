package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Login;

public class Snack {

	public static void snack() throws Exception { //팝콘 목록 화면
		
		 ArrayList <String> snackName = new ArrayList<String>();
		 ArrayList <Integer> snackPrice = new ArrayList<Integer>(); 
		
		System.out.println("스낵을 선택하셨습니다.구매하실 음식을 선택하여주세요.");
		System.out.println("==============================");
		
		
		try {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\상품_snacklist.txt"));
		String line = null; //스낵 목록 저장된 텍스트파일 출력
		
		
		int i=1;
		
		while((line = reader.readLine()) != null) {
	
			String[] snack = new String[10];
			snack= line.split("■");
			System.out.println(i+"."+snack[1]+"   "+snack[2]);
			
			i++; //스낵 목록 콘솔창에 출력
			
			snackName.add(snack[1]);
			snackPrice.add((Integer.parseInt(snack[2])));
			
		}
		
		System.out.println("==============================");
		System.out.println("메뉴 입력:");
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		
		switch(num) { //스낵종류 선택 번호
		
		case 1:
			
			//선택 후 장바구니에 담겨서 출력
			Cart.addList(snackName.get(0),snackPrice.get(0));
			break;
			
		case 2:
			Cart.addList(snackName.get(1),snackPrice.get(1));
			break;
			
		case 3:
			Cart.addList(snackName.get(2),snackPrice.get(2));
			break;
			
		case 4:
			Cart.addList(snackName.get(3),snackPrice.get(3));
			break;
			
		case 5:
			Cart.addList(snackName.get(4),snackPrice.get(4));
			break;
			
		case 6:
			Cart.addList(snackName.get(5),snackPrice.get(5));
			break;
			
			
		case 7 :
			//뒤로가기
			//상품보기 페이지로
//			ProductSearch p = new ProductSearch();
//			p.produckSearch(pName, pPrice);
			
		case 8 : 
			
			//처음으로가기
			MemberStart.First();
			
		default :
			System.out.println("올바른 메뉴번호를 입력하세요.");
			
		} 
		
		
	//	reader.close();
		
	} catch (Exception e) {
		System.out.println(e);
	 //try-catch
	}

	}
	
	
}//class
