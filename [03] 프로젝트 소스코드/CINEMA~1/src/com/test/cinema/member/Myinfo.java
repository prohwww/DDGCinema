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

import com.test.cinema.Member;


public class Myinfo {
	
	//내정보관리 화면출력
	public void printMyinfo() {
		
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("내정보 관리에 들어왔습니다. 번호를 선택하여 주세요.");
		System.out.println("==============================");
		
		System.out.println("이름\t나이\t성별\t주소\t\t\t휴대폰 번호\t이메일");
		mMember(); //이름■나이■성별■주소■휴대폰 번호■이메일
		System.out.println();
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 주소 변경");
		System.out.println("3. 휴대폰 번호 변경");
		System.out.println("4. 이메일 변경");
		System.out.println("5. 뒤로가기");
		System.out.println("6. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
					
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //비밀번호 변경
			editPassword();
			break;
		case 2:	//주소 변경
			editAddress();
			break;
		case 3:	//휴대폰 번호 변경	
			editPhoneNumber();
			break;
		case 4: //이메일 변경
			editEmail();
		case 5: // 뒤로가기
			Mypage.printmypage();
		case 6: //처음으로 돌아가기	
			MemberStart.First();
		}//switch
		
		}//for
		
	}

	//이름■나이■성별■주소■휴대폰 번호■이메일  -> 출력
	private void mMember() {
			
		//리뷰 더미 불러오기
				String path = "C:\\DDGCinema_data\\고객정보.txt";
				
				try {
					
					BufferedReader reader = new BufferedReader(new FileReader(path));
					
					String line = null;
					
					try {			
						int i=1;	
						while((line = reader.readLine()) != null) {
										
							String[] m = new String[11];
							m = line.split("■");
							String info = "";
							
							if(m[0].equals(Member.getmNum())) { //예매번호
							
							//이름■나이■성별■주소■휴대폰 번호■이메일
							info += String.format("%s\t", m[3]); //
							
							
							
							if(Integer.parseInt(Member.getmJumin().substring(0, 1)) < 20) {
								info += String.format("%d\t", 20 - Integer.parseInt(Member.getmJumin().substring(0, 1)));
							} else {
								info += String.format("%d\t", 120 - Integer.parseInt(Member.getmJumin().substring(0, 1)));
							}
							
							if((Integer.parseInt(Member.getmJumin().substring(7, 8)) % 2) == 0) {
							info += String.format("여자\t");
							} else {
							info += String.format("남자\t");
							}
			
							info += String.format("%-2s\t", m[5]); //주소
							info += String.format("%-2s\t", m[6]); //전화번호
							info += String.format("%-10s\t", m[7]);  //이메일
							
																		
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
		
	

		
		
		
		
//		System.out.println("이름\t나이\t성별\t주소\t\t\t\t휴대폰 번호\t\t이메일");
//		
//		String info = "";
//		
//		info += String.format("%s\t" , Member.getmName());
//		
//		if(Integer.parseInt(Member.getmJumin().substring(0, 1)) < 20) {
//			info += String.format("%d\t", 20 - Integer.parseInt(Member.getmJumin().substring(0, 1)));
//		} else {
//			info += String.format("%d\t", 120 - Integer.parseInt(Member.getmJumin().substring(0, 1)));
//		}
//		
//		if((Integer.parseInt(Member.getmJumin().substring(7, 8)) % 2) == 0) {
//			info += String.format("여자\t");
//		} else {
//			info += String.format("남자\t");
//		}
//		
//		info += String.format("%s\t", Member.getmAddress());
//		info += String.format("%s\t\t" , Member.getmPhone());
//		info += String.format("%s", Member.getmEmail());
//		
//		System.out.println(info);
		
	}
	
//비밀번호	
//-----------------------------------------------------------------------------
	
	//비밀번호 변경메뉴
	private void editPassword() {
					
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
			
		System.out.println("비밀번호 변경에 들어왔습니다. 변경할 비밀번호를 입력하세요.");
		System.out.println("비밀번호는 8자리 이상 특수문자(!@#$%^&*), 영어 대문자, 소문자만 사용가능합니다.");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(변경할 비밀번호 or 숫자 입력) : ");
		
		//변경할 데이터 입력 또는 메뉴 선택 
		String input = scan.nextLine();
				
		if(input.equals("1")) {//뒤로가기
						
			printMyinfo();
				
		} else if (input.equals("2")) {//처음으로가기	
			
			MemberStart.First();
								
		} else {
			Member.mPwd = input;
			passwordEdit(input); //변경하는 메소드
			
		}//if
		
		}//for
		
	}

	
	//비밀번호 변경
	private void passwordEdit(String input) {
		
				
		//현재 고객정보 목록 불러오기
		String path = "C:\\DDGCinema_data\\고객정보.txt";
		File dir = new File(path);
				
		
		//파일 읽어 오고 list에 저장
		ArrayList<String> list = new ArrayList<String>();

		BufferedReader reader;
		try {
			reader = new BufferedReader
					(new FileReader("C:\\DDGCinema_data\\고객정보.txt"));
			
			String line = null;
			
			try {
				while((line = reader.readLine()) != null) {
								
					list.add(line+"\n"); 
					
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//try-catch
		 		
		//비밀번호 유효성 검사
		if(input.length() >= 8) {//8자리 이상
			
			for(int i=0; i<input.length(); i++ ) {
			
			if((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') //영어, 숫자, 특수문자(!@#$%^&*)
					|| (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
					|| (input.charAt(i) >= '0' && input.charAt(i) <= '9')
					|| input.charAt(i) == '!' || input.charAt(i) == '@' || input.charAt(i) == '#'
					|| input.charAt(i) == '$' || input.charAt(i) == '%' || input.charAt(i) == '^'
					|| input.charAt(i) == '&' || input.charAt(i) == '*') {
				
				
				} else {
					editPasswordFail();
					break;
				}
			}
			
		} else {
			editPasswordFail();
			
		}//if
		
		dir.delete(); //기존 파일 삭제 하기
				
		//파일 다시 쓰고 저장하기
		try {
			BufferedWriter writer = new BufferedWriter
					(new FileWriter("C:\\DDGCinema_data\\고객정보.txt", true));
			
			for (String text : list) {
				
				//회원번호 = 고객정보(회원번호) 일치
				String[] m = new String[11];
				m = text.split("■");
				String info = "";
								
				if(Member.getmNum().equals(m[0]))  {
					
				writer.write(text.replaceFirst(Member.getmPwd(), input));
				
				} else {
					writer.write(text);
				}
							

							
			}
					
			
			writer.close();
			editPasswordSuccess(); //비밀번호 입력 성공 출력
						
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch

	}
	
	//비밀번호 변경 성공시
	private void editPasswordSuccess() {
				
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("비밀번호 변경에 성공하였습니다. 번호를 선택하여 주세요.");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
					
		
		int num = scan.nextInt();
		
		switch(num) {
		case 1: 
			printMyinfo();			
		case 2:	//처음으로가기
			MemberStart.First();
			
		}//switch
					
		}//for
		
	}
		
	
	//비밀번호 변경 실패시
	private void editPasswordFail() {
					
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
			
		System.out.println("비밀번호 변경에 실패하였습니다. 번호를 선택하여 주세요.");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
							
		int num = scan.nextInt();
			
		switch(num) {
		case 1: //뒤로가기
			editPassword();					
		case 2:	//처음으로가기
			MemberStart.First();	
			
			
		}//switch
			
		}//for

	}

//주소
//----------------------------------------------------------------------------
	
	//주소 변경메뉴
	private void editAddress() {
				
		boolean loop = true;
		
		for (;loop;) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("주소 변경에 들어왔습니다. 변경할 주소를 입력하세요.");
		System.out.println("정확한 주소를 입력해주세요. ex(서울시 강남구).");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(주소 or 숫자 입력) : ");
		
		//변경할 데이터 입력 또는 메뉴 선택 
		String input = scan.nextLine();
				
		if(input.equals("1")) {//뒤로가기
			printMyinfo();				
		} else if (input.equals("2")) {//처음으로가기	
			MemberStart.First();
								
		} else {
			Member.mAddress = input;
			addressEdit(input); //변경하는 메소드
			
		}//if
		
		}//for
		
	}
	
	//주소변경
	private void addressEdit(String input) {
						
		//현재 고객정보 목록 불러오기
		String path = "C:\\DDGCinema_data\\고객정보.txt";
		File dir = new File(path);
				
		
		//파일 읽어 오고 list에 저장
		ArrayList<String> list = new ArrayList<String>();

		BufferedReader reader;
		try {
			reader = new BufferedReader
					(new FileReader("C:\\DDGCinema_data\\고객정보.txt"));
			
			String line = null;
			
			try {
				while((line = reader.readLine()) != null) {
								
					list.add(line+"\n"); 
										
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//try-catch
		 		
		
		//주소 유효성 검사
		if (input.contains("시") || input.contains("군") || input.contains("구") || input.contains("동") || input.contains("읍") || input.contains("면")) {
			
		} else {  
			editAddressFail();
		} 
		
		dir.delete(); //기존 파일 삭제 하기
				
		//파일 다시 쓰고 저장하기
		try {
			BufferedWriter writer = new BufferedWriter
					(new FileWriter("C:\\DDGCinema_data\\고객정보.txt", true));
			
			for (String text : list) {
				
				String[] m = new String[11];
				m = text.split("■");
				String info = "";
												
				if(Member.getmNum().equals(m[0]))  {
					
					writer.write(text.replaceFirst(Member.getmAddress(), input));		
								
				} else {
					writer.write(text);
				}
	
				
			}
								
			writer.close();
			editAddressSuccess(); //주소 변경 성공 출력
						
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
	}
	
	//주소 변경 성공시
		private void editAddressSuccess() {
				
			boolean loop = true;
			
			for (;loop;) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("주소 변경에 성공하였습니다. 번호를 선택하여 주세요.");
			System.out.println("==============================");
			System.out.println("1. 뒤로가기");
			System.out.println("2. 처음으로 돌아가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
							
			int num = scan.nextInt();
			
			switch(num) {
			case 1: //뒤로가기
				printMyinfo();
			case 2:	//처음으로가기
				MemberStart.First();	
			}//switch
			
			}//for
			

		}
				
		
		//주소 변경 실패시
		private void editAddressFail() {
						
			boolean loop = true;
						
			for (;loop;) {
			
			Scanner scan = new Scanner(System.in);
				
			System.out.println("주소 변경에 실패하였습니다. 번호를 선택하여 주세요.");
			System.out.println("==============================");
			System.out.println("1. 뒤로가기");
			System.out.println("2. 처음으로 돌아가기");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
							
			int num = scan.nextInt();
			
			
			switch(num) {
			case 1: //뒤로가기
				editAddress();
			case 2:	//처음으로가기
				MemberStart.First();			
			}//switch

			}//for
			
		}

//휴대폰		
//----------------------------------------------------------------------		
		
		//번호 변경메뉴		
		private void editPhoneNumber() {
			
			boolean loop = true;
			
			for (;loop;) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("전화번호 변경에 들어왔습니다. 변경할 번호를 입력하세요.");
			System.out.println("'-'포함해서 입력해주세요. 010-1234-1234.");
			System.out.println("==============================");
			System.out.println("1. 뒤로가기");
			System.out.println("2. 처음으로가기");
			System.out.println("==============================");
			System.out.print("입력(주소 or 숫자 입력) : ");
			
			//변경할 데이터 입력 또는 메뉴 선택 
			String input = scan.nextLine();
					
			if(input.equals("1")) {//뒤로가기
									
				printMyinfo();
				
			} else if (input.equals("2")) {//처음으로가기	
				MemberStart.First();
									
			} else {
								
				Member.mPhone = input;
				phoneNumberEdit(input); //변경하는 메소드
				
			}//if
			
			}//for
			
		}
		
		//전화번호 변경
		private void phoneNumberEdit(String input) {
			
						
			//현재 고객정보 목록 불러오기
			String path = "F:\\DDGCinema_data\\고객정보.txt";
			File dir = new File(path);
					
			
			//파일 읽어 오고 list에 저장
			ArrayList<String> list = new ArrayList<String>();

			BufferedReader reader;
			try {
				reader = new BufferedReader
						(new FileReader("C:\\DDGCinema_data\\고객정보.txt"));
				
				String line = null;
				
				try {
					while((line = reader.readLine()) != null) {
									
						list.add(line+"\n"); 
						
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}//try-catch
			 		
			//전화번호 유효성 검사
			if(input.contains("010")) {
				String[] number = input.split("-");
				if(Integer.parseInt(number[1]) % 1000 > 0 && Integer.parseInt(number[2]) % 1000 > 0) {
					
				}
			}else {
								
				editPhonNumberFail();
			}
						
			dir.delete(); //기존 파일 삭제 하기
					
			//파일 다시 쓰고 저장하기
			try {
				BufferedWriter writer = new BufferedWriter
						(new FileWriter("C:\\DDGCinema_data\\고객정보.txt", true));
				
				for (String text : list) {
					
					String[] m = new String[11];
					m = text.split("■");
					String info = "";
													
					if(Member.getmNum().equals(m[0]))  {
						
						writer.write(text.replaceFirst(Member.getmPhone(), input));		
									
					} else {
						writer.write(text);
					}

									
				}
										
				writer.close();
				editPhonNumberSuccess(); //전화번호 변경 성공 출력
							
			} catch (IOException e) {
				e.printStackTrace();
			}//try-catch
		}
		
		//전화번호 변경 성공시
			private void editPhonNumberSuccess() {
					
				boolean loop = true;
				
				for (;loop;) {
				
				Scanner scan = new Scanner(System.in);
				
				System.out.println("전화번호 변경에 성공하였습니다. 번호를 선택하여 주세요.");
				System.out.println("==============================");
				System.out.println("1. 뒤로가기");
				System.out.println("2. 처음으로 돌아가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");
								
				int num = scan.nextInt();
				
				switch(num) {
				case 1: //뒤로가기
					printMyinfo();
				case 2:	//처음으로가기
					MemberStart.First();	
				}//switch
				
				}//for
				

			}
					
			
			//전화번호 변경 실패시
			private void editPhonNumberFail() {
							
				boolean loop = true;
				
				for (;loop;) {
				
				Scanner scan = new Scanner(System.in);
					
				System.out.println("전화번호 변경에 실패하였습니다. 번호를 선택하여 주세요.");
				System.out.println("==============================");
				System.out.println("1. 뒤로가기");
				System.out.println("2. 처음으로 돌아가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");
								
				int num = scan.nextInt();
					
				switch(num) {
				case 1: //뒤로가기
					editPhoneNumber();
				case 2:	//처음으로가기
					MemberStart.First();	
				}//switch

				}//for
				
			}
			
//이메일			
//--------------------------------------------------------------------------			
			
		//이메일 변경메뉴
		private void editEmail() {
						
			boolean loop = true;
			
			for (;loop;) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("이메일 변경에 들어왔습니다. 변경할 이메일를 입력하세요.");
			System.out.println("'@' ,'com' 포함해서 입력해주세요. 123@naver.com");
			System.out.println("==============================");
			System.out.println("1. 뒤로가기");
			System.out.println("2. 처음으로가기");
			System.out.println("==============================");
			System.out.print("입력(이메일 or 숫자 입력) : ");
			
			//변경할 데이터 입력 또는 메뉴 선택 
			String input = scan.nextLine();
					
			if(input.equals("1")) {//뒤로가기
									
				printMyinfo();
				
			} else if (input.equals("2")) {//처음으로가기	
				MemberStart.First();
									
			} else {
				
				Member.mEmail = input;				
				emailEdit(input); //변경하는 메소드
				
			}//if
			
			}//for
			
		}
		
		//이메일변경
		private void emailEdit(String input) {
			
						
			//현재 고객정보 목록 불러오기
			String path = "C:\\DDGCinema_data\\고객정보.txt";
			File dir = new File(path);
					
			
			//파일 읽어 오고 list에 저장
			ArrayList<String> list = new ArrayList<String>();

			BufferedReader reader;
			try {
				reader = new BufferedReader
						(new FileReader("C:\\DDGCinema_data\\고객정보.txt"));
				
				String line = null;
				
				try {
					while((line = reader.readLine()) != null) {
									
						list.add(line+"\n"); 
						
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}//try-catch
			 		
			//이메일 유효성 검사
			if(input.contains("@") && (input.contains(".com") || input.contains(".co.kr") || input.contains(".net"))) {
				
			} else {
										
				editEmailFail(); //이메일변경 실패
			}
						
			dir.delete(); //기존 파일 삭제 하기
					
			//파일 다시 쓰고 저장하기
			try {
				BufferedWriter writer = new BufferedWriter
						(new FileWriter("C:\\DDGCinema_data\\고객정보.txt", true));
				
				for (String text : list) {
					
					String[] m = new String[11];
					m = text.split("■");
					String info = "";
													
					if(Member.getmNum().equals(m[0]))  {
						
						writer.write(text.replaceFirst(Member.getmEmail(), input));			
									
					} else {
						writer.write(text);
					}
					
											
				}
									
				writer.close();
				editEmailSuccess(); //이메일 변경 성공 출력
							
			} catch (IOException e) {
				e.printStackTrace();
			}//try-catch
		}
		
		//이메일 변경 성공시
			private void editEmailSuccess() {
					
				boolean loop = true;
				
				for (;loop;) {
				
				Scanner scan = new Scanner(System.in);
				
				System.out.println("이메일 변경에 성공하였습니다. 번호를 선택하여 주세요.");
				System.out.println("==============================");
				System.out.println("1. 뒤로가기");
				System.out.println("2. 처음으로 돌아가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");
								
				int num = scan.nextInt();
				
				switch(num) {
				case 1: //뒤로가기
					printMyinfo();
				case 2:	//처음으로가기
					MemberStart.First();	
				}//switch
				
				}//for
				

			}
					
			
			//이메일 변경 실패시
			private void editEmailFail() {
							
				boolean loop = true;
				
				for (;loop;) {
				
				Scanner scan = new Scanner(System.in);
					
				System.out.println("이메일 변경에 실패하였습니다. 번호를 선택하여 주세요.");
				System.out.println("==============================");
				System.out.println("1. 뒤로가기");
				System.out.println("2. 처음으로 돌아가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");
								
				int num = scan.nextInt();
					
				switch(num) {
				case 1: //뒤로가기
					editEmail();
				case 2:	//처음으로가기
					MemberStart.First();		
				}//switch

				}//for
				
			}
	
}//Myinfo
