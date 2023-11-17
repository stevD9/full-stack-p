package me.stef.fullstack.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.stef.fullstack.dto.RegisterShowDTO;
import me.stef.fullstack.dto.ShowDTO;
import me.stef.fullstack.service.ShowService;

@RestController
public class ShowRestController {

	@Autowired
	private ShowService service;

	@PostMapping("/shows")
	public ShowDTO registerShow(
			@RequestBody RegisterShowDTO request) {
		return service.saveShow(request);
	}
}
