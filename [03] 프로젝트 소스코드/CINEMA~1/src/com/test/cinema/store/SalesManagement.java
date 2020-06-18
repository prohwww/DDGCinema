package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesManagement {

	Scanner scan = new Scanner(System.in);

	public void sProduct() {

		System.out.println("==================================================================");
		System.out.println("1. 영화별 매출액");
		System.out.println("2. 상품별 매출액");
		System.out.println("3. 매장별 매출액");
		System.out.println("4. 뒤로가기");
		System.out.println("5. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();

		switch (num) {

		case 1:
			try {
				mSales();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			SalesProduct p = new SalesProduct();
			try {
				p.pSales();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			TheaterSales a = new TheaterSales();
			a.tSales();
			break;
		case 4:
			StoreStart.managerStart();
		case 5:
			StoreStart.managerStart();

		}
	}
	
	public void mSales() throws Exception {

		Scanner scan = new Scanner(System.in);
		System.out.println("==================================================================");
		System.out.println("[영화제목]\t\t[관람객수]\t[매출액]");
		System.out.println("==================================================================");

		File file = new File("C:\\DDGCinema_data\\매장_강남점 상영 영화 목록.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));

		ArrayList<String> list = new ArrayList<String>();
		String line = null;

		while ((line = reader.readLine()) != null) {

			String[] movie = new String[4];
			movie = line.split("■");
			int a = Integer.parseInt(movie[2]);

			System.out.printf("%s\t\t%10s명\t\t%,d원\n", movie[1], movie[2], a * 10000);

		}

		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			sProduct();
		} else if (input.equals("2")) {
			StoreStart.managerStart();

		}
	}
}
