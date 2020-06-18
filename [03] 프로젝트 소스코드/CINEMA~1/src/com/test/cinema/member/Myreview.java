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

import javax.sound.sampled.Line;
import javax.xml.bind.ParseConversionEvent;

import com.test.cinema.Member;

public class Myreview {
		
	//리뷰작성 목록 화면출력
	public void printMyreview() {
		
		boolean loop = true;
		
		for (;loop;) {
			
		Scanner scan = new Scanner(System.in);
		
		System.out.println("리뷰 작성 목록에 들어왔습니다. 번호를 선택하여주세요.");
		System.out.println("==============================");
		System.out.println("번호\t영화\t\t\t내용\t\t\t\t평점\t\t작성일");
		
		myreview(); //내가 작성한 리뷰 목록
		
		System.out.println("1. 수정 하기");
		System.out.println("2. 삭제 하기");
		System.out.println("3. 뒤로 가기");
		System.out.println("4. 처음으로가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
		
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //수정하기
			reviewModify();			
			break;
		case 2:	//삭제하기
			reviewDelete();
			break;
		case 3:	//뒤로가기	
			Mypage.printmypage();
		case 4: //처음으로가기
			MemberStart.First();
		}//switch
		
		}//for
		
	}
	
	//리뷰 삭제하기 메뉴
	private void reviewDelete() {
		
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
					
		System.out.printf("리뷰 삭제에 들어왔습니다. 삭제하려는 영화제목을 입력해주세요.\n");
		System.out.println("==============================");
		myreview(); //내가 작성한 리뷰 목록
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력: ");
		
		//변경할 데이터 입력 또는 메뉴 선택 
		String input = scan.nextLine();
				
		if(input.equals("1")) {//뒤로가기
			printMyreview();			
		} else if (input.equals("2")) {//처음으로가기	
			MemberStart.First();	
		} else {//삭제하기
						
				
				//현재 고객정보 목록 불러오기
				String path = "C:\\DDGCinema_data\\리뷰더미.txt";
				File dir = new File(path);
										
				//파일 읽어 오고 list에 저장
				ArrayList<String> list = new ArrayList<String>();

				BufferedReader reader;
				try {
					reader = new BufferedReader
							(new FileReader("C:\\DDGCinema_data\\리뷰더미.txt"));
					
					String line = null;
								
					try {
						
						while((line = reader.readLine()) != null) {
														
							list.add(line+ "\n"); 
						}
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}//try-catch
							
				dir.delete(); //기존 파일 삭제 하기
								
				//파일 다시 쓰고 저장하기
				try {
					BufferedWriter writer = new BufferedWriter
							(new FileWriter("‪C:\\DDGCinema_data\\리뷰더미.txt", true));
					
					for (String text : list) {
										
						
						String[] m = new String[5];
						m = text.split("■");
						String info = "";
										
						//리뷰작성목록 데이터 = 수정원하는 제목 && 회원번호
						if(m[0].equals(input) && m[4].trim().equals(Member.getmNum()))
						{
							//삭제 원하는 영화는 쓰지 않는다.
													
						} else {
							writer.write(text);
						}
										
									
						
						
						
						
					}
										
					//평점 수정 후 출력**
					writer.close();
					printMyreview(); //리뷰작성 목록 처음으로
								
				} catch (IOException e) {
					e.printStackTrace();
				}//try-catch 
						
			
		}//if
		
		}//for	
		
	}
	
	//리뷰 수정하기 메뉴
	private void reviewModify() {
				
		boolean loop = true;
		
		for (;loop;) {
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("리뷰 작성 수정에 들어왔습니다. 수정하시려는 영화 제목을 입력해주세요.");
		System.out.println("==============================");
		
		myreview(); //내가 작성한 리뷰 목록
				
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(영화 제목 or 숫자): ");
		
		//변경할 데이터 입력 또는 메뉴 선택 		
		String reviewModifyInput = scan.nextLine();
				
		if(reviewModifyInput.equals("1")) {//뒤로가기
			printMyreview();
		} else if (reviewModifyInput.equals("2")) {//처음으로가기	
			MemberStart.First();
			
								
		} else {
						
			//@@목록에 있는 영화인지 확인
			try {
				
				editMyreview(reviewModifyInput); //[선택한 영화] 리뷰 수정
				
			} catch (Exception e) {
				System.out.println("Myreview.reviewModify()");
				e.printStackTrace();
			}
			
			
			
			}//if	
		
		}//for
	}//reviewModify()
	
	

	//[선택한 영화] 리뷰 수정
	private void editMyreview(String reviewModifyInput) {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		for (;loop;) {
			
		System.out.printf("[%s] 수정하기에 들어왔습니다. 번호를 선택하여주세요.\n", reviewModifyInput);
		System.out.println("==============================");
		System.out.println("1. 내용 수정");
		System.out.println("2. 평점 수정");
		System.out.println("3. 뒤로가기");
		System.out.println("4. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력: ");
						
		int num = scan.nextInt();
		
		switch(num) {
		case 1: //내용 수정
			reviewContentModify(reviewModifyInput);		
			break;
		case 2:	//평점 수정
			reviewGradeModify(reviewModifyInput);
			break;
		case 3:	//뒤로가기	
			reviewModify(); 
		case 4: //처음으로가기
			MemberStart.First();		
		}//switch
		
		}//for
		
		
		
	}

	
	//평점 수정하기 메뉴
	private void reviewGradeModify(String reviewModifyInput) {
				
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
					
		System.out.printf("[%s] 평점 수정하기에 들어왔습니다. 평점을 입력해주세요!.\n",reviewModifyInput);
		System.out.println("==============================");
		System.out.println("*****B. 뒤로가기*****");
		System.out.println("*****H. 처음으로가기*****");
		System.out.println("==============================");
		System.out.print("입력((B)/(H) or 평점): ");
		
		//변경할 데이터 입력 또는 메뉴 선택 
		String input = scan.nextLine();
				
		if(input.equals("B")) {//뒤로가기
			editMyreview(reviewModifyInput);							
		} else if (input.equals("H")) {//처음으로가기	
			MemberStart.First();				
		} else {
			
			//평점은 1~5까지 값만		
			if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <=5) {
								
				
				//현재 고객정보 목록 불러오기
				String path = "C:\\DDGCinema_data\\리뷰더미.txt";
				File dir = new File(path);
										
				//파일 읽어 오고 list에 저장
				ArrayList<String> list = new ArrayList<String>();

				BufferedReader reader;
				try {
					reader = new BufferedReader
							(new FileReader("C:\\DDGCinema_data\\리뷰더미.txt"));
					
					String line = null;
								
					try {
						
						while((line = reader.readLine()) != null) {
														
							list.add(line+ "\n"); 
						}
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}//try-catch
							
				dir.delete(); //기존 파일 삭제 하기
								
				//파일 다시 쓰고 저장하기
				try {
					BufferedWriter writer = new BufferedWriter
							(new FileWriter("C:\\DDGCinema_data\\리뷰더미.txt", true));
					
					for (String text : list) {
								
						//수정할려는 값
						String modify = input;
						//수정원하는 영화제목
						String movieTitle = reviewModifyInput;
						
						String[] m = new String[5];
						m = text.split("■");
						String info = "";
												
						//리뷰작성목록 데이터 = 수정원하는 제목 && 회원번호
						if(m[0].equals(movieTitle) && m[4].trim().equals(Member.getmNum()))
						{
											
						writer.write(text.replaceFirst(m[2], modify));
												
						} else {
							writer.write(text);
						}
													
					}
						
					
					//평점 수정 후 출력**
					writer.close();
					printMyreview(); //리뷰작성 목록 처음으로
								
				} catch (IOException e) {
					e.printStackTrace();
				}//try-catch //평점 수정하는 메소드
			
			}//if //평점 1~5까지만
			
			else {
				System.out.println("==============================");
				System.out.println("@@@@@숫자 1~5까지만 입력해 주세요.@@@@@");
			}
			
		}//if
		
		}//for
		
	}


	//리뷰 내용 수정하기 메뉴
	private void reviewContentModify(String reviewModifyInput) {
	
		boolean loop = true;
		
		for (;loop;) {
				
		Scanner scan = new Scanner(System.in);
					
		System.out.printf("[%s] 내용 수정하기에 들어왔습니다. 내용을 입력해주세요.\n",reviewModifyInput);
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력: ");
		
		//변경할 데이터 입력 또는 메뉴 선택 
		String input = scan.nextLine();
				
		if(input.equals("1")) {//뒤로가기
			editMyreview(reviewModifyInput);					
		} else if (input.equals("2")) {//처음으로가기	
			MemberStart.First();				
		} else {
			
			//내용 욕설 금지		
			if(!input.contains("바보") && !input.contains("멍청이")) { //바보 입력 금지
				
								
				//현재 고객정보 목록 불러오기
				String path = "C:\\DDGCinema_data\\리뷰더미.txt";
				File dir = new File(path);
										
				//파일 읽어 오고 list에 저장
				ArrayList<String> list = new ArrayList<String>();

				BufferedReader reader;
				try {
					reader = new BufferedReader
							(new FileReader("‪C:\\DDGCinema_data\\리뷰더미.txt"));
					
					String line = null;
								
					try {
						
						while((line = reader.readLine()) != null) {
														
							list.add(line+ "\n"); 
						}
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}//try-catch
							
				dir.delete(); //기존 파일 삭제 하기
								
				//파일 다시 쓰고 저장하기
				try {
					BufferedWriter writer = new BufferedWriter
							(new FileWriter("C:\\DDGCinema_data\\리뷰더미.txt", true));
					
					for (String text : list) {
								
						//수정할려는 값
						String modify = input;
						//영화제목
						String movieTitle = reviewModifyInput;
						
						String[] m = new String[5];
						m = text.split("■");
						String info = "";
										
						//리뷰작성목록 데이터 = 수정원하는 제목 && 회원번호
						if(m[0].equals(movieTitle) && m[4].trim().equals(Member.getmNum()))
						{
											
						writer.write(text.replaceFirst(m[1], modify));
												
						} else {
							writer.write(text);
						}
																	
					}
										
					//평점 수정 후 출력**
					writer.close();
					printMyreview(); //리뷰작성 목록 처음으로
								
				} catch (IOException e) {
					e.printStackTrace();
				}//try-catch //평점 수정하는 메소드
			
			}//if //평점 1~5까지만
			
			else {
				System.out.println("==============================");
				System.out.println("@@@@@욕설은 입력할 수없습니다.@@@@@@");
				
			}
			
		}//if
		
		}//for	
		
		
		
		
	}

	//내가 작성한 리뷰 목록
	private void myreview() {
		
			
		//리뷰 더미 불러오기
		String path = "C:\\DDGCinema_data\\리뷰더미.txt";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			try {			
				int i=1;	
				while((line = reader.readLine()) != null) {
								
					String[] m = new String[5];
					m = line.split("■");
					String info = "";
					//@@@@@@@@@@@@@@@@@@@@@
					//리뷰더미에 회원번호가 있어야 하는가??
					//@@@@@@@@@@@@@@@@@@@@@
					//회원번호가 일치하면 정보 출력
					if(m[m.length-1].equals(Member.getmNum())) { //예매번호
					
					info += String.format("%02d\t", i);
					info += String.format("%-6s\t", m[0]); //영화제목
					info += String.format("%-13s\t\t", m[1]); //내용
					info += String.format("%-2s\t\t", m[2]); //평점
					info += String.format("%-10s\n", m[3]);   //날짜
																
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
		
	
	
				
				
	}
	
}
