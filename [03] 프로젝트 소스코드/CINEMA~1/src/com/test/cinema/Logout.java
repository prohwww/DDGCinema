package com.test.cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Logout {
	
	private File customerFile = new File("C:\\DDGCinema_data\\고객정보.txt");
	
	//전체 파일 담을 배열
	private ArrayList<String> wholeList = new ArrayList<String>();
	
	//위, 아래부분 내용 담을 배열
	private ArrayList<String> upList = new ArrayList<String>();
	private ArrayList<String> downList = new ArrayList<String>();
	
	
	public void logoutSave() {
		//로그아웃시 멤버의 정보 수정하여 덮어쓰는 메소드
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(customerFile));
			
			String line = null;
			
			int index=0;
			int indexMem = 0; //해당 고객 몇번째 줄인지
			
			//1. 파일 전체 내용 읽기
			while((line = reader.readLine()) != null) {
				
				String[] array = line.split("■");
				
				wholeList.add(line);
				
				if(array[0].equals(Member.getmNum())) {
					//고객번호랑 같은 줄 찾기
					indexMem = index;
				}
				
				index++;
				
			}//while
			
			//2. 멤버의 회원번호 조회하여 윗부분 따로 저장
			for(int i=0; i<indexMem; i++) {
				upList.add(wholeList.get(i));
			}
			
			//3. 멤버의 회원번호 아랫부분 따로 저장
			for(int i=indexMem; i<wholeList.size(); i++) {
				downList.add(wholeList.get(i));
			}
			
			//고객정보 한줄로 정리하기
			//회원번호■아이디■비밀번호■이름■주민번호■주소■휴대폰번호■이메일주소■마일리지■등급■카드잔액
			String member = Member.getmNum()+"■" + Member.getmId() + "■" + Member.getmPwd() + "■" + Member.getmName()
							+ "■" + Member.getmJumin() + "■" + Member.getmAddress() + "■" + Member.getmPhone() + "■"
							+ Member.getmEmail() + "■" + Member.getmMileage() + "■" + Member.getmGrade() + "■" + Member.getmCard();
			
			
			//4. 파일 쓰기 2 -> 멤버 정보 -> 3
			BufferedWriter writer = new BufferedWriter(new FileWriter(customerFile));
			
			for(String str : upList) {
				writer.write(str);
				writer.newLine();
			}
			
			writer.write(member);
			writer.newLine();
			
			for(String str : downList) {
				writer.write(str);
				writer.newLine();
			}
			
			reader.close();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
