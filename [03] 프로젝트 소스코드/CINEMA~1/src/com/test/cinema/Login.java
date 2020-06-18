package com.test.cinema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.test.cinema.member.MemberStart;
import com.test.cinema.store.StoreStart;
import com.test.cinema.system.SystemStart;

public class Login {
	
	//회원 정보 목록 파일
//	private File file = new File("C:\\프로젝트\\고객정보2.txt");	// 
//	private File file = new File("‪C:\\DDGCinema_data\\고객정보.txt");	// 아이디 비밀번호 a 
	private File file = new File("C:\\DDGCinema_data\\고객정보.txt");
	
	public void printLogin() {
		
		
		Scanner scan = new Scanner(System.in);
	
		System.out.println("=========== 로 그 인 =========");
		System.out.print("ID를 입력하세요 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pwd = scan.nextLine();
		
		//관리자 아이디 저장할 변수
		String storeId = "store";
		String systemId = "system";
		
		try {
			//회원정보 읽어오기
//			BufferedReader reader = new BufferedReader(new FileReader("D:\\Cinema\\회원정보.txt"));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int flag = 0; // 0:회원찾음, 1:아이디틀림 2:비밀번호 틀림

			while((line = reader.readLine()) != null) {
				
				//회원번호■아이디■비밀번호■이름■주민번호■주소■휴대폰번호■이메일주소■마일리지■등급■카드잔액
				String[] member = new String[11];
				member = line.split("■");
				
				
				if (id.equals(storeId)) {
		               // 매장 관리자 메뉴
				
				System.out.println("매장관리자로 로그인하셨습니다.");
				
				StoreStart.managerStart();
	               
	               break;
	               
	            } else if (id.equals(systemId)) {
	               // 시스템 관리자 메뉴
	               System.out.println("시스템관리자로 로그인하셨습니다.");
	               
	               SystemStart sys = new SystemStart();
	               sys.systemMenu();
	               break;
	               
	            }
				
				if(id.equals(member[1])) { //아이디를 찾을 경우
					
					if (pwd.equals(member[2])) {// 비밀번호 비교
						// 로그인 성공 화면 이동 구현 필요 **
						// 로그인한 회원(mem)의 정보 넘겨줘야 함 **

						flag = 0;

						// 일반 회원
						System.out.println("회원으로 로그인하셨습니다.");
						createMember(member);

						MemberStart ms = new MemberStart();
						ms.First();

						break;

					} else { // 비밀번호 틀림
						flag = 2;
						break;
					}
				} else {// 아이디 없음
					flag = 1;

				}

			} // while

			reader.close();
			
			System.out.println("==============================");
			
			//결과 출력
			if(flag == 1) {
				System.out.println("해당 아이디를 가진 회원이 없습니다.");
				return;
			}else if(flag == 2) {
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch		
		
		
		
	}//printLogin()

	private Member createMember(String[] member) {
		
		Member mem = new Member(member[0], member[1], member[2], member[3],
				member[4], member[5], member[6], member[7], member[9], Integer.parseInt(member[8]),Integer.parseInt(member[10]));
		
		return mem;
		
	}
	
}//Login


