package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddProduct {

	// 상품 추가 메소드
	public void pAdd() {
		Scanner scan = new Scanner(System.in);

		System.out.println("==================================================================");
		System.out.print("종류 : ");
		String kind = scan.nextLine();
		System.out.print("상품이름 : ");
		String proname = scan.nextLine();
		System.out.print("가격 : ");
		String price = scan.nextLine();
		System.out.print("재고 : ");
		String stock = scan.nextLine();
		System.out.print("판매량 : ");
		String sales = scan.nextLine();

		ArrayList<String> list = new ArrayList<String>();

		//File file = new File("‪C:\\DDGCinema_data\\상품 목록.txt");
		File file = new File("C:\\DDGCinema_data\\상품 목록.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = null;

			try {
				while ((line = reader.readLine()) != null) {
					list.add(line);

				}
				reader.close();
				file.delete();

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for (String s : list) {

				writer.write(s);
				writer.newLine();
				list.stream().sorted();
			}
			String result = "";
			String pKind = "";
			String pName = "";
			String pStock = "";
			String pPrice = "";
			String pSales = "";
			int pNum = 0;

			//입력된 상품이 팝콘인 경우 상품 등록번호가 100부터
			if (kind.equals("팝콘")) {
				pNum = 100;
				++pNum;
				
				//상품이 음료인 경우 번호가 200부터
			} else if (kind.equals("음료")) {
				pNum = 200;
				++pNum;
				
				//상품이 스낵인경우 300부터
			} else if (kind.equals("스낵")) {
				pNum = 300;
				++pNum;
				
				//상품이 세트인경우 400부터
			} else if (kind.equals("세트")) {
				pNum = 400;
				++pNum;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

			pKind += kind + "■";
			pName += proname + "■";
			pStock += stock + "■";
			pPrice += price + "■";
			pSales += sales;

			result = pNum + "■" + pKind + pName + pPrice + pStock + sales;

			writer.write(result);

			writer.close();
			System.out.println("상품이 추가되었습니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			ProductManagement s = new ProductManagement();
			s.pSearch();
		} else if (input.equals("2")) {
			StoreStart a = new StoreStart();
			a.managerStart();
		}
	}
}
