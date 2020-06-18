package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.ReverbType;

import com.test.cinema.Member;
import com.test.cinema.Start;

public class MyOut {
	

	//회원탈퇴 화면출력	
	public void myOutprint() {
		
		boolean loop = true;
		
		for (;loop;) {
				
			Scanner scan = new Scanner(System.in);
			
			System.out.printf("회원탈퇴에 들어왔습니다.\n");
			System.out.println("==============================");				
			System.out.println("정말 탈퇴하시겠습니까?(Y)");
			
			System.out.println("1. 뒤로가기 ");
			System.out.println("2. 처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
			String input = scan.nextLine();
						
			if (input.equals("Y")) {
				myOutpw(); //회원탈퇴 비밀번호 확인 입력화면
				break;
			} else if (input.equals("N")) { //뒤로가기
				
				return;
						
			} else if (input.equals("1")) { //뒤로가기
				
				return;
				
			} else  if(input.equals("2")){ //처음으로가기
				MemberStart.First();
				//끝내지 말자 ,,,,, 
			}
			
		}//for
		
	}

	//회원탈퇴 비밀번호 입력
	private void myOutpw() {
						
		boolean loop = true;
		
		for (;loop;) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.printf("회원탈퇴에 들어왔습니다. 비밀번호를 입력해주세요.\n");
			System.out.println("==============================");				
			System.out.println("1. 뒤로가기 ");
			System.out.println("2. 처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
			String input = scan.nextLine();
			
			if (input.equals("1")) { //뒤로가기
				myOutprint();
				return;
			} else if (input.equals("2")) { //처음으로가기
				return;
			} else {
								
				if(Member.getmPwd().equals(input)) {
					pwIdentify(input);
				} else {
					System.out.println("==============================");
					System.out.println("비밀번호가 틀렸습니다");
				}
			}
						
			}//for
		
	}

	private void pwIdentify(String input) {
								
		//현재 고객정보 목록 불러오기
		String path = "C:\\DDGCinema_data\\고객정보.txt";
		File dir = new File(path);
				
		//System.out.println(dir.getAbsolutePath());
		//파일 읽어 오고 list에 저장
		ArrayList<String> list = new ArrayList<String>();

		BufferedReader reader;
		try {
			reader = new BufferedReader
					(new FileReader("C:\\DDGCinema_data\\고객정보.txt"));
			
			String line = null;
			
			try {
				while((line = reader.readLine()) != null) {
								
					list.add(line); 
					
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//try-catch
			
		
		dir.delete(); //기존 파일 삭제 하기
				
		//파일 다시 쓰고 저장하기
		try {
			BufferedWriter writer = new BufferedWriter
					(new FileWriter("C:\\DDGCinema_data\\고객정보.txt", true));
			
			for (String text : list) {
								
				String[] m = new String[10];
				m = text.split("■");
				
				//입력받은 비밀번호
				String password = input;
								
				//입력 받은 비밀번호 = 회원정보 일치하면
				if(password.equals(m[2])) {
					//쓰기 X				
				} else {
				
					writer.write(text+"\n"); //나머지 값 쓰기		
					
				}
											
			}
						
			
			writer.close();
			myoutSuccess(); //회원탈퇴 성공 화면
						
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
		
		
		
		
	}

	//회원탈퇴 성공화면 출력
	private void myoutSuccess() {
		
		boolean loop = true;
		
		for (;loop;) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.printf("회원탈퇴가 성공적으로 이루어졌습니다.\n");
			System.out.println("==============================");				
			System.out.println("1. 뒤로가기 ");
			System.out.println("2. 처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
			String input = scan.nextLine();
			
			if (input.equals("1")) { //뒤로가기
				myOutprint();
				return;
				
			} else if (input.equals("2")) { //처음으로가기
				System.out.println("이용해주셔서 감사합니다.");
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				//return;
			} 
						
			
			}//for
		
		
		
	}
	
}
