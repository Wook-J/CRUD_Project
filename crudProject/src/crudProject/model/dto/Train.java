package crudProject.model.dto;

public class Train extends Transport{

	// 필드, 멤버변수
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
		return trainName + "기차" +  super.toString();
	}
	
	// getter, setter
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
}
