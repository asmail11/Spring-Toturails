package org.imdrmas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.imdrmas.model.User;
import org.imdrmas.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private static final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/createuser")
	public ModelAndView createUserView() {
		ModelAndView modelAndView = new ModelAndView("createuser");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("allProfiles", getProfile());
		return modelAndView;
	}
	@PostMapping("/createuser")
	public ModelAndView createUser(@Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting from.");
			modelAndView.setViewName("createuser");
			modelAndView.addObject("user", user);
			modelAndView.addObject("allProfiles", getProfile());
			return modelAndView;
		}
		userService.addUser(user);
		modelAndView.addObject("allUsers", userService.getAllUsers());
		modelAndView.setViewName("userinfo");
		logger.info("From submitted successfully");
		
		return modelAndView;
		
	}

	private List<String> getProfile() {
	  List<String> list = new ArrayList<String>();
	  list.add("Associate");
	  list.add("AVP");
	  list.add("Vp");
	  list.add("Director");
	  return list;
	}
	
	

}
