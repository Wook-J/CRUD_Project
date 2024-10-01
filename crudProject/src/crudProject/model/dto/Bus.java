package crudProject.model.dto;

public class Bus extends Transport{

	// 필드, 멤버변수
	private int subwayNumber;
	
	// 생성자
	public Bus() {}
	public Bus(int fare, double velocity, int subwayNumber) {
		super(fare, velocity);
		this.subwayNumber = subwayNumber;
	}
	
	// 일반 메서드
	@Override
	public String toString() {
		return "버스" + subwayNumber + "번" +  super.toString();
	}
	
	// getter, setter
	public int getSubwayNumber() {
		return subwayNumber;
	}
	public void setSubwayNumber(int subwayNumber) {
		this.subwayNumber = subwayNumber;
	}
}
