package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TheaterSales {

	public static void tSales() {
		
	Scanner scan = new Scanner(System.in);
	
	int productStock = 0;	//상품판매량
	int productMoney = 0;	//상품매출액
	
	int movieStock = 0;		//영화판매량
	int movieMoney = 0;		//영화매출액
	
	try {
		//BufferedReader readerSale = new BufferedReader(new FileReader("‪C:\\DDGCinema_data\\상품 목록.txt"));
		BufferedReader readerSale = new BufferedReader(new FileReader("C:\\DDGCinema_data\\상품 목록.txt"));
		BufferedReader readerMovie = new BufferedReader(new FileReader("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt"));
		
		String line = null;
		
		//상품판매량&매출액 
		try {
			while((line = readerSale.readLine()) != null) {
				String[] list = new String[6];
				list = line.split("■");
				
				productStock += (Integer.parseInt(list[5]));
				productMoney += (Integer.parseInt(list[4]) * Integer.parseInt(list[3]));
				
			}
		} catch (IOException e) {
			System.out.println("상품 데이터가 없습니다.");
		}
		
		//영화판매량&매출액
		try {
			while((line = readerMovie.readLine()) != null) {
				String[] list = new String[5];
				list = line.split("■");
				
				movieStock += (Integer.parseInt(list[2]));
				movieMoney += (Integer.parseInt(list[2]) * 10000);
				
			}
		} catch (IOException e) {
			System.out.println("영화 데이터가 없습니다.");
		}
		
	} catch (FileNotFoundException e) {
		System.out.println("txt파일을 찾을 수 없습니다.");
	}
	
	
	//총 판매량&매출액 출력
	System.out.println();
	System.out.println("           총 판매량&매출액          ");
	System.out.println();
	System.out.println("==================================================================");
	System.out.println("[영화 판매량]\t\t[상품 판매량]\t\t[총 판매량]");
	System.out.printf("%,d개\t\t%,d개\t\t%,d개\n", movieStock, productStock, movieStock + productStock);
	System.out.println();
	System.out.println("[영화 매출액]\t\t[상품 매출액]\t\t[총 매출액]");
	System.out.printf("%,d원\t\t%,d원\t\t%,d원\n", movieMoney, productMoney, movieMoney + productMoney);
	System.out.println("==================================================================");
	System.out.println("1. 뒤로가기");
	System.out.println("2. 처음으로 가기");
	System.out.println("==================================================================");
	int num = scan.nextInt();
	
	switch(num) {
	//뒤로가기
	case 1:
		SalesManagement sm = new SalesManagement();
		sm.sProduct();
		break;
	//처음으로 가기
	case 2:
		StoreStart.managerStart();
		break;
	}
	
}
}
