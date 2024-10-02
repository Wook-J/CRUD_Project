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
		// 1-지하철 객체, 2-버스 객체, 3-기차 객체, 4-자전거 객체
		transportMap.put(1, new Subway(1500, 70.0, "1호선"));
		transportMap.put(2, new Bus(1400, 60.0, 5513));
		transportMap.put(3, new Train(3000, 85.0, "무궁화"));
		transportMap.put(4, new Bicycle(1000, 20));
		
		// 1-회사원, 2-프리랜서, 3-자영업자, 4-기타
		jobMap.put(1, "회사원");
		jobMap.put(2, "프리랜서");
		jobMap.put(3, "자영업자");
		jobMap.put(4, "기타");
		
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
	
	/** 직업을 선택하는 메서드
	 * 직업 추가하는 경우 switch 구문의 case 추가 필요
	 * @param jobMap의 Key
	 * @return jonMap의 Value
	 */
	public String selectJob(int num) {
		String str = null;
		switch(num) {
		case 1 : str= "회사원"; break;	// selectJob(1)
		case 2 : str= "프리랜서"; break;	// selectJob(2)
		case 3 : str= "자영업자"; break;	// selectJob(3)
		case 4 : str= "기타"; break;		// selectJob(4)
		}
		return str;
	}
	
	/** 교통수단을 선택하는 메서드
	 * @param transportMap의 Key
	 * @return transportMap의 Value(Transport 객체 + 상속)의 getName
	 */
	public String selectTransport(int num) {
		return transportMap.get(num).getName();
	}
	
	// 일반 메서드
	/**
	 * 0. 화면표시용 메서드
	 */
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println("========== 회원의 교통수단 ==========");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 새로운 회원 추가");
			System.out.println("3. 교통수단별 회원수 및 수입 조회");
			System.out.println("4. 특정 직업의 교통수단 방법 조회");
			System.out.println("5. 특정 직업의 이동 시간 조회");
			System.out.println("6. 회원의 직업, 교통수단 수정");
			System.out.println("7. 전체 교통수단 조회");
			System.out.println("8. 교통수단의 요금, 속력 수정");
			System.out.println("9. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴를 선택하세요 : ");
			
			try {
				
				menuNum = sc.nextInt();
				switch(menuNum) {
				case 1 : readAllMember(); break;		// 1. 전체 회원 조회 메서드
				case 2 : addMember(); break;			// 2. 새로원 회원 추가 메서드
				case 3 : readByTransport(); break;		// 3. 교통수단별 회원수 및 수입 조회 메서드
				case 4 : transportByJob(); break;		// 4. 특정 직업의 교통수단 방법 조회 메서드
				case 5 : timeByJob(); break;			// 5. 특정 직업의 이동 시간 조회 메서드
				case 6 : updateJobOrTransport(); break;	// 6. 회원의 직업, 교통수단 수정 메서드
				case 7 : readAllTransport(); break;		// 7. 전체 교통수단 조회 메서드
				case 8 : updateFareOrVelocity(); break;	// 8. 교통수단의 요금, 속력 수정(버스, 기차) 메서드
				case 9 : deleteMember(); break;			// 9. 회원 삭제 메서드
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
	
	/**
	 * 1. 전체 회원 조회 메서드
	 */
	public void readAllMember() {
		System.out.println(" ---- 전체 회원 조회 ----");
		int i = 1;
		for(Member member :memberList) {
			System.out.println(i + ". "+member);
			i++;
		}
	}
	
	/**
	 * 2. 새로원 회원 추가 메서드
	 */
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
		if(!jobMap.containsKey(jobNum)) {
			System.out.println("번호에 해당되는 직업이 없습니다");
			return;
		}
		
		
		System.out.println("현재 선택 가능한 교통수단");
		for(Entry<Integer, Transport> entry :transportMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.print("교통수단 : ");
		int transportNum = sc.nextInt();
		if(!transportMap.containsKey(transportNum)) {
			System.out.println("번호에 해당되는 교통수단이 없습니다");
			return;
		}
		
		
		System.out.print("목표거리 : ");
		double distanceToGoal = sc.nextDouble();
		
		memberList.add(new Member(name, age, gender, selectJob(jobNum), selectTransport(transportNum), distanceToGoal));
		System.out.println("새로운 회원 '" + name + "'이 추가되었습니다!!");
		
	}

	/**
	 * 3. 교통수단별 회원수 및 수입 조회 메서드
	 */
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
			
			transEqual.add(Integer.toString(transportMap.get(transNum).getFare()));
			for(Member member : memberList) {
				if(member.getSelectTransport().equals(transportMap.get(transNum).getName())) {
					transEqual.add(member.getName());
				}
			}
			
			transByName.put(transportMap.get(transNum).getName(), transEqual);
		}
		
//		System.out.println(transByName);		// 출력 확인용
		for(Entry<String, List<String>> entry :transByName.entrySet()) {
			int entryNumber = entry.getValue().size()-1;
			int entryFare = Integer.parseInt(entry.getValue().get(0));
			System.out.println(entry.getKey() + " : 총 " + entryNumber+"명");
			System.out.println("총 수입 : " + (entryNumber * entryFare) + "원");
		}
	}
	
	/**
	 * 4. 특정 직업의 교통수단 방법 조회 메서드
	 */
	public void transportByJob() {
		System.out.println("---- 특정 직업의 교통수단 방법 조회 ----");
		for(Entry<Integer, String> entry:jobMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.print("보려는 직업의 번호를 선택하세요 : ");
		int jobNumber = sc.nextInt();
		
		if(jobMap.containsKey(jobNumber)) {
			System.out.println(jobMap.get(jobNumber) + "인 사람 및 교통수단 입니다.");
			for(Member member : memberList) {
				if(member.getJob().equals(jobMap.get(jobNumber))) {
					System.out.println("'"+member.getName()+"'의 교통수단 : " + member.getSelectTransport());
				}
			}
		} else System.out.println("특정 직업에 해당하는 번호가 없습니다.");
	}
	
	/**
	 * 5. 특정 직업의 이동 시간 조회 메서드
	 */
	public void timeByJob() {
		System.out.println("---- 특정 직업의 이동시간 조회 ----");
		for(Entry<Integer, String> entry:jobMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.print("보려는 직업의 번호를 선택하세요 : ");
		int jobNumber = sc.nextInt();
		
		if(jobMap.containsKey(jobNumber)) {
			System.out.println(jobMap.get(jobNumber) + "인 사람 및 이동시간 입니다.");
			for(Member member : memberList) {
				if(member.getJob().equals(jobMap.get(jobNumber))) {
					System.out.printf("%s : %.2f시간 이동(%s를 이용하여 %.2fkm만큼 이동)\n",
							member.getName(), 
							member.getDistanceToGoal()/transportMap.get(jobNumber).getVelocity(),
							member.getSelectTransport(), 
							member.getDistanceToGoal());
				}
			}
		}else System.out.println("특정 직업에 해당하는 번호가 없습니다.");
	}
	
	/**
	 * 6. 회원의 직업, 교통수단 수정 메서드
	 */
	public void updateJobOrTransport() {
		System.out.println("---- 회원의 직업, 교통수단 수정 ----");
		System.out.println("현재회원 명단입니다.");
		for(Member member : memberList) {
			if(memberList.indexOf(member)==0) System.out.print(member.getName());
			else System.out.print(", " + member.getName());
		}
		
		System.out.println();
		sc.nextLine();
		System.out.print("회원 선택 : ");
		String memberName = sc.nextLine();
		
		for(Member member : memberList) {
			if(member.getName().equals(memberName)) {
				System.out.println(memberName +"의 기존 직업 : " + member.getJob());
				System.out.println("< 저장되어 있는 직업 >");
				for(Entry<Integer, String> entry:jobMap.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue());
				}
				System.out.print("변경할 직업의 번호를 선택하세요 : ");
				int jobNumber = sc.nextInt();
				
				System.out.println(memberName +"의 기존 교통수단 : " + member.getSelectTransport());
				System.out.println("< 저장되어 있는 교통수단 >");
				for(Entry<Integer, Transport> entry:transportMap.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue().getName());
				}
				System.out.print("변경할 교통수단의 번호를 선택하세요 : ");
				int transportNumber = sc.nextInt();
				
				if(!jobMap.containsKey(jobNumber) || !transportMap.containsKey(transportNumber)) {
					System.out.println("일치하는 직업 또는 교통수단이 없습니다.");
					return;
				}
				
				member.setJob(selectJob(jobNumber));
				member.setSelectTransport(selectTransport(transportNumber));
				
				System.out.printf("%s의 <직업, 교통수단>이 <%s, %s>로 변경되었습니다!",
						member.getName(),
						selectJob(jobNumber),
						selectTransport(transportNumber));
				return;
			}
		}
		System.out.println("일치하는 회원이 없습니다.");
		
	}
	
	/**
	 * 7. 전체 교통수단 조회 메서드
	 */
	public void readAllTransport() {
		System.out.println("---- 전체 교통수단 조회 ----");
		for(Entry<Integer, Transport> entry : transportMap.entrySet()) {			
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	/**
	 * 8. 교통수단의 요금, 속력 수정(버스, 기차) 메서드
	 * 교통수단 class 를 추가하는 경우 print 구문 변경필요!
	 */
	public void updateFareOrVelocity() {
		System.out.println("---- 교통수단의 요금, 속력 수정 ----");
		sc.nextLine();
		System.out.print("지하철 또는 버스, 기차 입력 : ");
		String transport = sc.nextLine();
		
		for(Entry<Integer, Transport> entry : transportMap.entrySet()) {
			if(entry.getValue().getName().equals(transport)) {
				System.out.println(entry.getValue().getName() + "의 기존 요금 : " + entry.getValue().getFare());
				System.out.print("변경할 요금을 입력하세요 : ");
				int updateFare = sc.nextInt();
				
				System.out.println(entry.getValue().getName() + "의 기존 속력 : " + entry.getValue().getVelocity());
				System.out.print("변경할 속력을 입력하세요 : ");
				double updateVelocity = sc.nextDouble();
				
				entry.getValue().setFare(updateFare);
				entry.getValue().setVelocity(updateVelocity);

				System.out.printf("%s의 <요금, 속력>이 <%d원, %.2fkm/h>로 변경되었습니다!",
						entry.getValue().getName(),
						updateFare, updateVelocity);
				return;
			}
		}
		
		System.out.println("올바른 문자를 입력하세요!");
		
	}
	
	/**
	 * 9. 회원 삭제 메서드
	 */
	public void deleteMember() {
		System.out.println("---- 회원 삭제 ----");
		
		System.out.println("현재회원 명단입니다.");
		for(Member member : memberList) {
			if(memberList.indexOf(member)==0) System.out.print(member.getName());
			else System.out.print(", " + member.getName());
		}
		System.out.println();
		sc.nextLine();
		System.out.print("삭제할 회원을 입력하세요 : ");
		String deleteMember = sc.nextLine();
		
		for(Member member : memberList) {
			if(member.getName().equals(deleteMember)) {
				memberList.remove(member);
				System.out.println("회원 '" + deleteMember + "' 이/가 삭제되었습니다!");
				return;
			}
		}
		System.out.println("일치하는 회원이 없습니다!");
	}

	// getter, setter
}
