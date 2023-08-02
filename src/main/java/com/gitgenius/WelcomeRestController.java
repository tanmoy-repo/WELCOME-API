package com.gitgenius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private GreetClient greetClient;
	
	@GetMapping("/welcome")
	public WelcomeResponse getWelcomeMsg() {
		String welcomeMsg = "Welcome to Git Genius YT !!!";
		
		//Internal service communication
		String greetMsg = greetClient.invokeGreetApi();
		
		
		//External service communication
		RestTemplate rt = new RestTemplate();
		
		String petEndPointUrl = "https://f0qsb2wob7.execute-api.ap-south-1.amazonaws.com/dev/pets/1";
		ResponseEntity<Pet> entity = rt.getForEntity(petEndPointUrl, Pet.class);
		Pet petData = entity.getBody();
		
		WelcomeResponse finalResponse  = new WelcomeResponse();
		finalResponse.setGreetMsg(greetMsg);
		finalResponse.setWelcomeMsg(welcomeMsg);
		finalResponse.setPet(petData);
		
		return finalResponse ;
	}
	
	

}
