package com.sse.app.robot;

import org.springframework.stereotype.Component;

@Component("la")
public class LeftArm implements Arm {

	public void info() {

		System.out.println("왼쪽팔입니다");
	}

}
