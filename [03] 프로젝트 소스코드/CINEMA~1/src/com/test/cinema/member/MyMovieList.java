 package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Member;

public class MyMovieList {
	
	//지금까지 본 영화목록 화면출력
	public void printMyMovieList() {
		
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("지금 까지 본 영화목록에 들어왔습니다. 번호를 선택하여주세요");
		System.out.println("==============================");
		System.out.println("번호\t영화\t\t작성일");
		// 1. 번호■제목■날짜
			memberMovieList();
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
				
		int num = scan.nextInt();
		
		switch(num) {
				
		case 1:	//뒤로가기	
			return;						
		case 2: //처음으로가기
			MemberStart.First();
		}//switch
				
		}//for
				
	}//printMyMovieList()

	
	//지금까지 본 영화 목록
	private void memberMovieList() {
				
		//리뷰 더미 불러오기
		String path = "C:\\DDGCinema_data\\리뷰더미.txt";
			
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			try {
				int i=1;	
				while((line = reader.readLine()) != null) {
								
					String[] m = new String[5];
					m = line.split("■");
					String info = "";
					
					//예매번호가 일치하면 정보 출력
					//@@ 회원번호 가져오기
					//@@ 리뷰더미에 회원 번호 추가 필요
					//if(m[5].equals(m2.getmNum()){
					if(m[4].trim().equals(Member.getmNum())) { //예매번호
					
					info += String.format("%03d\t", i);
					info += String.format("%-1s\t\t", m[0]); //영화제목
					info += String.format("%s\n", m[3]);	 //날짜
																
					System.out.printf(info);
					
					i++;			
						
					}
					
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//try-catch
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}//try-catch
		
		
		
	}//memberMovieList()
	
		
}//class
