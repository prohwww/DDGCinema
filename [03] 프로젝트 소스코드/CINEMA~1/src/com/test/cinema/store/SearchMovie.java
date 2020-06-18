package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchMovie {

	Scanner scan = new Scanner(System.in);

	public void nSearch() {

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
		System.out.println("1. 제목 검색");
		System.out.println("2. 장르 검색");
		System.out.println("3. 상영관 검색");
		System.out.println("4. 뒤로가기");
		System.out.println("5. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		int num = scan.nextInt();

		switch (num) {
		case 1:
			nameSearch();
			break;
		case 2:
			genreSearch();
			break;
		case 3:
			tSearch();
			break;
		case 4:
			MovieManagement m = new MovieManagement();
			try {
				m.mSearch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			StoreStart.managerStart();
		}
	}

	// 영화 제목 검색 메소드
	public void nameSearch() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			// File file = new File(‪"E:\\Cinema\\현재 상영 영화 목록 연습용.txt");
			File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 영화 제목을 입력하세요.");
			System.out.print("영화 제목 : ");
			String name = scan.nextLine();

			boolean loop = false;
			System.out.println("[장르]\t[영화제목]\t\t[관람객수]\t[상영관]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 장르■영화제목■관람객수■상영관
				String[] movie = new String[4];
				movie = line.split("■");

				// 입력받은 name과 영화제목이 같으면 목록을 출력
				if (movie[1].equals(name)) {
					loop = true;
					System.out.printf("%s\t%10s\t\t%10s명\t\t%s관\n", movie[0], movie[1], movie[2], movie[3]);

				}
			}
			if (!loop) {
				System.out.println("해당 영화는 상영중이지 않습니다.");
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
			nSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
		}

	}

	// 장르 검색 메소드
	public void genreSearch() {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			// File file = new File(‪"E:\\Cinema\\현재 상영 영화 목록 연습용.txt");
			File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 장르를 입력하세요.");
			System.out.print("영화 장르 : ");
			String gen = scan.nextLine();

			System.out.println("[장르]\t[영화제목]\t\t[관람객수]\t[상영관]");
			boolean loop = false;
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 장르■영화제목■관람객수■상영관
				String[] movie = new String[4];
				movie = line.split("■");

				// 입력받은 gen이 장르와 같으면 출력
				if (movie[0].equals(gen)) {
					loop = true;
					System.out.printf("%s\t%10s\t\t%10s명\t\t%s관\n", movie[0], movie[1], movie[2], movie[3]);

				}
			}
			if (!loop) {
				System.out.println("해당 장르의 영화는 상영중이지 않습니다.");
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
			nSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
		}

	}

	// 상영관 검색 메소드
	public void tSearch() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		try {
			// 현재 상영 영화 목록 불러오기
			// File file = new File(‪"E:\\Cinema\\현재 상영 영화 목록 연습용.txt");
			File file = new File("C:\\DDGCinema_data\\강남점 상영 영화 목록.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			System.out.println("검색할 상영관을 입력하세요.");
			System.out.print("상영관(숫자) : ");
			String gwan = scan.nextLine();

			boolean loop = false;
			System.out.println("[장르]\t[영화제목]\t\t[관람객수]\t[상영관]");
			while ((line = reader.readLine()) != null) {
				list.add(line);

				// 장르■영화제목■관람객수■상영관
				String[] movie = new String[4];
				movie = line.split("■");

				// 입력받은 gwan이 상영관과 같으면

				if (movie[3].equals(gwan)) {
					loop = true;
					System.out.printf("%s\t%10s\t\t%10s명\t\t%s관\n", movie[0], movie[1], movie[2], movie[3]);

				}

			}
			if (!loop) {
				System.out.println("해당 영화는 상영관은 없습니다.");
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
			nSearch();
		} else if (input.equals("2")) {
			StoreStart.managerStart();
		}

	}
}
