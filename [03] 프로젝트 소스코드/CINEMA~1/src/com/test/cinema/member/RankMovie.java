package com.test.cinema.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.test.cinema.Member;
import com.test.cinema.nonmember.NonmemberStart;

public class RankMovie {
//	public static void main(String[] args) {
//		try {
//			rankmovie() ;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	
	
	static ArrayList<String>rankList = new ArrayList<String>();
	static ArrayList<String>rankList2 = new ArrayList<String>();
	
	//ArrayList<String>rankPeople = new ArrayList<String>();
	
		
	public static void rankmovie() throws Exception {
		
//		ArrayList<String>rankList = new ArrayList<String>();
//		
		System.out.println("영화순위보기");
		System.out.println("번호를 선택하세요.");
		System.out.println("==============================");
		System.out.println("1.SF영화 별 순위");
		System.out.println("2.로맨스영화 별 순위 ");
		System.out.println("3.액션영화 별 순위");
		System.out.println("4.스릴러영화 별 순위");
		System.out.println("5.청소년관람불가영화 별 순위");
		System.out.println("6.애니메이션영화 별 순위");
		System.out.println("7.드라마영화 별 순위");
		System.out.println("8.뒤로가기");
		System.out.println("9.처음으로가기");
		System.out.println("==============================");
		System.out.print("메뉴선택:");
	
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		
		switch (num) {
		
		
		case 1 :
			//sf순위 목록으로
			
			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("SF");
			} else {
				//회원
				movieGenre("SF");
			}
			//회원?비회원?
			
			break;
			
		case 2 :
			//로맨스 순위
			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("로맨스");
			} else {
				//회원
				movieGenre("로맨스");
			}
			
			
			break;
			
		case 3 :
			
			//액션 순위
			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("액션");
			} else {
				//회원
				movieGenre("액션");
			}
			
			break;
			
		case 4 :
			
			//스릴러영화 순위가기
			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("스릴러");
			} else {
				//회원
				movieGenre("스릴러");
			}
			
			break;
			
			
		case 5 :
			//19세영화 순위가기

			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("19");
			} else {
				//회원
				movieGenre("19");
			}
			break;
			
		
		case 6 :
			//애니메이션 순위

			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("애니메이션");
			} else {
				//회원
				movieGenre("애니메이션");
			}
			break;
			
			
		case 7 :
			//드라마 순위

			if(Member.mNum.equals("0")) {
				//비회원
				movieGenreNon("드라마");
			} else {
				//회원
				movieGenre("드라마");
			}
			break;
			
		case 8 :
			//뒤로가기
			
			if(Member.mNum.equals("0")) {
				//비회원
				NonmemberStart.nonFirst();
			} else {
				//회원
				MemberStart.First();
			}
			
			
		
			break;
		case 9 :
			//처음으로가기
			if(Member.mNum.equals("0")) {
				//비회원
				NonmemberStart.nonFirst();
			} else {
				//회원
				MemberStart.First();
			}
		
			break;
			
			
		default :
			System.out.println("올바른 메뉴번호를 입력하세요.");
			
		
		}
		
		
		
		 }//rankmovie


	
	
	public static void movieGenreNon(String rankGenre) {
		
		//비회원 영화랭킹 조회 
		
		
		File file = new File("C:\\DDGCinema_data\\NowMovie.txt");
		//System.out.println(file.getAbsolutePath());
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			
			
			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		String line = null; // 목록 저장된 텍스트파일 출력
		
		List<String[]> flist = new ArrayList<String[]>();
		
		
		//int i =1;
		
		while((line = reader.readLine()) != null) {
			
			String[] ranklist = new String[20];
			
			ranklist = line.split("■");
			
			if(rankGenre.equals(ranklist[0])) {
				flist.add(ranklist);
			}
			
			
			//if(rankGenre.equals(ranklist[0])) {
			//System.out.println(i+"."+ranklist[0]+"   "+ranklist[1]+"  "+ranklist[2]);
			
			//i++; 
			//현재 상영영화 목록 종류별 영화이름 출력
			
			
			//rankList.add(ranklist[0]);
			
			//}
			
			
		}//while
		
		
		
		flist=flist.stream().sorted((s1,s2)->{
			
			return Integer.parseInt(s2[2]) - Integer.parseInt(s1[2]); 
			
		}).collect(Collectors.toList());
		

		//ArrayList<String>rankList2 = new ArrayList<String>();
		
		System.out.println("장르별 현재 순위입니다.영화를 선택하여주세요.");
		System.out.println("==============================");
		System.out.println("[장르]\t[영화제목]\t[관객수]");
		
		
		for (int i=0; i<flist.size(); i++) {
			
			//rankList2 영화제목 들어 있음. 
			rankList2.add(flist.get(i)[1]);
			
			System.out.println((i+1)+"."+flist.get(i)[0]+"\t"+flist.get(i)[1]+"\t"+flist.get(i)[2]);
			
		}
		
	reader.close();
		
		
		
	System.out.println("4.뒤로가기");
	System.out.println("5.처음으로가기");
	System.out.println("==============================");
	System.out.print("메뉴 입력:");
	
	Scanner scan = new Scanner(System.in);
	int num = scan.nextInt();
	
	
	
	//비회원은 rankMovieClik에서 예매하기 메뉴 보이면 안됨.
	if (num==1) {
		rankMovieClikNon(num, rankList2,rankGenre);
	} else if (num==2) {
		rankMovieClikNon(num, rankList2,rankGenre);
	}else if (num==3) {
		rankMovieClikNon(num,rankList2,rankGenre);
	}else if (num==4) {
		rankmovie();
	}else if (num==5) {
		//처음으로가기
		MemberStart.First();
	}
	
	
	
	
		
		scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		switch(number) {	

			
			
		case 1:
			rankReview(number, rankList2,rankGenre);
			break;
			
			
		case 2:
			rankStory(number, rankList2,rankGenre);
			break;
			
			
		case 3:
			//뒤로가기
			movieGenreNon(rankGenre);
			break;
			
			
		case 4:
			
			//처음으로가기
			MemberStart.First();
			break;
		
		default :
			System.out.println("올바른 번호를 입력하세요.");
		
		
		}//switch
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

	
	
//회원 영화 장르 순위 조회 
	public static void movieGenre(String rankGenre) {

		try {
			File file = new File("C:\\DDGCinema_data\\NowMovie.txt");
			//System.out.println(file.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null; // 목록 저장된 텍스트파일 출력
			
			List<String[]> flist = new ArrayList<String[]>();
			
			
			//int i =1;
			
			while((line = reader.readLine()) != null) {
				
				String[] ranklist = new String[20];
				
				ranklist = line.split("■");
				
				if(rankGenre.equals(ranklist[0])) {
					flist.add(ranklist);
				}
				
				
				//if(rankGenre.equals(ranklist[0])) {
				//System.out.println(i+"."+ranklist[0]+"   "+ranklist[1]+"  "+ranklist[2]);
				
				//i++; 
				//현재 상영영화 목록 종류별 영화이름 출력
				
				
				//rankList.add(ranklist[0]);
				
				//}
				
				
			}//while
			
			
			
			flist=flist.stream().sorted((s1,s2)->{
				
				return Integer.parseInt(s2[2]) - Integer.parseInt(s1[2]); 
				
			}).collect(Collectors.toList());
			

			//ArrayList<String>rankList2 = new ArrayList<String>();
			
			System.out.println("장르별 현재 순위입니다.영화를 선택하여주세요.");
			System.out.println("==============================");
			System.out.println("[장르]\t[영화제목]\t[관객수]");
			
			
			for (int i=0; i<flist.size(); i++) {
				
				//rankList2 영화제목 들어 있음. 
				rankList2.add(flist.get(i)[1]);
				
				System.out.println((i+1)+"."+flist.get(i)[0]+"\t"+flist.get(i)[1]+"\t"+flist.get(i)[2]);
				
			}
			
		reader.close();
		
			System.out.println("4.뒤로가기");
			System.out.println("5.처음으로가기");
			System.out.println("==============================");
			System.out.print("메뉴 입력:");
			
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			
			
			//비회원은 rankMovieClik에서 예매하기 메뉴 보이면 안됨.
			if (num==1) {
				rankMovieClik(num, rankList2,rankGenre);
			} else if (num==2) {
				rankMovieClik(num, rankList2,rankGenre);
			}else if (num==3) {
				rankMovieClik(num,rankList2,rankGenre);
			}else if (num==4) {
				rankmovie();
			}else if (num==5) {
				//처음으로가기
				MemberStart.First();
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		 }//try-catch
		
		

		//rankList.add;
		
		
		
	}//movieGenre




	private static void rankMovieClik(int num,ArrayList<String>rankList2,String rankGenre) { //장르별 영화 순위 목록에서 영화제목 선택 후 화면
		
		System.out.println(num + "번 영화를 선택하셨습니다. 번호를 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1.예매하기");
		System.out.println("2.리뷰 보기");
		System.out.println("3.줄거리 보기");
		System.out.println("4.뒤로가기");
		System.out.println("5.처음으로 가기");
		System.out.println("==============================");
		System.out.println("메뉴선택:");
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		switch(number) {
		
		case 1:
			
			//영화 예매하기 화면으로 가기
			//영화순위에서 영화이름 가져와야 함.
			MovieTheater.MovieName=rankList2.get(num-1);
			MovieTheater.TheaterChoice(rankList2.get(num-1));
			break;
			
			
		case 2:
			rankReview(num, rankList2,rankGenre);
			break;
			
			
		case 3:
			rankStory(num, rankList2,rankGenre);;
			break;
			
			
		case 4:
			//뒤로가기
			movieGenre(rankGenre);
			break;
			
			
		case 5:
			
			//처음으로가기
			//MemberStart.First();
			break;
		
		default :
			System.out.println("올바른 번호를 입력하세요.");
		
		
		}//switch
		
		
	}//rankMovieClik


	
	
	
	
	
	
	
	//비회원 장르별 순위에서 영화 선택 
	private static void rankMovieClikNon(int num,ArrayList<String>rankList2,String rankGenre) {
		
		
		System.out.println(num + "번 영화를 선택하셨습니다. 번호를 선택해주세요.");
		System.out.println("==============================");
		System.out.println("1.리뷰 보기");
		System.out.println("2.줄거리 보기");
		System.out.println("3.뒤로가기");
		System.out.println("4.처음으로 가기");
		System.out.println("==============================");
		System.out.println("메뉴선택:");
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		switch(number) {
		

			
			
		case 1:
			rankReview(num, rankList2,rankGenre);
			break;
			
			
		case 2:
			rankStory(num, rankList2,rankGenre);;
			break;
			
			
		case 3:
			//뒤로가기
			movieGenreNon(rankGenre);
			break;
			
			
		case 4:
			
			//처음으로가기
			MemberStart.First();
			break;
		
		default :
			System.out.println("올바른 번호를 입력하세요.");
		
		
		}//switch
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private static void rankStory(int num,ArrayList<String>rankList2,String rankGenre) {//줄거리보기 화면
		
		
		
			
			
			
		if(num==1) {
			System.out.println(num +"." + rankList2.get(0));
			System.out.print("줄거리 : ");
			System.out.println();
			System.out.println("“우린 답을 찾을 거야, 늘 그랬듯이”\r\n" + 
					"\r\n" + 
					"세계 각국의 정부와 경제가 완전히 붕괴된 미래가 다가온다. \r\n" + 
					" 지난 20세기에 범한 잘못이 전 세계적인 식량 부족을 불러왔고, NASA도 해체되었다. \r\n" + 
					" 이때 시공간에 불가사의한 틈이 열리고, 남은 자들에게는 이 곳을 탐험해 인류를 구해야 하는 임무가 지워진다.\r\n" + 
					" 사랑하는 가족들을 뒤로 한 채 인류라는 더 큰 가족을 위해, 그들은 이제 희망을 찾아 우주로 간다.\r\n" + 
					" 그리고 우린 답을 찾을 것이다. 늘 그랬듯이…");
			System.out.println("------------------------------");
			System.out.println("1.뒤로가기");
			System.out.println("2.처음으로가기");
			System.out.println("==============================");
			System.out.println("메뉴 입력: ");
			
			Scanner scan = new Scanner(System.in);
			int number = scan.nextInt();
			scan.skip("\r\n");
			
			if(number==1) {
				//뒤로가기
				if(Member.mNum.equals("0")) {
					//비회원 
					rankMovieClikNon(num,rankList2,rankGenre);
				}else {
					//회원 
					rankMovieClik(num,rankList2,rankGenre);
				}
				
				
				
			}else if (number==2) {
				//처음으로가기

				if(Member.mNum.equals("0")) {
					//비회원 
					NonmemberStart.nonFirst();
				}else {
					//회원 
					MemberStart.First();
				}
				
			}
			
			
			
			
		}else if (num==2) {
			System.out.println(num +"." + rankList2.get(1));
			System.out.print("줄거리 : ");
			System.out.println("인피니티 워 이후 절반만 살아남은 지구\r\n" + 
					" 마지막 희망이 된 어벤져스\r\n" + 
					" 먼저 떠난 그들을 위해 모든 것을 걸었다!\r\n" + 
					" \r\n" + 
					" 위대한 어벤져스\r\n" + 
					" 운명을 바꿀 최후의 전쟁이 펼쳐진다!");
			System.out.println("------------------------------");
			System.out.println("1.뒤로가기");
			System.out.println("2.처음으로가기");
			System.out.println("==============================");
			System.out.println("메뉴 입력: ");
			
			Scanner scan = new Scanner(System.in);
			int number = scan.nextInt();
			scan.skip("\r\n");
			
			if(number==1) {
				rankMovieClik(num,rankList2,rankGenre);
			}else if(number==2) {
				//처음으로가기
				MemberStart.First();
			}
			
		}else if(num==3 ) {
			System.out.println(num +"." + rankList2.get(2));
			System.out.print("줄거리 : ");
			System.out.println("잘못된 미래를 바로 잡기 위해 과거와 미래를 오가는 수퍼히어로들의 활약을 그린 SF 영화");
			System.out.println("------------------------------");
			System.out.println("1.뒤로가기");
			System.out.println("2.처음으로가기");
			System.out.println("==============================");
			System.out.println("메뉴 입력: ");
			
			Scanner scan = new Scanner(System.in);
			int number = scan.nextInt();
			scan.skip("\r\n");
			
			
			if(number==1) {
				rankMovieClik(num,rankList2,rankGenre);
			}else if (number==2){
				//처음으로가기
//				MemberStart.First();
				
				if(Member.mNum.equals("0")) {
					//비회원 
					NonmemberStart.nonFirst();
				}else {
					//회원 
					MemberStart.First();
				}
				
			}
			
		}else {
			System.out.println("올바른 번호를 입력하세요.");
		}
		
		

		
		
		
	}//rankStory




	private static void rankReview(int num,ArrayList<String>rankList2,String rankGenre) { //리뷰보기 화면
		
		 //ArrayList<String>rankList2 = new ArrayList<String>();

		System.out.println("선택하신 영화의 전체 리뷰 입니다.");
		System.out.println("==============================");
		System.out.println("[영화제목]\t\t        [리뷰 내용]\t\t      [평점]\t\t [작성일]");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	
		String title = rankList2.get(num-1);
		
		List<String[]> rlist = new ArrayList<String[]>();

		
		try {
			File file = new File("C:\\DDGCinema_data\\리뷰더미.txt");
			// System.out.println(file.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null; // 리뷰더미 읽어오기


			while ((line = reader.readLine()) != null) {

				
				if (line.contains(title)) {
					rlist.add(line.split("■"));
					
				}
							
			} // while
			reader.close();

		} catch (Exception e) {

			System.out.println(e);

		} // try-catch

		for (int i = 0; i < rlist.size(); i++) {
			//System.out.println(Arrays.toString(rlist.get(i)));
			
//			System.out.println((i + 1) + "." + rlist.get(i)[0] + "\t" + rlist.get(i)[1] + "\t\t" + rlist.get(i)[2] + "\t"+ rlist.get(i)[3]);
			System.out.printf("%d.%-10s\t\t%-10s\t\t%s\t\t%s\n",i+1 , rlist.get(i)[0], rlist.get(i)[1],rlist.get(i)[2], rlist.get(i)[3]);
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1.뒤로가기");
		System.out.println("2.처음으로가기");
		System.out.println("==============================");
		System.out.println("메뉴 입력: ");
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		switch(number) {
		
		case 1:
			
			//뒤로가기
			if(Member.mNum.equals("0")) {
				//비회원 
				rankMovieClikNon(num,rankList2,rankGenre);
			}else {
				//회원 
				rankMovieClik(num,rankList2,rankGenre);
			}
			break;
			
			
		case 2:
			//처음으로가기
			MemberStart.First();
			break;
			
			
		
		
		default :
			System.out.println("올바른 번호를 입력하세요.");
		
		
		}//switch
		

	}//rankReview

	
	
	
		
	
	
	
}//class
