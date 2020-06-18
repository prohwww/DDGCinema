package com.test.cinema.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewManagement {
	
	private Scanner scan = new Scanner(System.in);
	//영화 정보 더미파일
	File movieFile = new File("C:\\DDGCinema_data\\영화 정보_더미.txt");
	//리뷰 정보 더미파일
	File reivewFile = new File("C:\\DDGCinema_data\\리뷰더미.txt");
	
	public void SReivewPrint() {
		//현재 상영 영화 목록 보여주기
		//리뷰 관리할 영화 선택 받기
		try {
			BufferedReader movieReader = new BufferedReader(new FileReader(movieFile));
			String line = null;
			
			//현재 상영 영화 목록을 받아올 배열
			//장르■제목■관객수■평점
			ArrayList<String> movieList = new ArrayList<String>();
			
			while((line = movieReader.readLine()) != null) {
				
				movieList.add(line);
				
			}
			
			//영화 선택 받기
			System.out.println("========현재 상영 영화========");
			
			//현재 상영 영화 불러오기
			for(int i=0; i<movieList.size(); i++) {
				String[] movie = movieList.get(i).split("■");
				System.out.printf("%d. %s\n",i+1, movie[1]);
			}
			
			System.out.println("==============================");
			System.out.println("0. 처음으로 가기");
			System.out.println("==============================");
			System.out.print("선택 : ");
			String selMovie = scan.nextLine();
			
			if(selMovie.equals("0")) {
				SystemStart sys = new SystemStart();
				sys.systemMenu();
//				break;
				return;
			}else {
				//리뷰 출력화면
				SReivewSelect(movieList, selMovie);
				
			}
			
			movieReader.close();
//			reviewReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void SReivewSelect(ArrayList<String> movieList, String selMovie) throws FileNotFoundException, IOException {
		String line;
		// 선택한 영화의 리뷰 불러오기
		// 제목■리뷰내용■평점■작성일■고객번호
		BufferedReader reviewReader = new BufferedReader(
				new FileReader(reivewFile));

		line = null;

		ArrayList<String> reviews = new ArrayList<String>();
		String title = movieList.get(Integer.parseInt(selMovie) - 1).split("■")[1];

		while ((line = reviewReader.readLine()) != null) {

			if (line.contains(title)) {
				// 선택 영화 찾을 경우 저장
				reviews.add(line);
			}

		} // while

		// 리뷰 출력
		int page = 1;
		movePage(page, reviews, title);
		
		while (true) {
			
			System.out.println("============================================================");
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
			System.out.println("3. 검색하기");
			System.out.println("4. 뒤로가기");
			System.out.println("============================================================");				
			System.out.print("선택 : ");
			
			String num = scan.nextLine();
			
			switch(num) {
			
			case "1" :
				page--;
				movePage(page, reviews,title);
				break;
			case "2" :
				page++;
				movePage(page, reviews, title);
				break;
			case "3" :
				SReviewSearch(reviews, title);
				return;
			case "4":
				return;
			}
			
		}//while
	}
	
	private void SReviewSearch(ArrayList<String> reviews, String title) {
		//리뷰 검색하는 메소드
		System.out.println("==============================");
		System.out.println("검색할 리뷰 내용을 입력하세요.");
		System.out.println("==============================");
		System.out.print("검색 : ");
		String search = scan.nextLine();
		
		//리뷰내용 찾기
		ArrayList<String> searchList = new ArrayList<String>();
		
		for(String line : reviews) {
			if(line.contains(search)) {
				searchList.add(line);
			}
		}
		
		//결과 출력하기
		int page = 1;
		movePage(page, searchList, title);
		System.out.println("============================================================");
		System.out.printf("'%s'를 검색한 결과 입니다.\n",search);

		while(true) {
			System.out.println("============================================================");
			System.out.println("1. 다음 페이지");
			System.out.println("2. 전체 삭제하기");
			System.out.println("============================================================");
			System.out.println("0. 처음으로 가기");
			System.out.println("============================================================");
			System.out.print("선택 : ");
			String sel = scan.nextLine();
			
			switch(sel) {
			
			case "1":
				page++;
				movePage(page, searchList, title);
				break;
			case "2" :
				//삭제하기
				SReivewDelete(searchList);
			case "0" :
				//뒤로가기
				movePage(page, searchList, title);
				return;
				
			default :
				System.out.println("============================================================");
				System.out.println("올바른 메뉴를 선택하세요.");
				break;
			}
			
			
		}
		
	}

	private void SReivewDelete(ArrayList<String> searchList) {
		//리뷰 삭제하는 메소드
		//전체 삭제
		while(true) {
			System.out.println("============================================================");
			System.out.println("전체 삭제를 하시겠습니까? (Y,N)");
			System.out.println("============================================================");
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			if(input.equals("Y")) {
				//삭제하기
				try {
					BufferedReader reviewReader = new BufferedReader(
							new FileReader(reivewFile));
					String line = null;
					
					//검색 결과에 있는 것들 빼고 다시 목록 뽑기
					ArrayList<String> delList = new ArrayList<String>();
					
					while((line = reviewReader.readLine()) != null) {
						delList.add(line);
						for(String list : searchList) {
							if(line.equals(list)) {
								delList.remove(line);
							}
						}
					}
					
					BufferedWriter writer = new BufferedWriter(new FileWriter(reivewFile));
					
					for(String list : delList) {
						writer.write(list);
						writer.newLine();
					}
					
					reviewReader.close();
					writer.close();
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("성공적으로 삭제되었습니다.");
				break;
				
			}else if(input.equals("N")) {
				break;
				
			}else {
				System.out.println("Y/N로 입력해주세요.");
			}
			
		}
		
	}

	private void movePage(int page, ArrayList<String> list, String title) {
		// 페이지 출력하는 메소드
		
		// 검색 결과 없을 경우
		if (list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {

			// 최대 페이지 계산하기
			int maxLength = list.size();
			int maxPage = list.size() % 10 > 0 ? list.size() / 10 + 1 : list.size() / 10;

			// 유효한 페이지 아닐 경우
			if (page == 0) {
				page = maxPage;
			} else if (page == maxPage + 1) {
				page = 1;
			}

			System.out.println("============================================================");
			System.out.printf("[%s] 현재 %d 페이지, %d개의 리뷰가 있습니다.\n", title, page, list.size());
			System.out.println("============================================================");
			System.out.println("[번호]\t[리뷰내용]\t\t\t\t\t[평점]\t[작성일]\t\t[고객번호]");

			for (int i = (page - 1) * 10; i < page * 10; i++) {
				// 제목■리뷰내용■평점■작성일■고객번호

				if (i >= list.size()) {
					break;
				} else {

					String[] s = list.get(i).split("■");

					// 출력
					System.out.printf("%3d\t%-20s\t\t\t%-1s\t%s\t%s\n", i + 1, s[1], s[2], s[3], s[4]);
					
				}
				
			} // for
		}//if
	}
}
