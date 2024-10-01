package crudProject.model.dto;

public class Bicycle extends Transport{

	// 필드, 멤버변수
	private String name = "자전거";
	
	// 생성자
	public Bicycle() {
		
	}
	public Bicycle(int fare, double velocity) {
		super(fare, velocity);
	}
	
	// 일반 메서드
	@Override
	public String toString() {
		return "자전거 " + super.toString() ;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
