package crudProject.model.dto;

public class Transport {

	// 필드, 멤버변수
	private int fare;
	private double velocity;
	
	// 생성자
	public Transport() {}

	public Transport(int fare, double velocity) {
		this.fare = fare;
		this.velocity = velocity;
	}

	// 일반 메서드
	
	@Override
	public String toString() {
		return "Transport [fare=" + fare + ", velocity=" + velocity + "]";
	}

	
	// getter, setter
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}

	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}	
}
