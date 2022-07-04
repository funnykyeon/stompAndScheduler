package com.example.stompandscheduler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

/**
 * 1:n publish
 */
@Controller
public class GreetingController {
 
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
    @CrossOrigin(origins = {"http://localhost:8080"})
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000);
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
}
