package com.test.cinema.store;

import java.util.Scanner;

public class EmployeeManagement {

	Scanner scan = new Scanner(System.in);
	
	public void eManagement() {
		
		System.out.println("==================================================================");
		System.out.println("1. 직원 조회");
		System.out.println("2. 직원 추가");
		System.out.println("3. 직원 수정");
		System.out.println("4. 직원 삭제");
		System.out.println("5. 뒤로가기");
		System.out.println("6. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		int num = scan.nextInt();
		
		switch (num) {
			
		case 1:
			SearchEmployee s = new SearchEmployee();
			s.eSearch();
			break;
		case 2:
			AddEmployee a = new AddEmployee();
			a.eAdd();
			break;
		case 3:
			EditEmployee e = new EditEmployee();
			e.eEdit();
			break;
		case 4:
			DeleteEmployee d = new DeleteEmployee();
			d.eDelete();
			break;
		case 5:
			StoreStart g = new StoreStart();
			g.managerStart();
			break;
		case 6:
			StoreStart q = new StoreStart();
			q.managerStart();
			break;
			
		}
		
	}


	
}
