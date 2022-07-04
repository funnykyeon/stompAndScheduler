package com.example.stompandscheduler;

import lombok.Getter;
import lombok.Setter;

/**
 * messaging model
 */
@Getter
@Setter
public class HelloMessage {

	private String name;

	public HelloMessage() {
	}

	public HelloMessage(String name) {
		this.name = name;
	}

}
