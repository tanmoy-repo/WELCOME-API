package com.gitgenius;

import lombok.Data;

@Data
public class WelcomeResponse {
	
	private String greetMsg;
	private String welcomeMsg;
	private Pet pet;

}
