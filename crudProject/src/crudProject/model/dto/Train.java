package crudProject.model.dto;

public class Train extends Transport{

	// 필드, 멤버변수
	private String name = "기차";
	private String trainName;
	
	// 생성자
	public Train() {}
	public Train(int fare, double velocity, String trainName) {
		super(fare, velocity);
		this.trainName = trainName;
	}

	// 일반 메서드
	@Override
	public String toString() {
		return "기차 " + trainName +  super.toString();
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
}
