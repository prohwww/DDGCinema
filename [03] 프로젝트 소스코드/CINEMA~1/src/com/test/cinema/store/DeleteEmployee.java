package com.test.cinema.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteEmployee {

	//직원 삭제 메소드
	public void eDelete() {
		
		Scanner scan = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>();
		File file = new File("C:\\DDGCinema_data\\직원정보.txt");
		BufferedReader reader = null;
		
		String line =null;
		reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {
			System.out.println("==================================================================");
			System.out.println("삭제할 직원 번호를 입력하세요.");
			System.out.println("==================================================================");
			System.out.print("직원 번호 입력 : ");
			String num = scan.nextLine();
			
			while ((line = reader.readLine()) != null) {
				
				String[] employee = new String[11];
				employee = line.split("■");

				//입력된 직원 번호가 일치하면 list에 추가를 안한다.
				if (employee[0].equals(num)) {

					//일치하지 않으면 list에 추가
				} else {
					list.add(line);
				}
			}
			System.out.println("직원이 삭제되었습니다.");
			reader.close();
			file.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for (String s : list) {
				writer.write(s + "\r\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==================================================================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		String input = scan.nextLine();

		if (input.equals("1")) {
			EmployeeManagement s = new EmployeeManagement();
			s.eManagement();
		} else if (input.equals("2")) {
			StoreStart a = new StoreStart();
			a.managerStart();
		}
	}
	}

