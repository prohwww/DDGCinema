package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProduckPay {
	
	
	private static ArrayList <String> pNamelist =  new ArrayList<String>(); //내가 선택한 상품종류만 불러온거
	private static ArrayList <Integer> pPricelist =  new ArrayList<Integer>(); //내가 선택한 상품가격만 불러온거
	private static ArrayList <String> pNamelist2 =  new ArrayList<String>(); //내가 선택한 상품종류만 불러온거
	private static ArrayList <Integer> pPricelist2 =  new ArrayList<Integer>(); //내가 선택한 상품가격만 불러온거
	private static HashMap<String,Integer> pCount =  new HashMap<String,Integer>(); 
	
	public static void produckPay(ArrayList<String> pNamelist2, ArrayList<Integer> pPricelist2,String pName,int pPrice) throws Exception {

//		System.out.println(pNamelist2);
//		System.out.println(pPricelist2);
//	
	System.out.println("결제하기를 선택하셨습니다.선택한 목록을 확인하세요.");
	System.out.println("------------------------------");
	System.out.println("[상품 이름]\t\t[상품 가격]\t\t[수량]");
	System.out.println("------------------------------");
	
	
	
	int sum =0;
	int count = 0;
	
	pCount.put("고소팝콘L", count);
	pCount.put("고소팝콘M", count);
	pCount.put("달콤팝콘L", count);
	pCount.put("달콘팝콘M", count);
	pCount.put("더블치즈팝콘L", count);
	pCount.put("다블치즈팝콘M", count);
	pCount.put("바질어니언팝콘L", count);
	pCount.put("바질어니언팝콘M", count);
	pCount.put("크리미갈릭핫도그", count);
	pCount.put("칠리치즈나쵸", count);
	pCount.put("플레인핫도그", count);
	pCount.put("칠리치즈핫도그", count);
	pCount.put("맛밤", count);
	pCount.put("오징어(완제품)", count);
	pCount.put("아메리카노HOT", count);
	pCount.put("아메리카노ICE", count);
	pCount.put("아이스티M", count);
	pCount.put("탄산음료L", count);
	pCount.put("팝콘(L)1+탄산음료(M)2", count);
	pCount.put("팝콘(M)2+탄산음료(M)2", count);
	pCount.put("팝콘(M)1+탄산음료(M)1", count);
	pCount.put("팝콘(L)2+탄산음료(L)2", count);
	pCount.put("맥주", count);
	
	
	
	
	for (int i=0; i<pNamelist2.size(); i++) {
		
		//지금 선택한 상품이름이 해쉬멥에 value값에 들어있는지 확인.
		if(pCount.containsKey(pNamelist2.get(i))) {

			//같은 상품 있으면 수량 ++;
			pCount.put(pNamelist2.get(i), pCount.get(pNamelist2.get(i))+1);
			

		}
		
		if(pCount.get(pNamelist2.get(i)) > 0) {
			
			//상품 , 가격 , 수량 출력 
//			System.out.println(pNamelist2.get(i)+"\t"+pPricelist2.get(i)+"\t\t"+pCount.get(pNamelist2.get(i)));
			System.out.printf("%-10s\t%-10s\t%-10s\n",pNamelist2.get(i), pPricelist2.get(i),  pCount.get(pNamelist2.get(i))  );
			
			
		}
				sum += pPricelist2.get(i);
				Pay.productTotalPay = sum;	//상품 총 합 
				//System.out.println("::::::::::::::"+Pay.productTotalPay);
				
				
		
	}//for문
	
	
	System.out.print("[합계]\t\t");
	System.out.println(sum);
	//System.out.println(count);
	
	System.out.println("------------------------------");
	System.out.println();
	System.out.println("1.카드결제");
	System.out.println("2.뒤로가기");
	System.out.println("3.처음으로가기");
	System.out.println("==============================");
	System.out.print("메뉴 입력:");
	
	Scanner scan = new Scanner(System.in);
	int num = scan.nextInt();
	scan.skip("\r\n");
	
	switch(num) {
	
	case 1:
		//결제 화면으로
		Pay.payPayProduct();
	
		break;
		
	
	case 2:
		//뒤로가기
		//상품보기 페이지로
		ProductSearch p = new ProductSearch();
		p.produckSearch(); 
		break;
		
	case 3:
	
		//처음으로가기
		MemberStart.First();
		break;
		
	default :
		System.out.println("올바른 번호를 입력하세요.");
		
	}
	
	
	
}//produckPay



}//class
