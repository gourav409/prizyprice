package com.ecomm.gourav_e_comm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.gourav_e_comm.interfaces.IEcommRepo;

@Controller
public class EcommController {
	
	@Autowired
	IEcommRepo ecomRepo;
	
	@RequestMapping(value = "/getCartItems", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCartItems(@RequestParam int custId) {
		ModelAndView mv = new ModelAndView("showItem.html");
		String item = ecomRepo.selectCartItems(custId);
		mv.addObject("item", item);
		return item;
	}

}
