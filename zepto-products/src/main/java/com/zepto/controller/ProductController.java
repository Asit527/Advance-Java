package com.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.request.ProductRequest;
import com.zepto.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("saveProduct") // end point -product/saveProduct
	@ResponseBody // directly it will send to page
	public String uploadProduct(@ModelAttribute ProductRequest productRequest) {
		int productId = productService.createProduct(productRequest);
		return "product has been uploaded and product id:" + productId;
	}

	@GetMapping("showSearchPage")
	public String showSearchPage() {
		return "search-product";

	}
	
	@GetMapping("search")
	@ResponseBody
	public String getCategories(@RequestParam("productStr") String searchTerm) {
		 productService.getCategories();
	
		
		
		return "test";
	}

}
