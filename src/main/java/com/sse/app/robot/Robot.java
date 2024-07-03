package com.sse.app.robot;

//@Component
public class Robot {

	private int age;
	private String company;

//	@Autowired
//	@Qualifier("ra")
	private Arm rightArm;

//	@Autowired
//	@Qualifier("la")
	private Arm leftArm;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}

}
