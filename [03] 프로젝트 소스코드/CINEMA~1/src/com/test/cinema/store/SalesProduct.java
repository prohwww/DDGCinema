package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesProduct {

	public void pSales() throws Exception {

		Scanner scan = new Scanner(System.in);
		System.out.println("==================================================================");
		System.out.println("[상품번호]\t[종류]\t\t[상품이름]\t\t[가격]\t\t[판매량]\t[매출액]");
		System.out.println("==================================================================");

		//File file = new File("‪C:\\DDGCinema_data\\상품 목록.txt");
		File file = new File("C:\\DDGCinema_data\\상품 목록.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));

		ArrayList<String> list = new ArrayList<String>();
		String line = null;

		while ((line = reader.readLine()) != null) {

			//상품번호
			String[] product = new String[6];
			product = line.split("■");
			int a = Integer.parseInt(product[4]);
			int b = Integer.parseInt(product[5]);

			System.out.printf("%s\t\t%s\t\t%s\t\t%,d원\t\t%,d개\t\t%,d원\n", product[0], product[1]
						,product[2],Integer.parseInt(product[3]), Integer.parseInt(product[4]), a * b);

		}
		
		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			SalesManagement s = new SalesManagement();
			s.sProduct();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
		}
	}
}
