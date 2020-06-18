package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchProduct {

	//상품 목록 조회 메소드
	public void pCheck() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		//상품 목록 읽어오기
		//File file = new File("C:\\DDGCinema_data\\상품 목록.txt");

		File file = new File("C:\\DDGCinema_data\\상품 목록.txt");
		
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			System.out.println("텍스트 파일을 찾을 수 없습니다.");
			e1.printStackTrace();
		}
		String line = null;

		System.out.println("==================================================================");
		System.out.println("[상품번호]\t[종류]\t\t[상품이름]\t\t[가격]\t[판매수]\t[재고량]");
		try {
			while ((line = reader.readLine()) != null) {
				list.add(line);

				String[] pro = new String[6];
				pro = line.split("■");
				

				System.out.printf("%6s\t\t%s\t%15s\t\t%,5d원\t%,5d개\t\t%,5d개", Integer.parseInt(pro[0]), pro[1], pro[2]
																, Integer.parseInt(pro[3]), Integer.parseInt(pro[4]), Integer.parseInt(pro[5]));

				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("에러");
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
			StoreStart.managerStart();
		}
	}

}
