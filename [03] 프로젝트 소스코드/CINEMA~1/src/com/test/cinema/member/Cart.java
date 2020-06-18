package com.test.cinema.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cart {
	private static ArrayList <String> pNamelist =  new ArrayList<String>(); //내가 선택한 상품종류만 불러온거
	private static ArrayList <Integer> pPricelist =  new ArrayList<Integer>(); //내가 선택한 상품가격만 불러온거
	private static HashMap<String,Integer> pCount =  new HashMap<String,Integer>(); 
	
//	private static ArrayList<String>pName = new ArrayList<String>();
	static String pName = " ";
	static int pPrice=0;
//	private static ArrayList<Integer>pPrice = new ArrayList<Integer>();
	
	
	public static void addList(String pName, Integer pPrice)throws Exception  { //장바구니 역할
		

		
		pNamelist.add(pName);
		pPricelist.add(pPrice);
		

		
		for (int i=0; i<pNamelist.size(); i++) {
			
			System.out.printf("[%s]",pNamelist.get(i));
			
			
		}
		
		
		
		System.out.println("이 담겨있습니다.");
		System.out.println("번호를 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1.결제하기");
		System.out.println("2.추가 구매 하기");
		System.out.println("3.뒤로가기");
		System.out.println("4.처음으로가기");
		System.out.println("==============================");
		System.out.println("메뉴 입력:");
		
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		switch(num) {
		
		case 1:
			//결제 화면으로
			ProduckPay sp = new ProduckPay();
			sp.produckPay(pNamelist, pPricelist,pName,pPrice);
//			pNamelist.clear();
//			pPricelist.clear();
			
			break;
			
		case 2:
			
			//상품 목록 화면으로
			ProductSearch ps = new ProductSearch();
			ps.produckSearch();
			
			break;
			
		case 3:
			//뒤로가기
			break;
			
		case 4:
			//처음으로가기
			//처음으로 갈때 장바구니 초기화 
			
//			pNamelist.clear();
//			pPricelist.clear();
			
//			for(int i=0; i<pNamelist.size(); i++) {
//				pNamelist.add(0, " ");
//				}
//			
//			for(int j=0; j<pPricelist.size(); j++) {
//				pPricelist.add(0);
//			}
			
			MemberStart.First();
			
			
			break;
			
		default :
			System.out.println("올바른 번호를 입력하세요.");
			
		}
		
		
	}//addList
	
	

	
	
	}//class-cart
