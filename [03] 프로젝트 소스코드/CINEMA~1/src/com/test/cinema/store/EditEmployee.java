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

public class EditEmployee {

	// 직원 수정 메소드
	public void eEdit() {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> aList = new ArrayList<String>();
		String path = "C:\\DDGCinema_data\\직원정보.txt";

		File dir = new File(path);

		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// 직원 목록 리스트 출력
			System.out.println(
					"[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t\t[이메일주소]\t\t[직급]\t[월급]");
			try {
				while ((line = reader.readLine()) != null) {

					String[] list = new String[11];
					list = line.split("■");

					System.out.printf("%d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\n",
							Integer.parseInt(list[0]), list[1], Integer.parseInt(list[2]), list[3], list[4], list[5],
							list[6], list[7], list[8], Integer.parseInt(list[9]));
				}
			} catch (IOException e) {
				System.out.println("데이터를 찾을 수 없습니다.");
			}

		} catch (FileNotFoundException e) {
			System.out.println("txt파일을 찾을 수 없습니다.");
		}

		// 수정할 직원의 번호 입력받기
		System.out.println();
		System.out.println("==================================================================");
		System.out.print("수정할 직원 번호 입력 : ");
		String num = scan.nextLine();
		System.out.println("==================================================================");

		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			while ((line = reader.readLine()) != null) {
				String[] list = new String[10];
				list = line.split("■");

				// 직원을 수정한 경우 또는 수정하지 않은 경우
				Boolean flag = true;

				// 수정할 직원 번호와 같은 line을 찾은 경우
				if (list[0].equals(num)) {
					System.out.println("1. 이름 수정");
					System.out.println("2. 주소 수정");
					System.out.println("3. 휴대폰번호 수정");
					System.out.println("4. 이메일 수정");
					System.out.println("5. 직급 수정");
					System.out.println("6. 월급 수정");
					System.out.println("==================================================================");
					System.out.print("메뉴 선택 : ");
					int num1 = scan.nextInt();

					// 이름을 수정하는 경우
					if (num1 == 1) {
						System.out.print("수정할 이름 입력 : ");
						String name = scan.next();
						String temp = "";
						// 사용자가 입력한 이름으로 변경
						list[1] = name;

						temp += list[0] + "■" + list[1] + "■" + list[2] + "■" + list[3] + "■" + list[4] + "■" + list[5]
								+ "■" + list[6] + "■" + list[7] + "■" + list[8] + "■" + list[9];
						line = temp;

						aList.add(line);
						flag = false;
					}
					// 주소 수정하는 경우
					else if (num1 == 2) {
						System.out.print("수정할 주소 입력 : ");
						String address = scan.next();
						String temp2 = "";
						// 사용자가 입력한 주소로 변경
						list[5] = address;

						temp2 += list[0] + "■" + list[1] + "■" + list[2] + "■" + list[3] + "■" + list[4] + "■" + list[5]
								+ "■" + list[6] + "■" + list[7] + "■" + list[8] + "■" + list[9];
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
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\DDGCinema_data\\직원정보.txt"));

			for (String txt : aList) {
				writer.write(txt + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("txt파일을 생성할 수 없습니다.");
		}
		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			EmployeeManagement s = new EmployeeManagement();
			s.eManagement();
		} else if (input.equals("2")) {
			StoreStart a = new StoreStart();
			a.managerStart();
		}

	}

}
