package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.cinema.Member;

public class Pay {

	
	//공용 데이터 
	public static int adultNum;
	public static int youthNum;
	public static int oldNum;
	
	public static int adultPay;
	public static int youthPay;
	public static int oldPay;
	public static int totalPay;
	//public static int money;
	public static int refund;
	
	
	public static double disCount;
	public static double point;
	
	public static String[] textSplitClient;	//고객 정보 나눠 담을 배열 
	public static String[] textSplitReserve;//예매 정보 나눠 담을 배열 
	
	//예매 번호 저장할 배열  , 10000 (인원수)
	static String[] ticketNumber = new String[10000];
	
	
	//*******************
	//상품 공용 데이터 
	//상품 클래스에서 결제 금액 누적시켜서 productTotalPay에 누적 
	public static int productTotalPay;	//상품 총 결제 금액 
	
	//상품 클래스에서 선택해서 장바구니에 담을 상품 이름 저장 시켜서 productName에 저장 
	public static String productName;	//상품 이름 
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
		
	static void payPay() {
		
		
		try {
			//고객 정보 배열에 나눠 담기
			BufferedReader reader = new BufferedReader(new FileReader("C:\\DDGCinema_data\\고객정보.txt"));
			
			String text = " ";
			
			
			//나눠 저장할 배열 
			textSplitClient = null;
			
			//할인률 
			disCount = 0;
			
			//최종 결제할 금액 
			//임의로 10000원 적었음.
			 //money = 10000;
			
			//적립금 
			point = 0;
			
			while((text = reader.readLine())!= null) {
				
				textSplitClient = text.split("■");
			
			}//while
			
			
			
			//예매 정보 배열에 담기 
			BufferedReader reader2 = new BufferedReader(new FileReader("C:\\DDGCinema_data\\마이페이지_Dummy_Ticket.txt"));
			
			String text2 = " ";
			 textSplitReserve = null;
			
			 int i=0;
			while((text2 = reader2.readLine())!= null) {
//				textSplitReserve = text2.split("■");
				
				int index2 = text2.indexOf("■");
				ticketNumber[i]=text2.substring(0,index2);
				i++;



			}//while
			

			
			//성인, 청소년, 우대 금액 
			adultPay = adultNum * 12000;
			youthPay = youthNum * 9000;
			oldPay = oldNum * 7000;
			
			
			
			
				//System.out.println("::::"+Member.mGrade);
				if(Member.mGrade.equals("플레티넘")) {
					
					//플레티넘 고객 20% 할인 
					disCount =  0.2;
					//money *= (1-disCount);
					point = 0.07;								//적립률
					totalPay = adultPay + youthPay + oldPay ;	//총 결제 금액 
					totalPay *= (1-disCount);					//할인 적용된 총 결제 금액 
					
				} else if (Member.mGrade.equals("골드")) {
					
					//골드 고객 10% 할인 
					disCount =  0.1;
					//money *= (1-disCount);
					point = 0.05;
					totalPay = adultPay + youthPay + oldPay ;
					totalPay *= (1-disCount);
					
				} else if (Member.mGrade.equals("실버")) {
					
					//실버 고객 5% 할인 
					disCount =  0.05;
					//money *= (1-disCount);
					point = 0.03;
					totalPay = adultPay + youthPay + oldPay ;
					totalPay *= (1-disCount);
				}
				
				//이걸 대체 왜썼냐
				//payPay();
				
				
		} catch (Exception e) {
			
			
			
			e.printStackTrace();
		}
		
		
	
		
		
//	}//main
	

//				 static void payPay() {
				
				while(true){
					

					try {
							
							
							
							//***********************
							//이 코드는 더미데이터에서 가져온 마지막 줄 데이터로 실행 한 코드 
							//회원 정보에서 정보 가져와서 사용해야 함. 회원정보 완성되면 코드 수정 해야함.
							//***********************

								
								
								
								System.out.println("==============================");
								System.out.printf("고객님의 등급이 %s 이므로 %,d%% 할인됩니다.\n",Member.mGrade,(int)(Pay.disCount*100));
								System.out.printf("결제할 금액은 %,d원 입니다.\n",	Pay.totalPay );
								System.out.println("결제 하시겠습니까?");
								System.out.println("==============================");
								System.out.println("1.결제하기 \n2.마일리지 \n3.뒤로가기\n4.처음으로 가기");
								System.out.println("==============================");
								System.out.print("메뉴 선택 : ");
								System.out.println();
								
								Scanner scan = new Scanner(System.in);
								int input = scan.nextInt();
								

								
								
								
								switch(input) {
								
								case 1:
									//결제하기
									if(Member.mCard >= Pay.totalPay ) {
										//성공 			
										//영화 예매 결제 성공 : 1 
										//상품 결제 성공은 : 2 
										ChoicePay.choicePaySuccess(1);
									
									} else { 
										//실패
								    	ChoicePay.choicePayFail();

									}//else 
									
									
								case 2:
									//마일리지
									
									if(Member.mMileage >= 5000) {
										//마일리지가 5000점 이상이면 
										Mileage.mileageSuccess();

									} else {
										//마일리지가 5000점이 안되는 경우 
										Mileage.mileageFail();

									}
									
									
								case 3:
									//뒤로가기
									//결제 메뉴 선택 화면으로 이동 
									MoviePaymentMenu.payMentMenu();
									
								case 4:
									//처음으로 가기 
									MemberStart.First();
									
									
								}//switch

								
							
						} catch (Exception e) {
							
							e.printStackTrace();
						}


			
				}//while
		
	}//PayFirst


	
	
	
	
	
	
	
	
	
	
	
	public static void payPayProduct(){
		
		
		
		
		adultPay = adultNum * 12000;
		youthPay = youthNum * 9000;
		oldPay = oldNum * 7000;
		
		
		
		
			//System.out.println("::::"+Member.mGrade);
			if(Member.mGrade.equals("플레티넘")) {
				
				//플레티넘 고객 20% 할인 
				disCount =  0.2;
				//money *= (1-disCount);
				point = 0.07;								//적립률
				totalPay = adultPay + youthPay + oldPay ;	//총 결제 금액 
				totalPay *= (1-disCount);					//할인 적용된 총 결제 금액 
				
			} else if (Member.mGrade.equals("골드")) {
				
				//골드 고객 10% 할인 
				disCount =  0.1;
				//money *= (1-disCount);
				point = 0.05;
				totalPay = adultPay + youthPay + oldPay ;
				totalPay *= (1-disCount);
				
			} else if (Member.mGrade.equals("실버")) {
				
				//실버 고객 5% 할인 
				disCount =  0.05;
				//money *= (1-disCount);
				point = 0.03;
				totalPay = adultPay + youthPay + oldPay ;
				totalPay *= (1-disCount);
			}
			
			
			
			
			
			
			while(true) {
		
				try {
					//상품 결제 
			
					System.out.println("==============================");
					System.out.printf("고객님의 등급이 %s 이므로 %,d%% 할인됩니다.\n",Member.mGrade,(int)(Pay.disCount*100));
					System.out.printf("결제할 금액은 %,d원 입니다.\n",	Pay.productTotalPay );
					System.out.println("결제 하시겠습니까?");
					System.out.println("==============================");
					System.out.println("1.결제하기 \n2.마일리지 \n3.뒤로가기\n4.처음으로 가기");
					System.out.println("==============================");
					System.out.print("메뉴 선택 : ");
					System.out.println();
					
					Scanner scan = new Scanner(System.in);
					int input = scan.nextInt();
					
			
					
					
					
					switch(input) {
					
					case 1:
						//결제하기
						if(Member.mCard >= Pay.productTotalPay ) {
							//성공 			
							//영화 예매 결제 성공 : 1 
							//상품 결제 성공은 : 2 

							ChoicePay.choicePaySuccess(2);
						
						} else { 
							//실패
					    	ChoicePay.choicePayFail();
			
						}//else 
						
						
					case 2:
						//마일리지
						
						if(Member.mMileage >= 5000) {
							//마일리지가 5000점 이상이면 
							Mileage.mileageSuccess();
			
						} else {
							//마일리지가 5000점이 안되는 경우 
							Mileage.mileageFail();
			
						}
						
						
					case 3:
						//뒤로가기
						//결제 메뉴 선택 화면으로 이동 
						MoviePaymentMenu.payMentMenu();
						
					case 4:
						//처음으로 가기 
						MemberStart.First();
						
						
					}//switch
			
					
			
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		
		
		
		
		
				
			}//payPayProduct
	
	
	}
	
	
	
	
	

}//Pay
