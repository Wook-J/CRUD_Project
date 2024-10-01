package crudProject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import crudProject.model.dto.Bicycle;
import crudProject.model.dto.Bus;
import crudProject.model.dto.Member;
import crudProject.model.dto.Subway;
import crudProject.model.dto.Train;
import crudProject.model.dto.Transport;

public class TransportService {

	// 필드, 멤버번수
	private Scanner sc = new Scanner(System.in);
	private Map<Integer, Transport> transportMap = new HashMap<Integer, Transport>();
	private Map<Integer, String> jobMap = new HashMap<Integer, String>();
	private List<Member> memberList = new ArrayList<Member>();
	
	// 생성자
	public TransportService() {
		// 1-지하철, 2-버스, 3-기차, 4-자전거
		transportMap.put(1, new Subway(1500, 70.0, "1호선"));
		transportMap.put(2, new Bus(1400, 60.0, 5513));
		transportMap.put(3, new Train(3000, 85.0, "무궁화"));
		transportMap.put(4, new Bicycle(1000, 20));
		
		// 1-회사원, 2-프리랜서, 3-무직
		jobMap.put(1, "회사원");
		jobMap.put(2, "프리랜서");
		jobMap.put(3, "무직");
		
		memberList.add(new Member("홍길순", 23, '여', selectJob(1), selectTransport(1), 30));
		memberList.add(new Member("이순신", 28, '남', selectJob(2), selectTransport(2), 40));
		memberList.add(new Member("장보고", 35, '남', selectJob(2),  selectTransport(1), 33));
		memberList.add(new Member("세종대왕", 43, '남', selectJob(3), selectTransport(3), 50));
		memberList.add(new Member("율곡이이", 25, '남', selectJob(3), selectTransport(4), 20));
		memberList.add(new Member("신사임당", 33, '여', selectJob(1), selectTransport(3), 42));
		memberList.add(new Member("퇴계이황", 27, '남', selectJob(1), selectTransport(2), 35));
		memberList.add(new Member("이승만", 23, '남', selectJob(2),  selectTransport(1), 22));
		memberList.add(new Member("김구", 33, '남', selectJob(3), selectTransport(2), 45));
		memberList.add(new Member("김좌진", 27, '남', selectJob(4), selectTransport(3), 60));
		memberList.add(new Member("나이팅게일", 30, '여', selectJob(2),  selectTransport(1), 10));
		memberList.add(new Member("선덕여왕", 48, '여', selectJob(4), selectTransport(4), 10));
		memberList.add(new Member("유관순", 20, '여', selectJob(1), selectTransport(2), 25));
	}
	
	public String selectJob(int num) {
		String str = null;
		switch(num) {
		case 1 : str= "회사원"; break;		// selectJob(1)
		case 2 : str= "프리랜서"; break;	// selectJob(2)
		case 3 : str= "자영업자"; break;	// selectJob(3)
		case 4 : str= "기타"; break;		// selectJob(4)
		}
		return str;
	}
	
	public String selectTransport(int num) {
		String str = null;
		switch(num) {
		case 1 : str= "지하철"; break;		// selectTransport(1)
		case 2 : str= "버스"; break;		// selectTransport(2)
		case 3 : str= "기차"; break;		// selectTransport(3)
		case 4 : str= "자전거"; break;		// selectTransport(4)
		}
		return str;
	}
	
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
			
			System.out.print("메뉴를 선택하세요 : ");
			
			try {
				
				menuNum = sc.nextInt();
				switch(menuNum) {
				case 1 : readAllMember(); break;		// 1. 전체 회원 조회 메서드
				case 2 : addMember(); break;			// 2. 새로원 회원 추가 메서드
				case 3 : readByTransport(); break;		// 3. 교통수단별 회원수 및 수입 조회 메서드
				case 4 : break;			// 4. 특정 직업의 교통수단 방법 조회 메서드
				case 5 : break;			// 5. 특정 직업의 출퇴근 시간 조회 메서드
				case 6 : break;			// 6. 회원의 직업, 교통수단 선택 방법 수정 메서드
				case 7 : break;			// 7. 교통수단의 요금, 속력 수정(버스, 기차) 메서드
				case 8 : break;			// 8. 회원 삭제 메서드
				case 0 : System.out.println("프로그램을 종료합니다.");break;
				default : System.out.println("메뉴에 있는 숫자를 입력하세요");
				}
				
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("올바른 타입을 입력하세요");
				menuNum = -1;
			}
			
			System.out.println();
			
		}while(menuNum != 0);
		
	}
	
	public void readAllMember() {
		System.out.println(" ---- 전체 회원 조회 ----");
		for(Member member :memberList)
			System.out.println(member);
	}
	
	public void addMember() {
		System.out.println(" ---- 새로운 회원 추가 ----");
		
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		
		System.out.println("현재 선택 가능한 직업");
		for(Entry<Integer, String> entry :jobMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.print("직업 : ");
		int jobNum = sc.nextInt();
		
		
		System.out.println("현재 선택 가능한 교통수단");
		for(Entry<Integer, Transport> entry :transportMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.print("교통수단 : ");
		int transportNum = sc.nextInt();
		
		System.out.print("목표거리 : ");
		double distanceToGoal = sc.nextDouble();
		
		memberList.add(new Member(name, age, gender, selectJob(jobNum), selectTransport(transportNum), distanceToGoal));
		System.out.println("새로운 회원 '" + name + "'이 추가되었습니다!!");
		
	}

	public void readByTransport() {
		System.out.println("---- 교통수단별 회원수 및 수입 조회 ----");
		/* 논리구조
		 * K에 교통 수단대입
		 * V에는 회원명을 List 로 집어넣기
		 * 출력시 List.size(), fare*List.size()를 출력
		 * */
		
		Map<String, List<String>> transByName = new HashMap<String, List<String>>();
		
		for(int transNum :transportMap.keySet()) {
			List<String> transEqual = new ArrayList<String>();
			for(Member member : memberList) {
				if(member.getSelectTransport().equals(transportMap.get(transNum).getName())) {
					transEqual.add(member.getName());
				}
			}
			transEqual.add(0, Integer.toString(transportMap.get(transNum).getFare()));
			transByName.put(transportMap.get(transNum).getName(), transEqual);
		}
		
		System.out.println(transByName);
		for(Entry<String, List<String>> entry :transByName.entrySet()) {
			System.out.println(entry.getKey() + " : 총 " + (entry.getValue().size()-1)+"명");
			System.out.println("총 수입 : " + (entry.getValue().size()-1) + "원");
		}	// 이 부분부터 작성해야함!
		
	}
	
	// getter, setter
}
