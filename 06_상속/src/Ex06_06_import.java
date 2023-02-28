import com.javastudy.Car; // 다른 패키지에 있는 클래스 부르기

//java.lang 패키지 안에는 자주 사용되는 클래스들이 많음 --> import를 안해도 됨 (이 외에 다른패키지들은 써야 함) 
import java.lang.System;
import java.util.Date;

import java.lang.String;


//class Car {
//	private int speed;
//	private String direction;
//	
//	public Car(int speed, String direction) {
//		this.speed = speed;
//		this.direction = direction;
//	}
//	public void prnCar() {
//		System.out.println("speed:" + speed);
//		System.out.println("direction:" + direction);
//	}
//}// Car



public class Ex06_06_import {
	public static void main(String[] args) {

		Car car = new Car(100,"동남");
		car.prnCar();
		java.lang.System.out.println(123);
		java.lang.System.out.println("하하하");
		System.out.println(123);
		System.out.println("하하하");
		
		//java.lang.String s = "아이유";
		String s = "아이유";
		
		//java.util.Date d = new java.util.Date();
		Date d = new Date();
		System.out.println("d:" + d);
		
	}

}
