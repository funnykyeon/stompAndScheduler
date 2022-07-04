package com.example.stompandscheduler;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * data model
 * 환영인사 데이터 모델
 */
@Getter
@Entity
@NoArgsConstructor
public class Greeting {

	@Id
	@GeneratedValue
	private Long id;

	private String content;

	public Greeting(String content) {
		this.content = content;
	}



}
