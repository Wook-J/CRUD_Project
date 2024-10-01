package crudProject.service;

import java.util.Scanner;

public class TransportService {

	// 필드, 멤버번수
	private Scanner sc = new Scanner(System.in);
	
	// 생성자
	public TransportService() {}
	
	// 일반 메서드
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println("========== 회원의 교통수단 ==========");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 새로운 회원 추가");
			System.out.println("3. 교통수단별 회원수 및 수입 조회");
			System.out.println("4. 특정 직업의 교통수단 방법 조회");
			System.out.println("5. 특정 직업의 출퇴근 시간 조회");
			System.out.println("6. 회원의 직업, 교통수단 선택 방법 수정");
			System.out.println("7. 교통수단의 요금, 속력 수정(버스, 기차)");
			System.out.println("8. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴를 선택하세요 :");
			
			try {
				
				menuNum = sc.nextInt();
				switch(menuNum) {
				case 1 : break;			// 1. 전체 회원 조회 메서드
				case 2 : break;			// 2. 새로원 회원 추가 메서드
				case 3 : break;			// 3. 교통수단별 회원수 및 수입 조회 메서드
				case 4 : break;			// 4. 특정 직업의 교통수단 방법 조회 메서드
				case 5 : break;			// 5. 특정 직업의 출퇴근 시간 조회 메서드
				case 6 : break;			// 6. 회원의 직업, 교통수단 선택 방법 수정 메서드
				case 7 : break;			// 7. 교통수단의 요금, 속력 수정(버스, 기차) 메서드
				case 8 : break;			// 8. 회원 삭제 메서드
				case 9 : System.out.println("프로그램을 종료합니다.");break;
				default : System.out.println("메뉴에 있는 숫자를 입력하세요");
				}
				
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("올바른 문자를 입력하세요");
				menuNum = -1;
				e.printStackTrace();
			}
			
			System.out.println();
			
		}while(menuNum != 0);
		
	}
	
	// getter, setter
}
