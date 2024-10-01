package crudProject.model.dto;

public class Bus extends Transport{

	// 필드, 멤버변수
	private String name = "버스";
	private int busNumber;
	
	// 생성자
	public Bus() {}
	public Bus(int fare, double velocity, int busNumber) {
		super(fare, velocity);
		this.busNumber = busNumber;
	}
	
	// 일반 메서드
	@Override
	public String toString() {
		return "버스 " + busNumber + "번" +  super.toString();
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSubwayNumber() {
		return busNumber;
	}
	public void setSubwayNumber(int busNumber) {
		this.busNumber = busNumber;
	}
}
