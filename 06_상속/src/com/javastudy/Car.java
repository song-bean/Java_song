package com.javastudy;

import java.util.*; // 모든 패키지를 임포트 하겠다
import java.util.Date;

public class Car {
	private int speed;
	private String direction;
	
	public Car(int speed, String direction) {
		this.speed = speed;
		this.direction = direction;
	}
	public void prnCar() {
		System.out.println("speed:" + speed);
		System.out.println("direction:" + direction);
		System.out.println("-----------------------------");
		Date d = new Date();
		System.out.println(d);
		System.out.println("-----------------------------");
	
	}
}// Car

//pdf 7.생성자,상속,다형성 - 55pg 참고
//접근 제어자: public (어디서나 다 사용 가능)
//			protected (같은 패키지에서는 누구나 가능, 다른 패키지에서는 자식만 가능)
//			default (default는 아무것도 안쓰는게 default임, 같은 패키지면 누구나 가능, 다른 패키지면 자식도 못씀)
//			private (오직 만든(선언한) 클래스에서만 가능)
//그 외: static, 
//		final(클래스(이 클래스가 끝이다 --> 상속 받는 클래스가 있을 수 없다), 메서드(오버라이딩 못함), 변수(값을 변경 못함))
