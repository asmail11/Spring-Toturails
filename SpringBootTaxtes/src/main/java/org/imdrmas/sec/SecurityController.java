package org.imdrmas.sec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/login")
    public String login() {
    	return "login";
    }
	@RequestMapping("/")
	public String home() {
		return "redirect:/entreprises";
	}
	@RequestMapping("/404")
	public String accessDenied() {
		return "404";
	}
}
