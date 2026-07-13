package com.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderDetailsControler {
	
	@GetMapping("orderDetails/{orderId}/{value}")
	@ResponseBody
	public String getOrderDetails(@PathVariable("orderId") String orderId , @PathVariable("value") String value) {
		System.out.println(orderId+" "+value);
		return "your oder id is "+orderId;
	}

}
