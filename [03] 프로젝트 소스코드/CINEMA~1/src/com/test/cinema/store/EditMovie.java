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

public class EditMovie {

	Scanner scan = new Scanner(System.in);

	// 영화 수정 메소드
	public void nModify() {

		ArrayList<String> aList = new ArrayList<String>();
		String path = "C:\\DDGCinema_data\\강남점 상영 영화 목록.txt";

		File dir = new File(path);

		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// 상품 목록 리스트 출력
			System.out.println("[장르]\t\t[영화제목]\t\t[관람객수]\t[상영관]");
			try {
				while ((line = reader.readLine()) != null) {

					String[] list = new String[4];
					list = line.split("■");

					System.out.printf("%5s%15s%20s명\t%5s관\t\n", list[0], list[1], list[2],
							Integer.parseInt(list[3]));
				}
			} catch (IOException e) {
				System.out.println("데이터를 찾을 수 없습니다.");
			}

		} catch (FileNotFoundException e) {
			// System.out.println("txt파일을 찾을 수 없습니다.");
		}
		System.out.println("==================================================================");
		System.out.println("1. 상영 영화 추가");
		System.out.println("2. 상영 영화 삭제");
		System.out.println("3. 뒤로가기");
		System.out.println("4. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();

		switch (num) {

		case 1:
			nAdd();
			break;
		case 2:
			nDelete();
			break;
		case 3:
			break;
		case 4:
			return;

		}
	}

	// 영화 추가 메소드
	public void nAdd() {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>();
		File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			String line = null;
			String a = "";
			String b = "";
			String c = "";

			System.out.println("==================================================================");
			System.out.print("영화 장르 입력 : ");
			String gen = scan.nextLine();
			System.out.print("영화 제목 입력 : ");
			String name = scan.nextLine();
			System.out.print("상영관 입력 : ");
			String gwan = scan.nextLine();

			// 장르 입력

			a += gen + "■";

			// 영화 제목 입력
			b += name + "■";

			// 입력받은 상영관(4관까지)
			if (gwan.equals("1") || gwan.equals("2") || gwan.equals("3") || gwan.equals("4")) {

				c += "0" + "■" + gwan;
			}

			String result = a + b + c;

			list.add(result);
			for (String s : list) {

				writer.write(s + "\r\n");

			}
			writer.close();
			
			System.out.println("추가가 완료되었습니다. ");
			
			return;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 영화 삭제 메소드
	public void nDelete() {

		ArrayList<String> List = new ArrayList<String>();
		String path = "C:\\DDGCinema_data\\강남점 상영 영화 목록.txt";

		File dir = new File(path);

		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// 상품 목록 리스트 출력
			System.out.println("[장르]\t\t[영화제목]\t\t[관람객수]\t[상영관]");
			try {
				while ((line = reader.readLine()) != null) {

					String[] list = new String[4];
					list = line.split("■");

					System.out.printf("%5s%15s%20s명\t%5s관\t\n", list[0], list[1], list[2], Integer.parseInt(list[3]));
				}
			} catch (IOException e) {
				System.out.println("데이터를 찾을 수 없습니다.");
			}

		} catch (FileNotFoundException e) {
			// System.out.println("txt파일을 찾을 수 없습니다.");
		}
		System.out.println("==================================================================");
		System.out.println("1. 제목으로 삭제");
		System.out.println("2. 장르로 삭제");
		System.out.println("3. 상영관으로 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("5. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		int num = scan.nextInt();

		switch (num) {

		case 1:
			nameDelete();
			break;
		case 2:
			genreDelete();
			break;
		case 3:
			theaterDelete();
			break;

		}

	}

	// 영화 제목으로 삭제 메소드
	public void nameDelete() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("삭제할 영화 제목을 입력하세요.");
			System.out.print("영화 제목 : ");
			String name = scan.nextLine();
			System.out.println();

			while ((line = reader.readLine()) != null) {

				// 장르■영화제목■관람객수■상영관
				String[] movie = new String[4];
				movie = line.split("■");

				// 영화 이름이 같으면 list에 추가 안함
				if (movie[1].equals(name)) {

					// 영화 이름이 다르면 list에 추가
				} else {
					list.add(line);
				}
			}

			System.out.printf("%s이(가) 삭제되었습니다.\n", name);
			reader.close();

			file.delete();

		} catch (Exception e) {
			e.printStackTrace();

		} // try-catch

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt"));

			for (String txt : list) {
				writer.write(txt + "\r\n");
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
			nDelete();
		} else if (input.equals("2")) {
			return;
		}

	}

	// 장르로 영화 삭제
	public void genreDelete() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("삭제할 장르를 입력하세요.");
			System.out.print("장르 입력 : ");
			String gen = scan.nextLine();
			System.out.println();

			while ((line = reader.readLine()) != null) {

				// 장르■영화제목■관람객수■상영관
				String[] movie = new String[4];
				movie = line.split("■");

				// 장르가 일치하면 list에 추가 안함
				if (movie[0].equals(gen)) {

					// 장르가 불일치면 list에 추가
				} else {
					list.add(line);
				}
			}

			System.out.printf("%s 장르가 삭제되었습니다.\n", gen);
			reader.close();

			file.delete();

		} catch (Exception e) {
			e.printStackTrace();

		} // try-catch

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt"));

			for (String txt : list) {
				writer.write(txt + "\r\n");
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
			nDelete();
		} else if (input.equals("2")) {
			return;
		}

	}

	// 상영관 삭제 메소드
	public void theaterDelete() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("삭제할 영화관을 입력하세요.");
			System.out.print("영화관 : ");
			String gwan = scan.nextLine();
			System.out.println();

			while ((line = reader.readLine()) != null) {

				// 장르■영화제목■관람객수■상영관
				String[] movie = new String[4];
				movie = line.split("■");

				// 상영관이 같으면 list에 추가 안함
				if (movie[3].equals(gwan)) {

					// 상영관이 다르면 list에 추가
				} else {
					list.add(line);
				}
			}

			System.out.printf("%s관이 삭제되었습니다.\n", gwan);
			reader.close();

			file.delete();

		} catch (Exception e) {
			e.printStackTrace();

		} // try-catch

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt"));

			for (String txt : list) {
				writer.write(txt + "\r\n");
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
			nDelete();
		} else if (input.equals("2")) {
			StoreStart a = new StoreStart();
			a.managerStart();
		}

	}// try-catch

}
