package crudProject.model.dto;

public class Subway extends Transport{

	// 필드, 멤버변수
	private int subwayNumber;
	
	// 생성자
	public Subway() {}
	public Subway(int fare, double velocity, int subwayNumber) {
		super(fare, velocity);
		this.subwayNumber = subwayNumber;
	}
	
	// 일반 메서드
	@Override
	public String toString() {
		return "지하철" + subwayNumber + "호선" + super.toString() ;
	}
	
	// getter, setter
	public int getSubwayNumber() {
		return subwayNumber;
	}
	public void setSubwayNumber(int subwayNumber) {
		this.subwayNumber = subwayNumber;
	}
}
