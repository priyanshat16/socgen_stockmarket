package com.stock.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/normal")
public class UserController {
	
	@RequestMapping("/user_dashboard")
	public String dashborad()
	{
		return "normal/user_dashboard";
	}

}
