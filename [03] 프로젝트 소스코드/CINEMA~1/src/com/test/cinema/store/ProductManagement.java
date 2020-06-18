package com.test.cinema.store;

import java.util.Scanner;

public class ProductManagement {
	Scanner scan = new Scanner(System.in);
	
	public void pSearch() {
		
		System.out.println("==================================================================");
		System.out.println("1. 상품 조회");
		System.out.println("2. 상품 추가");
		System.out.println("3. 상품 수정");
		System.out.println("4. 상품 삭제");
		System.out.println("5. 뒤로가기");
		System.out.println("6. 처음으로 돌아가기");
		System.out.println("==================================================================");
		System.out.print("메뉴 입력 : ");
		int num = scan.nextInt();
		
		switch (num) {
		
		case 1:
			SearchProduct s = new SearchProduct();
			s.pCheck();
			break;
		case 2:
			AddProduct n = new AddProduct();
			n.pAdd();
			break;
		case 3:
			EditProduct e = new EditProduct();
			e.pEdit();
			break;
		case 4:
			DeleteProduct d = new DeleteProduct();
			d.pDelete();
			break;
		case 5:
			StoreStart a = new StoreStart();
			a.managerStart();
		case 6:
			StoreStart q = new StoreStart();
			q.managerStart();
		}
	}
}
