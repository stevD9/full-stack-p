package me.stef.fullstack.controller.rest;

import me.stef.fullstack.dto.UpdateShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping("/shows/{id}")
	public ShowDTO updateShow(
			@PathVariable("id") Integer id,
			@RequestBody UpdateShowDTO request) {
		return service.updateShow(id, request);
	}

	// TO REMOVE
	@GetMapping("/shows/{id}")
	public ShowDTO getShow(
			@PathVariable("id") Integer id) {
		return service.getById(id);
	}

	@DeleteMapping("shows/{id}")
	public void deleteShow(
			@PathVariable("id") Integer id) {
		service.deleteShow(id);
	}
}
