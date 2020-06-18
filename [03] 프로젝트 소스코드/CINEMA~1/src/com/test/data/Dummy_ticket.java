package com.test.data;

import java.io.FileWriter;

public class Dummy_ticket {
	
	public static void main(String[] args) {
		


		String filename = "Dummy_Ticket.txt";
		
		try {
			
			//==========================================================================
			//예매 번호 
			FileWriter input = new FileWriter("C:\\Users\\user\\Desktop\\학원\\프로젝트\\더미파일\\"+ filename);
			
			
			
			//인원수와 동일
			int count = 10000;
			
			//예약번호
			int reserveNum = 0;
			String reserveWord = " ";
			String reserveResult = " ";
			
			//날짜
			int reserveYear = 2020;	//년
			int reserveMonth = 0;	//월
			int reserveDate = 0;	//일
			
			//지점
			String reserveStore ;
			String reserveMovie ;
			
			//날짜
			int reserveScreen;
			
			//상영 시간
			int reserveTime ;
			int reserveMinute ;
			String timeMinute;
			
			//성인
			int reserveAdult;
			String adultResult;
			
			//청소년
			int reserveYouth;
			String YouthResult;
			
			//우대
			int reserveOld;
			String OldResult;
			
			//지점
			String[] store = {"강남점","강변점","건대입구점","구로점","대학로점","동대문점"
									,"등촌점","명동점","목동점","미아점","불광점","상봉점","성신여대입구점"};
			
			String[] movieTitle = {"어벤져스","인터스텔라","데드풀","어바웃타임","건축학개론","라라랜드",
					"테이큰","미션임파서블","분노의질주","베테랑","조커","추격자","타짜","그레이의50가지그림자"
					,"방자전","아가씨","토이스토리","겨울왕국","센과치히로의행방불명","기생충"};
			
			
			
			//예약번호 ( 0부터 숫자 순서대로 ,, 대문자1자리)
			//숫자 + 영어 대문자 
			for ( int i=0; i<count; i++) {
				
	
				reserveNum = i ;
				String word = String.format("%04d", reserveNum);
				

			
				// 65 ='A'
				reserveWord = (char)((int)(Math.random()*26)+65) + "";	//65~90 문자코드값 -> 대문자 A ~ Z 
				
				

				reserveResult = word + reserveWord + "■" ;

				//System.out.println(numResult);

				
//				input.write(reserveResult);


				
				
				//==========================================================================
				
				//예매 날짜 
				
				reserveMonth = (int)(Math.random()*5)+1;	//2020년 1월 ~ 4월 
				reserveDate = (int)(Math.random()*31)+1;	//월 마다 1일~31일
				
				reserveResult += (reserveYear + "년"+ " " ) + (reserveMonth + "월"+ " " ) +(reserveDate + "일"+ " " ) + "■";
				

				
				//==========================================================================
				
				//지점
				
				reserveStore = store[(int)(Math.random()* store.length)];
				
				reserveResult += reserveStore+ "■" ;
	
				
				
				//==========================================================================
				
				//영화제목 
				
				reserveMovie = movieTitle[(int)(Math.random()* movieTitle.length)];
				
				reserveResult += reserveMovie+ "■" ;

				
				//==========================================================================
				
				//관
				
				reserveScreen = (int)(Math.random()*10)+1;	//1~10 관 
				
				reserveResult += reserveScreen+  "관" + "■"  ;

				
				
				//==========================================================================
				
				//상영시간
				
				reserveTime = (int)(Math.random()*12)+1;
			    reserveMinute =	(int)(Math.random()*60)+1;
			    
			    timeMinute = ( reserveTime + " " +"시") + " : "+(reserveMinute + " " +"분" +"■" );
			    
			    reserveResult += timeMinute ;
				
			    
				
			    
				
				//==========================================================================
				
				//성인
			    
			    reserveAdult = (int)(Math.random()*10)+1;	//한번에 성인 최대 10명 예매 가능 
			    
			    adultResult = reserveAdult +"■" ;
			    
			    reserveResult +=adultResult;
			    
				//==========================================================================
				
				//청소년
			    
			    reserveYouth = (int)(Math.random()*10)+1;	//한번에 청소년 최대 10명 예매 가능 
			    
			    YouthResult = reserveYouth +"■" ;
			    
			    reserveResult += YouthResult;
			    
				//==========================================================================
				
				//우대 
			    
			    reserveOld = (int)(Math.random()*10)+1;	//한번에 청소년 최대 10명 예매 가능 
			    
			    OldResult = reserveOld+ "\r\n";
			    
			    reserveResult += OldResult;
			    
			    
			    
			    
			    System.out.println(reserveResult);
			    
				
				input.write(reserveResult);
				
				reserveResult = " ";
			}//for
			
			input.close();
			System.out.println("완료");
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	

		//예매 날짜
		
		
		

			
			
		
		
	}//main

}//Dummy
