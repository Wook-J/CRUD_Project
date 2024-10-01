package crudProject.model.dto;

public class Subway extends Transport{

	// 필드, 멤버변수
	private String name = "지하철";
	private String subwayNumber;
	
	// 생성자
	public Subway() {}
	public Subway(int fare, double velocity, String subwayNumber) {
		super(fare, velocity);
		this.subwayNumber = subwayNumber;
	}
	
	// 일반 메서드
	@Override
	public String toString() {
		return "지하철 " + subwayNumber + super.toString() ;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSubwayNumber() {
		return subwayNumber;
	}
	public void setSubwayNumber(String subwayNumber) {
		this.subwayNumber = subwayNumber;
	}
}
