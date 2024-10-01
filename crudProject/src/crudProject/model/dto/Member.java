package crudProject.model.dto;

public class Member {

	// 필드, 멤버변수
	private String name;
	private int age;
	private char gender;
	private String job;
	private String selectTransport;
	private double distanceToGoal;
	
	// 생성자
	public Member() {}

	public Member(String name, int age, char gender, String job, String selectTransport, double distanceToGoal) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
		this.selectTransport = selectTransport;
		this.distanceToGoal = distanceToGoal;
	}
	
	// 일반 메서드

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", job=" + job + ", selectTransport="
				+ selectTransport + ", distanceToGoal=" + distanceToGoal + "]";
	}
	
	// getter, setter

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public String getSelectTransport() {
		return selectTransport;
	}
	public void setSelectTransport(String selectTransport) {
		this.selectTransport = selectTransport;
	}

	public double getDistanceToGoal() {
		return distanceToGoal;
	}
	public void setDistanceToGoal(double distanceToGoal) {
		this.distanceToGoal = distanceToGoal;
	}
}
