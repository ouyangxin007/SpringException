package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("exceptionsTest")
@Controller
public class ExceptionsTestController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String exception(Exception ex){
		return this.getClass().getSimpleName()+":"+ ex;
	}

	@ResponseBody
	@RequestMapping(value="/test1", method= {org.springframework.web.bind.annotation.RequestMethod.GET})
	public String test1(@RequestParam(value="id") String id) {
		return "";
	}

	@ResponseBody
	@RequestMapping(value="/test2", method= {org.springframework.web.bind.annotation.RequestMethod.GET})
	public String test2() {
		int u = 2/0;
		return "";
	}


}
