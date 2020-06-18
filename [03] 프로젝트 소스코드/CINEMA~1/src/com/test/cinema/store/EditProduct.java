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

public class EditProduct {

	// 상품 수정 메소드
	public void pEdit() {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> aList = new ArrayList<String>();
		//String path = "‪C:\\DDGCinema_data\\상품 목록.txt";
		String path = "C:\\DDGCinema_data\\상품 목록.txt";

		File dir = new File(path);

		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// 상품 목록 리스트 출력
			System.out.println("[번호]\t\t[종류]\t\t[이름]\t\t[가격]\t\t[판매량]\t\t[재고]");
			try {
				while ((line = reader.readLine()) != null) {

					String[] list = new String[6];
					list = line.split("■");

					System.out.printf("%s\t\t%s\t\t%s\t\t%,d원\t\t%,d개\t\t%,d개\n", list[0], list[1], list[2],
							Integer.parseInt(list[3]), Integer.parseInt(list[4]), Integer.parseInt(list[5]));
				}
			} catch (IOException e) {
				System.out.println("데이터를 찾을 수 없습니다.");
			}

		} catch (FileNotFoundException e) {
			// System.out.println("txt파일을 찾을 수 없습니다.");
		}

		// 수정할 상품의 이름or번호 입력받기
		System.out.println();
		System.out.println("==============================");
		System.out.print("수정할 상품 번호 입력 : ");
		String num = scan.nextLine();
		System.out.println("==============================");

		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			while ((line = reader.readLine()) != null) {
				String[] list = new String[6];
				list = line.split("■");

				// 가격을 수정한 경우 또는 수정하지 않은 경우
				Boolean flag = true;

				// 수정할 상품 번호와 같은 line을 찾은 경우
				if (list[0].equals(num)) {
					System.out.println("==================================================================");
					System.out.println("1. 가격 수정");
					System.out.println("2. 재고 수정");
					System.out.println("==================================================================");
					System.out.print("메뉴 선택 : ");
					int num1 = scan.nextInt();

					// 가격을 수정하는 경우
					if (num1 == 1) {
						System.out.print("수정할 가격 입력 : ");
						String price = scan.next();
						String temp = "";
						// 사용자가 입력한 수정 가격으로 변경
						list[3] = price;

						temp += list[0] + "■" + list[1] + "■" + list[2] + "■" + list[3] + "■" + list[4] + "■" + list[5];
						line = temp;

						aList.add(line);
						flag = false;
					}
					// 재고 수정하는 경우
					else if (num1 == 2) {
						System.out.print("수정할 재고 입력 : ");
						String stock = scan.next();
						String temp2 = "";
						// 사용자가 입력한 수정 가격으로 변경
						list[5] = stock;

						temp2 += list[0] + "■" + list[1] + "■" + list[2] + "■" + list[3] + "■" + list[4] + "■"
								+ list[5];
						line = temp2;

						aList.add(line);
						flag = false;
					}

				} // if문

				if (flag) {
					aList.add(line);
				}

			}

			reader.close();

		} catch (IOException e) {
			System.out.println("데이터를 찾을 수 없습니다.");
		}

		dir.delete();

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\DDGCinema_data\\상품 목록.txt"));

			for (String txt : aList) {
				writer.write(txt + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("txt파일을 생성할 수 없습니다.");
		}

	}

}
