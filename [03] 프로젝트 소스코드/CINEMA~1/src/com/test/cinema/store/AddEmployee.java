package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class AddEmployee {

	// 직원 추가 메소드
	public void eAdd() {

		Scanner scan = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		int count = 0;

		System.out.println("==================================================================");
		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("주민등록번호 '-'을 포함해서 입력해주세요 : ");
		String number = scan.nextLine();

		System.out.print("주소 : ");
		String address = scan.nextLine();

		System.out.print("전화번호 '-'을 포함해서 입력해주세요 : ");
		String phone = scan.nextLine();

		System.out.print("이메일 : ");
		String email = scan.nextLine();

		System.out.print("직급 : ");
		String position = scan.nextLine();

		//직원 목록 받아오기
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("C:\\DDGCinema_data\\직원정보.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = null;

			//줄을 받아올때마다 count을 누적시킨다.
			try {
				while ((line = reader.readLine()) != null) {
					list.add(line);
					count++;

					String[] list1 = new String[11];
					list1 = line.split("■");
				}
				reader.close();
				file.delete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(file));
				for (String s : list) {

					writer.write(s);
					writer.newLine();

				}
				//줄 작성이 다 끝나면 count을 누적
				count++;

				String aName = "";
				String aNumber = "";
				String aAddress = "";
				String aPhone = "";
				String aPosition = "";
				String result = "";
				int aAge = 0;
				String aGender = "";
				String aEmail = "";
				String aMoney = "";

				// 주민등록번호 012345-7890000 7번째 자리 유효성 검사
				if (number.substring(7, 8).equals("1") || number.substring(7, 8).equals("3")
						|| number.substring(7, 8).equals("5") || number.substring(7, 8).equals("7")
						|| number.substring(7, 8).equals("9")) {

					// 홀수면 남자
					aGender = "남자■";

				} else {
					// 짝수면 여자
					aGender = "여자■";
				}

				// 주민번호의 맨 앞자리가 0이면 앞에 20을 추가 ex) 00-> 2000
				if (number.charAt(0) == '0') {

					int year1 = Integer.parseInt("20" + number.substring(0, 2));

					aAge = (c.get(Calendar.YEAR)) - year1 + 1;
					System.out.println(c.get(Calendar.YEAR));
					// 주민등록번호의 맨 앞자리가 0이 아니면 앞에 19를 추가 ex) 99 -> 1999
				} else {

					int year2 = Integer.parseInt("19" + number.substring(0, 2));

					aAge = (c.get(Calendar.YEAR)) - year2 + 1;
				}

				// 직급에 따른 월급 계산
				if (position.equals("매니저")) {

					aMoney = "300";
				} else if (position.equals("직원")) {

					aMoney = "200";
				} else if (position.equals("계약직")) {

					aMoney = "150";
				} else {
					System.out.println("직급을 잘못 입력하였습니다.");
				}

				aName += name + "■";
				aNumber += number + "■";
				aAddress += address + "■";
				aPhone += phone + "■";
				aPosition += position + "■";
				aEmail += email + "■";

				result = count + "■" + aName + aAge + "■" + aGender + aNumber + aAddress + aPhone + aEmail + aPosition
						+ aMoney;

				writer.write(result);
				writer.close();
				System.out.println("직원이 추가되었습니다..");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			EmployeeManagement s = new EmployeeManagement();
			s.eManagement();
		} else if (input.equals("2")) {
			StoreStart a = new StoreStart();
			a.managerStart();
		}

	}
}
