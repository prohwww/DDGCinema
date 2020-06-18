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

public class MyCard {

	//카드 관리 화면출력
	 public void printMyCard() {
				
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("현재 카드 잔액은 \'%d\'원 입니다.\n", Member.mCard);
		System.out.println("==============================");				
		System.out.println("1. 카드 금액 충전하기");
		System.out.println("2. 카드 금액 인출하기");
		System.out.println("3. 뒤로가기");
		System.out.println("4. 처음으로가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
				
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //카드 금액 충전하기
			
			//금액 충전하기
			//MyCard.moneyIn();
			System.out.println("==============================");
			System.out.println("카드 금액 충전");
			System.out.println("충전할 금액을 입력해 주세요: ");
			
			scan = new Scanner(System.in);
			int addMoney = scan.nextInt();
			Member.mCard += addMoney;
			
			System.out.println("==============================");
			System.out.println("충전이 완료 되었습니다.");
			System.out.printf("충전 후 카드 잔액 : %d\n",Member.mCard);
			System.out.println("==============================");
			break;
			
		case 2:	
			
			//금액 인출하기
			//MyCard.moneyOut();
			
			System.out.println("==============================");
			System.out.println("카드 금액 인출");
			System.out.println("인출할 금액을 입력해 주세요. :");
			
			scan = new Scanner(System.in);
			int outMoney = scan.nextInt();
			Member.mCard -= outMoney;
			
			System.out.println("==============================");
			System.out.println("인출이 완료 되었습니다.");
			System.out.printf("인출 후 카드 잔액 : %d\n", Member.mCard);
			System.out.println("==============================");
			break;
			
		case 3:	//뒤로가기	
			return;			
		case 4: //처음으로가기
			MemberStart.First();
		}//switch
		
		}//for
		
	}
	
}


































//밑에 원래 있던 코드




//package com.test.cinema.member;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.test.cinema.Member;
//
//
//public class MyCard {
//
////	public static void main(String[] args) {
////		
////		//test하기 위한 코드
////		//moneyCheck("vHrMND8");
////		moneyOut("vHrMND8");
////	}
//	
//	
//	//카드 잔액 조회하기
//	//카드 잔액을 조회하기 위한 회원 id를 인자값으로 받아와야 한다.
//	public static void moneyCheck() {
//		
//
//		//고객정보.txt 파일 읽어오기
//		try {
////			BufferedReader reader = new BufferedReader(new FileReader("C:\\고객.직원.더미데이터\\고객정보.txt"));
//			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\학원\\프로젝트\\더미파일\\더미text파일\\고객정보.txt"));
//			Scanner scan = new Scanner(System.in);
//			
//			String line = null;
//			
//			//txt 파일 한줄씩 읽기
//			while((line = reader.readLine()) != null) {
//				//회원번호■아이디■비밀번호■이름■주민번호■주소■휴대폰번호■이메일주소■마일리지■등급■카드잔액
//				String[] member = new String[13]; 
//				member = line.split("■");
//
//				//인수로 받아온 회원 id와 같은 id를 찾은 경우
//				if(member[1].equals(Member.mId)) {
//					
//					//카드 잔액 출력을 위한 변수 card에 line에서 찾은 회원의 카드 잔액 저장
//					int currentSum = Integer.parseInt(member[12]);
//					
//					System.out.println("==============================");
//					System.out.printf("현재 카드 잔액은 %,d원 입니다.\n", currentSum);
//					System.out.println("1. 뒤로가기");
//					System.out.println("2. 처음으로 돌아가기");
//					System.out.println("==============================");
//					System.out.print("메뉴 선택 : ");
//					int num = scan.nextInt();
//					
//					switch(num) {
//					case 1:
//						//금액 충전을 위한 test코드
//						moneyIn();
//						break;
//					case 2:
//						MemberStart m = new MemberStart();
//						m.First();
//						break;
//					}
//					
//				}
//				
//			}
//			
//			reader.close();
//			scan.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	
//	}
//	
//	
//	
//	//금액 충전하기
//	//현재 회원의 금액 인자로 받아오기
//	public static void moneyIn() {
//		
//		//충전할 금액 입력
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("==============================");
//		System.out.println("**금액을 충전하려면 충전 금액을 입력하세요.**");
//		System.out.print("입력 : ");
//		int num = scan.nextInt();
//		System.out.println("==============================");
//		
//
//		//수정할 회원의 id 찾기
//		String path = "C:\\고객.직원.더미데이터\\고객정보.txt";
//		File dir = new File(path);
//		
//		//한줄씩 배열에 저장하여 파일 삭제한 후, 파일을 새로 생성하여 배열값을 txt파일에 다시 저장
//		ArrayList<String> list = new ArrayList<String>();
//		
//		BufferedReader reader;
//		
//		try {
//			reader = new BufferedReader(new FileReader("C:\\고객.직원.더미데이터\\고객정보.txt"));
//			
//			String line = null;
//			try {
//				while((line = reader.readLine()) != null) {
//					//회원정보의 마지막 값인 현재 가지고 있는 금액값을 변수 b에 저장
//					int a = line.lastIndexOf("■");	
//					String b = line.substring(a+1);
//					
//					//금액을 변경하기 위한 회원 id와 같은 id를 찾기 위해 id값만 받아와서 변수 d에 저장
//					int c = line.indexOf("■");
//					int d = line.indexOf("■", c+1);	//c+1 인덱스 값 ~ 두번째 ■ 까지 
//					String e = line.substring(c+1,d);
//					
//					
//					//찾고싶은 회원 id와 같은 id를 가진 회원을 발견한 경우
//					if(e.equals(Member.mId)) {
//						
//						//충전할 금액(num)을 현재 가지고 있는 금액(b)에 충전한 값 newNum
//						int newNum = Integer.parseInt(b) + num;
//						
//						//충전한 새로운 금액 newNum을 변수 b에 새로 저장
//						b = Integer.toString(newNum);
//						
//						//새로운 금액을 해당 회원의 정보에 수정하는 코드
//						line = line.substring(0,a+1) + b;
//
//						System.out.println("==============================");
//						System.out.printf("%d원이 성공적으로 충전되었습니다.\n", num);
//						System.out.printf("충전 후 총 잔액은 %,d원 입니다.\n", newNum);
//						System.out.println("==============================");
//						
//					}
//					//txt파일에서 한줄씩 읽어오는 데이터를 list 배열에 저장
//					list.add(line);
//					}
//
//				reader.close();
//
//			} catch(Exception e) {
//				System.out.println("데이터가 없습니다.");
//			}
//		} catch(Exception e) {
//			System.out.println("파일이 없습니다.");
//		}
//		
//		dir.delete();
//		
//		
//		//배열에 저장해놓은 txt데이터를 고객정보.txt파일 새로 생성 후 저장하기 위해
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\고객.직원.더미데이터\\고객정보.txt"));
//			
//			for(String txt : list) {
//				writer.write(txt + "\r\n");
//			}
//			
//			writer.close();
//		} catch(Exception e) {
//			System.out.println("writer 틀림");
//		}
//		
//		
//		System.out.println("1.뒤로가기");
//		System.out.println("2. 처음으로 가기");
//		System.out.println("==============================");
//		System.out.printf("입력 : ");
//		int num2 = scan.nextInt();
//		
//		switch(num2) {
//		case 1:
//			break;
//		case 2:
//			MemberStart ms = new MemberStart();
//			ms.First();
//			break;
//		}
//		
//		
//	}
//
//	
//	
//	//금액 인출하기
//	public static void moneyOut() {
//		//인출하려는 금액 입력받기
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("==============================");
//		System.out.println("***인출하려는 금액을 입력하세요.***");
//		System.out.print("입력 : ");
//		int num = scan.nextInt();
//		System.out.println("==============================");
//		
//		//수정할 회원의 id찾기
//		String path = "C:\\고객.직원.더미데이터\\고객정보.txt";
//		File dir = new File(path);
//		
//		//한줄씩 배열에 저장하여 파일 삭제한 후, 파일을 새로 생성하여 배열값을 txt파일에 다시 저장
//		ArrayList<String> list = new ArrayList<String>();
//		
//		BufferedReader reader;
//		
//		//인출에 성공했는지 실패했는지 알려주는 flag변수
//		Boolean flag = true;
//		int newNumTemp=0;
//		
//		try {
//			reader = new BufferedReader(new FileReader("C:\\고객.직원.더미데이터\\고객정보.txt"));
//			
//			String line = null;
//			try {
//				while((line = reader.readLine()) != null) {
//					//회원정보의 마지막 값인 현재 가지고 있는 금액을 변수 b에 저장
//					int a = line.lastIndexOf("■");
//					String b = line.substring(a+1);
//					
//					//금액을 변경하기 위한 회원 id와 같은 id를 찾기 위해 id값만 받아와서 변수 e에 저장
//					int c = line.indexOf("■");
//					int d = line.indexOf("■", c+1);
//					String e = line.substring(c+1,d);
//
//					
//					//찾고 싶은 회원 id와 같은 id를 가진 회원을 발견한 경우
//					if(e.equals(Member.mId)) {
//						
//						//인출할 금액(num)을 현재 가지고 있는 금액(b)에서 인출한 값 newNum
//						int newNum = Integer.parseInt(b) - num;
//
//						//인출한 후의 잔액이 0원 이상인 경우
//						if(newNum >= 0) {
//							//인출한 새로운 금액 newNum을 변수 b에 새로 저장
//							b = Integer.toString(newNum);
//							
//							//새로운 금액을 해당 회원의 정보에 수정하는 코드
//							line = line.substring(0,a+1) + b;
//							
//							System.out.println("==============================");
//							System.out.println("인출이 성공적으로 완료되었습니다.");
//							System.out.printf("인출 후 남은 잔액은 %,d원 입니다.\n", newNum);
//							System.out.println("==============================");
//							System.out.println();
//							
//						}
//						//인출한 후의 잔액이 잔액부족인 경우
//						else {
//							flag = false;
//							newNumTemp = Integer.parseInt(b) - num;
//						}
//						
//					}//같은 id를 발견한 if문
//					
//					//txt파일에서 한줄씩 읽어오는 데이터를 list배열에 저장
//					list.add(line);
//
//				}//텍스트데이터 한줄씩 검사하는 while문
//				reader.close();
//			}//try문
//			catch(Exception e){
//				System.out.println("데이터가 없습니다.");
//			}//catch문
//		}//try문
//		catch(Exception e) {
//			System.out.println("파일이 없습니다.");
//		}//catch문
//
//		dir.delete();
//		
//		//배열에 저장해놓은 txt데이터를 고객정보.txt 파일 새로 생성 후 저장하기
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\고객.직원.더미데이터\\고객정보.txt"));
//			
//			for(String txt : list) {
//				writer.write(txt + "\r\n");
//			}
//			writer.close();
//		} catch(Exception e) {
//			System.out.println("writer 틀림");
//		}
//		
//		//금액 인출 성공한 경우
//		if(flag) {
//			System.out.println("1. 뒤로가기");
//			System.out.println("2. 처음으로 돌아가기");
//			System.out.println("==============================");
//			System.out.print("선택 : ");
//			int num2 = scan.nextInt();
//			
//			switch(num2) {
//			case 1:
//				//뒤로 가기
//				break;
//			case 2:
//				MemberStart ms = new MemberStart();
//				ms.First();
//				break;
//			}
//		}
//		//금액 인출 실패한 경우
//		else {
//			System.out.println("==============================");
//			System.out.printf("%,d원이 부족하여 인출에 실패하였습니다.\n", Math.abs(newNumTemp));
//			System.out.println("==============================");
//			System.out.println();
//			System.out.println("1. 충전하기");
//			System.out.println("2. 뒤로가기");
//			System.out.println("3. 처음으로 가기");
//			System.out.println();
//			System.out.println("==============================");
//			System.out.print("선택 : ");
//			int num3 = scan.nextInt();
//			
//			switch(num3) {
//			case 1:
//				moneyIn();
//				break;
//			case 2:
//				//뒤로가기
//				break;
//			case 3:
//				MemberStart ms = new MemberStart();
//				ms.First();
//				break;
//			}
//			
//		}
//	}//moneyOut
//	
//}
//						
//	
//	
//
//








