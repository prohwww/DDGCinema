package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEmployee {

	Scanner scan = new Scanner(System.in);

	public void eSearch() {


	
		//직원 정보 불러오기
		ArrayList<String> aList = new ArrayList<String>();
		String path = "C:\\DDGCinema_data\\직원정보.txt";

		File dir = new File(path);

		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// 직원 목록 리스트 출력
			System.out
					.println("[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t\t[이메일주소]\t\t[직급]\t[월급]");
			try {
				while ((line = reader.readLine()) != null) {

					String[] alist = new String[11];
					alist = line.split("■");

					System.out.printf("%d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\n", Integer.parseInt(alist[0]), alist[1], Integer.parseInt(alist[2])
							, alist[3], alist[4], alist[5], alist[6], alist[7], alist[8], Integer.parseInt(alist[9]));
				}
			} catch (IOException e) {
				System.out.println("데이터를 찾을 수 없습니다.");
			}

		} catch (FileNotFoundException e) {
			System.out.println("txt파일을 찾을 수 없습니다.");
		}
		System.out.println("==================================================================");
		System.out.println("1. 이름 검색");
		System.out.println("2. 주민등록번호 검색");
		System.out.println("3. 주소 검색");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 직급 검색");
		System.out.println("6. 뒤로가기");
		System.out.println("7. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		int num = scan.nextInt();

		switch (num) {

		case 1:
			eNameSearch();
			break;
		case 2:
			eRrn();
			break;
		case 3:
			eAddress();
			break;
		case 4:
			ePhone();
			break;
		case 5:
			ePosition();
			break;
		case 6:
			EmployeeManagement n = new EmployeeManagement();
			n.eManagement();
			break;
		case 7:
			StoreStart.managerStart();
			break;
		}
	}

	// 이름으로 직원 검색 메소드
	public void eNameSearch() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 직원 정보 목록 읽어오기
			File file = new File("C:\\DDGCinema_data\\직원정보.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 직원 이름을 입력하세요.");
			System.out.print("직원 이름 : ");
			String name = scan.nextLine();

			System.out.println(
					"[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t[이메일주소]\t\t[직급]\t[월급]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 직원번호■이름■나이■성별■주민등록번호■주소■휴대폰번호■이메일■직급■월급
				String[] eName = new String[11];
				eName = line.split("■");

				if (eName[1].equals(name)) {

					System.out.printf("%5d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t%-10s\t\t%s\t%s\t%s\n",
							Integer.parseInt(eName[0]), eName[1], Integer.parseInt(eName[2]), eName[3], eName[4],
							eName[5], eName[6], eName[7], eName[8], Integer.parseInt(eName[9]));
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			eSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
			
		}

	}

	// 주민등록번호로 직원 검색
	public void eRrn() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 주민등록번호로 직원 검색
			File file = new File("C:\\DDGCinema_data\\직원정보.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 주민등록번호를 입력하세요.");
			System.out.print("주민번호 앞6자리 : ");
			String rrn = scan.nextLine();

			System.out.println(
					"[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t[이메일주소]\t\t[직급]\t[월급]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 직원번호■이름■나이■성별■주민등록번호■주소■휴대폰번호■이메일■직급■월급
				String[] eRrn = new String[11];
				eRrn = line.split("■");

				if (eRrn[4].substring(0, 6).equals(rrn)) {

					System.out.printf("%5d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t\t%-10s\t\t%s\t%s\t%s\n",
							Integer.parseInt(eRrn[0]), eRrn[1], Integer.parseInt(eRrn[2]), eRrn[3], eRrn[4], eRrn[5],
							eRrn[6], eRrn[7], eRrn[8], Integer.parseInt(eRrn[9]));
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println(
				"============================================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			eSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
			
		}
	}

	// 주소로 직원 검색
	public void eAddress() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			File file = new File("C:\\DDGCinema_data\\직원정보.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 주소를 입력하세요.");
			System.out.print("주소 입력 : ");
			String address = scan.nextLine();

			System.out.println(
					"[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t[이메일주소]\t\t[직급]\t[월급]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 직원번호■이름■나이■성별■주민등록번호■주소■휴대폰번호■이메일■직급■월급
				String[] eAddress = new String[11];
				eAddress = line.split("■");

				int index1 = eAddress[5].indexOf(" ");
				String a = eAddress[5].substring(0, index1);

				int index2 = eAddress[5].indexOf(" ", index1 + 1);
				String b = eAddress[5].substring(index1 + 1, index2);

				int index3 = eAddress[5].indexOf(" ", index2 + 1);
				String c = eAddress[5].substring(index2 + 1);

				if (a.equals(address) || b.equals(address) || c.equals(address))
					System.out.printf("%5d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t\t%-10s\t\t%s\t%s\t%s\n",
							Integer.parseInt(eAddress[0]), eAddress[1], Integer.parseInt(eAddress[2]), eAddress[3],
							eAddress[4], eAddress[5], eAddress[6], eAddress[7], eAddress[8],
							Integer.parseInt(eAddress[9]));
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			eSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
			
		}
	}

	// 휴대폰번호로 직원 검색
	public void ePhone() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			File file = new File("C:\\DDGCinema_data\\직원정보.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 전화번호를 입력하세요.");
			System.out.print("전화번호 입력('-'를 포함해서 입력하세요) : ");
			String num = scan.nextLine();

			System.out.println(
					"[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t[이메일주소]\t\t[직급]\t[월급]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 직원번호■이름■나이■성별■주민등록번호■주소■휴대폰번호■이메일■직급■월급
				String[] pNum = new String[11];
				pNum = line.split("■");

				if (pNum[6].equals(num)) {

					System.out.printf("%5d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t\t%-10s\t\t%s\t%s\t%s\n",
							Integer.parseInt(pNum[0]), pNum[1], Integer.parseInt(pNum[2]), pNum[3], pNum[4], pNum[5],
							pNum[6], pNum[7], pNum[8], Integer.parseInt(pNum[9]));
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println(
				"============================================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			eSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
			
		}
	}

	// 직급으로 직원 검색
	public void ePosition() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		

		try {
			// 직원 정보 불러오기
			File file = new File("C:\\DGCinema_data\\직원정보.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			System.out.println(file.exists());
			System.out.println(file.getPath());
	
			String line = null;


			System.out.println("검색할 직급 입력하세요.");
			System.out.print("직급 입력 : ");
			String position = scan.nextLine();

			System.out.println(
					"[직원번호]\t[이름]\t\t[나이]\t\t[성별]\t\t[주민등록번호]\t\t[주소]\t\t\t\t[휴대폰번호]\t\t[이메일주소]\t\t[직급]\t[월급]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 직원번호■이름■나이■성별■주민등록번호■주소■휴대폰번호■이메일■직급■월급
				String[] ePosition = new String[11];
				ePosition = line.split("■");

				if (ePosition[8].equals(position)) {

					System.out.printf("%5d\t\t%s\t\t%d\t\t%s\t\t%s\t\t%s\t\t%-10s\t\t%s\t%s\t%s\n",
							Integer.parseInt(ePosition[0]), ePosition[1], Integer.parseInt(ePosition[2]), ePosition[3],
							ePosition[4], ePosition[5], ePosition[6], ePosition[7], ePosition[8],
							Integer.parseInt(ePosition[9]));
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println(
				"============================================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			eSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
		}

	}
}// SearchEmployee
