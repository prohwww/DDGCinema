package com.test.cinema.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SySalesManagement {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<String> list = new ArrayList<String>(); //전체 파일 리스트
	private ArrayList<String> regionList = new ArrayList<String>(); // 지역 리스트 - 서울, 경기 ...
	private ArrayList<String> cinemaList = new ArrayList<String>(); // 선택 지역의 상영관 리스트 - 잠실, 건대...
	private List<String[]> salesList = new ArrayList<String[]>(); // 순위대로 정보 저장할 배열
	
	//영화관 정보 파일
	private File cinemaFile = new File("C:\\DDGCinema_data\\영화관목록.txt");
	//극장별 매출 데이터 파일
	private File salesFile = new File("C:\\DDGCinema_data\\시스템_극장별 매출 데이터.txt");
	
	
	public void salesPrint() {
		// 극장별 매출 정보 선택하는 메소드
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(cinemaFile));

			String line = null;

			// 지역 리스트 뽑아서 저장
			while ((line = reader.readLine()) != null) {

				list.add(line);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] regions = { "서울특별시", "경기도", "인천광역시", "강원도", "대전/충청시", "대구광역시", "부산광역시", "경상도", "광주광역시", "전라도", "제주도" };

		for (String region : regions) {
			regionList.add(region);
		}

		while (true) {

			System.out.println("지역을 선택하세요.");
			System.out.println("==============================");
			// 지역 메뉴 출력
			for (int i = 0; i < regionList.size(); i++) {
				System.out.printf("%d. %s\n", i + 1, regionList.get(i));
			}

			System.out.println("==============================");
			System.out.println("0. 뒤로가기");
			System.out.println("==============================");
			System.out.print("입력 : ");

			String input = scan.nextLine();

			// 메뉴 유효성 검사
			if (input.equals("0")) {
				// 뒤로가기
				break;
				
			} else if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < regionList.size()) {
				// 선택 지역의 상영관 담기
				
				for (String region : regionList) {
					boolean flag = false;
					for (int i = 0; i < list.size(); i++) {
						// 서울특별시■강남점
						String[] array = list.get(i).split("■");						

						if (region.equals(regionList.get(Integer.parseInt(input) - 1))) {
							// 매출 정보 불러오기
							salesOutput(array[1]);
							flag = true;
							break;
						}
					}
					if (flag) break;
					
				} // for
				
			} else {
				System.out.println("메뉴를 다시 입력하세요.");
			}

		} // while
		
	}

	private void salesSearch() {
		// 지점 검색하는 메소드
		while (true) {

			System.out.println("==============================");
			System.out.println("찾으실 지점명을 입력하세요.");
			System.out.println("==============================");
			System.out.println("0. 뒤로가기");
			System.out.println("==============================");
			System.out.print("입력 : ");
			String input = scan.nextLine();

			if (input.equals("0")) {
				// 뒤로가기
				break;
			}

			// 지점명 유효성 검사
			for (String cinema : cinemaList) {

				if(cinema.contains(input)) {
					System.out.println("==========================================================================================");
					System.out.println("지점명\t영화매출액\t상품매출액\t총 매출액\n");
					//파일에서 읽어오기
					try {
						BufferedReader reader = new BufferedReader(new FileReader(salesFile));
						String line = null;
						
						String[] array;
						while((line = reader.readLine()) != null) {
							array = line.split("■"); 
							if(array[1].equals(input)) {
								int movieSales = Integer.parseInt(array[2]);
								int foodSales = Integer.parseInt(array[3]);
								int acount = movieSales + foodSales;
								System.out.printf("%-7s\t%,5d\t%,5d\t%,5d\n",array[1],movieSales,foodSales,acount);
							}
						}
						
						reader.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("==========================================================================================");
					System.out.println("지점 검색 결과 입니다.");
					break;
					
				} else {
					System.out.println("해당 지점이 없습니다.");
				}
				
			}//for
		}//while
	}
	
	private void salesOutput(String region) { // 서울, {강남, 잠실, 건대...}
		// 순위 지점명 총 매출액 영화 매출액 상품 매출
		// 순위 구해서 새로운 배열 저장하기
		
		try {
			// 매출액 정보 가진 파일 읽기
			BufferedReader reader = new BufferedReader(
					new FileReader(salesFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] array = line.split("■");
				salesList.add(array);

//				System.out.println(line);
			}

			// 순위별 정렬
			salesList = salesList.stream().sorted((n1, n2) -> {
				
				return (Integer.parseInt(n2[2]) + Integer.parseInt(n2[3])- (Integer.parseInt(n1[2]) + Integer.parseInt(n1[3])));
				
			}).collect(Collectors.toList());
			
//			salesList.stream().forEach(array -> System.out.println(Arrays.toString(array) + ":" + (Integer.parseInt(array[2]) + Integer.parseInt(array[3]))));
			
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		movePage();

		while (true) {
			//페이징하기

			System.out.println("==============================");
			System.out.println("0. 뒤로가기");
			System.out.println("==============================");
			System.out.print("선택 : ");
			String num = scan.nextLine();

			switch (num) {

			case "0":
				System.out.println("뒤로가기");
				return;
			}
		}//while
		
	}
	
	private void movePage() {
		// 페이지 출력하는 메소드

		System.out.println("==============================");
		System.out.println("[매출순위]\t[지점명]\t\t[영화매출액]\t[상품매출액]\t[총 매출액]");
		
		for(int i=0; i<salesList.size(); i++) {
			
			System.out.printf("%3d\t\t%-7s\t\t%,10d\t%,10d\t%,10d\n", i+1, salesList.get(i)[1]
					, Integer.parseInt(salesList.get(i)[2])
					, Integer.parseInt(salesList.get(i)[3])
					, Integer.parseInt(salesList.get(i)[2]) + Integer.parseInt(salesList.get(i)[3]));
		}//for
				
	}
	
}
