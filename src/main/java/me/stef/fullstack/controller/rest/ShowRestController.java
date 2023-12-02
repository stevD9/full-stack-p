package me.stef.fullstack.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.stef.fullstack.dto.RegisterShowDTO;
import me.stef.fullstack.dto.ShowDTO;
import me.stef.fullstack.service.ShowService;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowRestController {

	@Autowired
	private ShowService service;

	@PostMapping("")
	public ShowDTO registerShow(
			@RequestBody RegisterShowDTO request) {
		return service.saveShow(request);
	}

	@GetMapping("")
	public List<ShowDTO> getShows() {
		return service.getShows();
	}

//	@PutMapping("/{id}")
//	public ShowDTO updateShow(
//			@PathVariable("id") Integer id,
//			@RequestBody UpdateShowDTO request) {
//		return service.updateShow(id, request);
//	}

	@GetMapping("/{id}")
	public ShowDTO getShow(
			@PathVariable("id") Long id) {
		return service.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteShow(
			@PathVariable("id") Long id) {
		service.deleteShow(id);
	}
}
