package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Area;
import app.repo.AreaRepository;

@RestController
@RequestMapping("/areas")
public class AreaController {

	@Autowired
	AreaRepository areaRepository;

	@GetMapping
	Iterable<Area> getAll() {
		return areaRepository.findAll();
	}
}
