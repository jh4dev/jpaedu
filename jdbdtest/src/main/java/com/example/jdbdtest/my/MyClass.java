package com.example.jdbdtest.my;

import org.springframework.stereotype.Component;

/* Spring 관리 객체 -> Bean
 * 서버 구동 시점에 객체 생성되어 사용 (Singleton)
 * 
*/
@Component
public class MyClass {

	public String hello() {
		return "Hello class";
	}
}
