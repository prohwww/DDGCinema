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

public class DeleteProduct {

	// 상품 삭제 메소드
	public void pDelete() {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>();
		//File file = new File("‪C:\\DDGCinema_data\\상품 목록.txt");
		File file = new File("C:\\DDGCinema_data\\상품 목록.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line = null;

		System.out.println("==================================================================");
		System.out.println("[상품번호]\t[종류]\t\t[상품이름]\t\t[가격]\t[판매수]\t[재고량]");
		try {
			while ((line = reader.readLine()) != null) {
				list.add(line);

				String[] pro = new String[7];
				pro = line.split("■");

				// 상품 목록 출력
				System.out.printf("%6s\t\t%s\t%15s\t\t%,5d원\t%,5d개\t\t%,5d개", Integer.parseInt(pro[0]), pro[1], pro[2],
						Integer.parseInt(pro[3]), Integer.parseInt(pro[4]), Integer.parseInt(pro[5]));

				System.out.println();

			}
			reader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		line = null;
		reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println("==================================================================");
			System.out.println("삭제할 상품 번호를 입력하세요.");
			System.out.println("==================================================================");
			System.out.print("상품 번호 입력 : ");
			String num = scan.nextLine();

			// list를 초기화
			list.clear();

			while ((line = reader.readLine()) != null) {

				String[] product = new String[7];
				product = line.split("■");

				// 상품 번호가 일치하면 list에 누적을 안한다.
				if (product[0].equals(num)) {

					// 불일치하면 list에 누적
				} else {
					list.add(line);
				}
			}
			System.out.println("상품이 삭제되었습니다.");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for (String s : list) {
				writer.write(s + "\r\n");

			}
			writer.close();
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
