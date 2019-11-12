package com.parsexml.cd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CdController {

	@Autowired
	private CdServices cdServices;
	
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
	
	@GetMapping("/cd/get")
	public List<CdDto> getCdList() {
		
		return cdServices.getCdList();
	}
	

}
