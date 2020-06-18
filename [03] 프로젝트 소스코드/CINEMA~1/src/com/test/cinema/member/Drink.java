package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.test.cinema.Login;
import com.test.cinema.Member;

public class Drink {

	public static void drink() throws Exception { //음료 목록 화면
		
		ArrayList <String> drinkName = new ArrayList<String>();
		ArrayList <Integer> drinkPrice = new ArrayList<Integer>(); 
		
		System.out.println("음료를 선택하셨습니다.구매하실 음식을 선택하여주세요.");
		System.out.println("==============================");
		
		
		
		try {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\상품_drinklist.txt"));
		String line = null; //음료 목록 저장된 텍스트파일 출력
		
		
		int i =1;
		
		while((line = reader.readLine()) != null) {
			
			String[] drink = new String [10];
			drink= line.split("■");
			System.out.println(i+"."+drink[1]+"   "+drink[2]);
			i++;
			
			drinkName.add(drink[1]);
			drinkPrice.add((Integer.parseInt(drink[2])));
		}	

		
		System.out.println("7.뒤로가기\n8.처음으로가기\n");
		System.out.println("==============================");
		System.out.print("메뉴 선택:");
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		
		switch(num) { //음료종류 선택 번호
		
		case 1:
			//선택 후 장바구니에 담겨서 출력
			Cart.addList(drinkName.get(0), drinkPrice.get(0));
			break;
			
		case 2:
			Cart.addList(drinkName.get(1), drinkPrice.get(1));
			break;
		case 3:
			Cart.addList(drinkName.get(2), drinkPrice.get(2));
			break;
			
		case 4:
			Cart.addList(drinkName.get(3), drinkPrice.get(3));
			break;
		case 5:
			Cart.addList(drinkName.get(4), drinkPrice.get(5));
			break;
		case 6:
			
			//맥주! 미성년자는 구매 못함!
			
			ageCheck();
			Cart.addList(drinkName.get(5), drinkPrice.get(5));
			break;
			
			
			
		case 7 :
			//뒤로가기
			//상품보기 페이지로
			ProductSearch p = new ProductSearch();
			p.produckSearch();
			
			
		case 8 : 
			//처음으로가기
			MemberStart.First();
			
		default :
			System.out.println("올바른 메뉴번호를 입력하세요.");
			
		} 
		
	//	reader.close();
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	 }//try-catch
	}
	
	
	
	
	
	public static Boolean ageCheck() {
		//Member m = new Member();
		
		String age = Member.getmJumin();	//age = 960212-2323232
//		int born= Integer.parseInt(age.substring(0,2));		//aa=96
		String born= age.substring(0,2);		//aa=96
		
		Calendar now = Calendar.getInstance();
		//int result = now.get(Calendar.YEAR) - ((Integer.parseInt(age.substring(7,8)) >= 1 && Integer.parseInt(age.substring(7,8)) <= 2) ? 1900 : 2000) - born;
		//int result =  (   (Integer.parseInt(age.substring(7,8)) >= 1 && Integer.parseInt(age.substring(7,8)) <= 2) ? 19 : 20)  ;
		String result;
		//System.out.println("첫번쨰 result::"+result);
		
		//첫번째 자리 0 이면 + "20" 
		// 그 외는 +"19" 
		
		int index = born.indexOf("0");
		if(index == 0) {
			//첫번째 값이 0이면  20년도 생 ~ 
			result = "20"+born;
			
		} else {
			result = "19"+born;
		}
		
		//2020-출생년도
		int realAge = now.get(Calendar.YEAR) - Integer.parseInt(result);
		
		
		
		
		String yearString = (result +"") + (born );	//2004년생
		//System.out.println("몇년생?::"+yearString);
		
		
		
		//result = now.get(Calendar.YEAR)- Integer.parseInt(yearString);	// 2020 - 2004
		//System.out.println("몇살>:::"+result);
		
		
		
		
		
		//나이
		System.out.printf("고객님의 나이는 %d세 입니다.\n",realAge);
		
		if(realAge >= 19) {
			//성인인 경우
			System.out.println("성인입니다. 계속 상품구매를 진행해주세요.");
			System.out.println();
			//상품이 담긴 페이지로
			
			return true;
			
		} else {
			System.out.println("※미성년자는 구매하실 수 없습니다.※ 다시 선택해주세요.");
			//미성년인 경우
			//상품 제일 처음페이지로, 새로 다시 다 담아야함!
			Product p =new Product();
			try {
				p.produck();
				//p.produck(pNamelist2, pPricelist2, pNamelist2, pPricelist2);
			} catch (Exception e) {
				
				
			}
			return false;
		}
	}
	
	
}//class
