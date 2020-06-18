package com.test.cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.test.cinema.member.MemberStart;

public class Join {

	private Scanner scan = new Scanner(System.in);
	private String newLine = null;
	private String[] newMember = new String[11];
	//고객정보를 담는 파일
	private File file = new File("C:\\DDGCinema_data\\고객정보.txt");
	
	public void printJoin() {

		//회원번호■아이디■비밀번호■이름■주민번호■주소■휴대폰번호■이메일주소■마일리지■등급■카드잔액
		
		output(1); //회원가입 설명 출력

		while (true) {
			// 1. 아이디
			printMenu(1);
			if (check(1)) { // id 유효성 검사 통과시

				newMember[1] = newLine;
				
				while (true) {
				// 2. 비밀번호
				printMenu(2);

				if (check(2)) { // pwd 유효성 검사 통과

					newMember[2] = newLine;
					
					while(true) {
					// 3. 이름
					printMenu(3);

					if (check(3)) { // 이름 유효성 검사 통과

						newMember[3] = newLine;

						while(true) {
						// 4. 주소
						printMenu(4);

						if (check(4)) { // 주소 유효성 검사

							newMember[5] = newLine;

							while(true) {
							// 5. 이메일
							printMenu(5);

							if (check(5)) { // 이메일 유효성 검사

								newMember[7] = newLine;

								while(true) {
								// 6. 휴대폰 번호
								printMenu(6);

								if (check(6)) { // 휴대폰 번호 유효성 검사

									newMember[6] = newLine;

									while(true) {
									// 7. 주민등록번호
									printMenu(7);
									if (check(7)) { // 주민번호 유효성 검사

										newMember[4] = newLine;

										// 회원가입 성공
										// 기입한 회원 정보 저장
										saveMember();
										output(2); //성공시 메뉴 출력
										
										//메인 메뉴 출력
										MemberStart.First();
										return;
										
									} else {
										failPrint(7);
									}
									}//while7

								} else {
									failPrint(6);
								}
								}//while6

							} else {
								failPrint(5);

							}
							}//while5

						} else {
							failPrint(4);
						}
						}//while4

					} else {
						failPrint(3);

					}
					}//while3

				} else {
					failPrint(2);

				}
				}//while2
				

			} else {
				failPrint(1);
			}
		} // while_1

	}
	
	private void saveMember() { //회원가입 성공시, 파일에 저장하기
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			List<String> list = new ArrayList<String>();
			String line;
			
			while((line = reader.readLine()) != null) {
				list.add(line);
				
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			//회원 마지막 번호 알아내기
			int num = list.size() - 1; 
			String[] lastMem = list.get(num).split("■");
			
			//파일 덮어쓰기
			for(String s : list) {
				writer.write(s);
				writer.newLine();
			}
			//회원정보 추가하기
			newMember[8] = "0■";
			newMember[9] = "실버■";
			newMember[10] = "0";
			newMember[0] = (Integer.parseInt(lastMem[0]) + 1) + "■";
			String result = "";
			
			for(int i=0; i<newMember.length; i++) {
				result += newMember[i]+"";
			}
			
			//회원가입한 정보로 멤버변수 초기화
			String[] mem = result.split("■");
//			System.out.println(Arrays.toString(mem));
			Member member = new Member(mem[0],mem[1],mem[2],mem[3],mem[4],mem[5],mem[6],mem[7],mem[9],
									Integer.parseInt(mem[8]),Integer.parseInt(mem[10]));
			
			writer.write(result);
			writer.newLine();
			
			reader.close();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printMenu(int i) { //기입할 항목 출력
		System.out.println("==============================");
		
		switch(i) {
		
		case 1:
			System.out.print("아이디 : ");
			break;
		case 2:
			System.out.print("비밀번호 : ");
			break;
		case 3:
			System.out.print("이름 : ");
			break;
		case 4:
			System.out.print("주소 : ");
			break;
		case 5:
			System.out.print("이메일 : ");
			break;
		case 6:
			System.out.print("휴대폰 번호 : ");
			break;
		case 7:
			System.out.print("주민등록번호 : ");
			break;
		}
		
	}

	private void failPrint(int i) {
		
		System.out.println("=================== 회원가입 실패 ====================");
		
		switch(i) {
			
		case 1 :
			System.out.println("아이디는 5자 이상 영어와 숫자로만 입력해주십시오.");
			break;
		case 2 : 
			System.out.println("비밀번호는 8자 이상 영어, 숫자, 특수문자(!@#$%^&*)로 입력해주세요.");
			break;
		case 3 :
			System.out.println("이름은 10글자 이내, 한글로 입력해주세요.");
			break;
		case 4 :
			System.out.println("정확한 주소를 입력해주세요. (서울시 강남구) ");
			break;
		case 5 : 
			System.out.println("정확한 이메일을 입력해주세요.");
			break;
		case 6 :
			System.out.println("휴대폰 번호를 정확히 입력하세요.");
			break;
		case 7 :
			System.out.println("주민등록번호를 '-'와 13자리 숫자로 입력하세요.");
			break;
		}
		
		
	}

	private boolean check(int num) {
		
		String input = scan.nextLine();
		String line = input.toUpperCase(); //대,소문자 구분 X
		int len = 0;
		
		for (int i = 0; i < input.length(); i++) {

			switch(num) {
			
			case 1: //id : 영어, 숫자
				
				if(input.length() > 5 && (line.charAt(i) >='A' && line.charAt(i) <= 'Z') 
						|| (line.charAt(i) >= '0' && line.charAt(i) <= '9')) {
				
					len++;
				} 
				break;
				
			case 2 : // pwd : 영어, 숫자 특문(!@#$%^&*)
				
				if(input.length() >= 8) {
					
					if(((line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') 
							|| (line.charAt(i) >= '0' && line.charAt(i) <= '9')
							|| line.charAt(i) == '!' || line.charAt(i) == '@' || line.charAt(i) == '#'
							|| line.charAt(i) == '$' || line.charAt(i) == '%' || line.charAt(i) == '^'
							|| line.charAt(i) == '&' || line.charAt(i) == '*')) {
						
						len++;
					} 
				}
				break;
				
			case 3 : // 이름 : 길이, 한글
				
				if (input.length() > 0 && input.length() < 10 && line.charAt(i) >= '가' && line.charAt(i) <= '힇') {

					len++;
				}
				break;
			
			case 4 : // 주소 : 시, 군, 구, 동, 읍, 면
				
				if (line.length() > 0 && (input.contains("시") || input.contains("군") || input.contains("구") || input.contains("동") || input.contains("읍") || input.contains("면"))) {
					len++;
				}
				break;
				
			case 5 : //이메일 : '@', '.com' 확인
				if(line.length() > 0 && (input.contains("@") && (input.contains(".com") || input.contains(".co.kr") || input.contains(".net")))) {
					len++;
				}
				break;
			
			case 6 : // 휴대폰 번호 : 010-XXXX-XXXX
				if(line.length() > 0 && input.contains("010")) {
					String[] number = input.split("-");
					if(Integer.parseInt(number[1]) % 1000 > 0 && Integer.parseInt(number[2]) % 1000 > 0) {
						len++;
					}
				}else {
					break;
				}
				break;
			
			case 7 : // 주민등록번호 : 96XXXX-2XXXXXX, 총 13자인지 + 뒷자리 첫번째 숫자 1~4 검사
				
				if(input.length() == 14) {
					len++;
					if(input.charAt(input.indexOf("-")) < 0 && input.charAt(input.indexOf("-")) > 4) {
						len--;
					}
				}
				break;
				
			}//switch
			

		} // for
		
		//올바르게 기입한 경우 정보 저장하기 
		if (len == input.length()) {
			newLine = input + "■";
			return true;
		} else {
			return false;
		}
		
	}
	
	private void output(int num) {

		if (num == 1) {
			System.out.println("======================= 회 원 가 입 ======================");
			System.out.println("회원가입에 들어오셨습니다. 정보를 입력해주세요.");
			System.out.println("아이디는 영어, 숫자만 입력 가능합니다.");
			System.out.println("비밀번호는 특수문자(!@#$%^&*), 숫자, 대소문자만 입력이 가능합니다.");
		}else {
			System.out.println("회원가입에 성공하셨습니다.");
			System.out.println("==========================================================");

		}
	}
	
	
}
