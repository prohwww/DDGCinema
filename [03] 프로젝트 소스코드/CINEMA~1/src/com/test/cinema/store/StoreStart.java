package com.test.cinema.store;

import java.util.Scanner;

import com.test.cinema.Logout;

public class StoreStart {

	public static void main(String[] args) {

		
		managerStart();
	}

	public static void managerStart() {
		Scanner scan = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			//System.out.println("매장 관리자로 로그인하셨습니다.");
			System.out.println("==============================");
			System.out.println("1. 상영 영화 관리");
			System.out.println("2. 판매량 & 매출 관리");
			System.out.println("3. 직원 관리");
			System.out.println("4. 상품 재고 관리");
			System.out.println("5. 로그아웃");
			System.out.println("==============================");
			System.out.print("메뉴 선택 : ");
			int num = scan.nextInt();

			switch (num) {
			// 상영 영화 관리
			case 1:
				MovieManagement m = new MovieManagement();
				try {
					m.mSearch();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			// 판매량 & 매출 관리
			case 2:
				SalesManagement s = new SalesManagement();
				s.sProduct();
				break;
			//직원 관리
			case 3:
				EmployeeManagement e = new EmployeeManagement();
				e.eManagement();
				break;
			//상품 재고 관리
			case 4:
				ProductManagement p = new ProductManagement();
				p.pSearch();
				break;
			//로그아웃
			case 5:
//				Logout l = new Logout();
//				l.logoutSave();
				return;
				//break;

			}
		}
	}

}