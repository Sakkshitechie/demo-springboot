package com.example.demo.controller;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Demo;
import com.example.demo.services.DemoServices;

@Controller
@RequestMapping("/api")
public class DemoController {
	@Autowired
	private DemoServices demoServices;
	
	//build create products REST API
	@PostMapping()
	ResponseEntity<Demo> saveDemo(@RequestBody Demo demo){
		System.out.println("Add Products ********************************");
		return new ResponseEntity<Demo>(demoServices.save(demo), HttpStatus.CREATED);
	}
	
	//build get All products REST API
	@GetMapping()
	public String getAllDemo(int id){
		System.out.println("Add Products ********************************");
		 demoServices.getAllDemo(id);
		 return "redirect:/index";
	}
	//build get product by id REST API
	//http://localhost:8080/api/demo/1
	@GetMapping("{id}")
	public ResponseEntity<Demo> getDemoById(@PathVariable("id") int id){
		System.out.println("Add Products ********************************");
		return new ResponseEntity<Demo>(demoServices.getDemoById(id), HttpStatus.OK);
	}
//	
//	@GetMapping()
//	public String index(Demo demo) {
//		System.out.println("Add Products ********************************");
//		return demoServices.findPaginated(1, "id", "asc", demo);
//    }
	
	@GetMapping("/index")
	public String Project(Demo demo,int id) {
		System.out.println("Add Products ********************************");
		List<Demo> listProduct = demoServices.getAllDemo(id);
		demo.addAttribute(listProduct);
		demo.addAttribute(id);
		return "index";
	}
	
	@GetMapping("./AddProduct")
	public String addProduct() {
		System.out.println("Add Products ********************************");
		Logger.getLogger("Add Products ********************************");
		return "AddProduct";
	}
	@GetMapping("/AvailableProduct")
	public String AvailableProduct() {
		System.out.println("Add Products ********************************");
		return "AvailableProduct";
	}
	@GetMapping("/register")
	public String register() {
		System.out.println("Add Products ********************************");
		return "register";
	}
	@GetMapping("/login")
	public String login() {
		System.out.println("Add Products ********************************");
		return "login";
	}
}
