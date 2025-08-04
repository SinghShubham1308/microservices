package com.gocricket.live.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gocricket.live.model.Match;
import com.gocricket.live.service.MatchService;

/**
 * @author SinghShubham1308
 * 
 */
@RestController
@RequestMapping("/matches")
@CrossOrigin("*")
public class MatchController {

	private final MatchService matchService;

	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}

	@GetMapping("/live")
	public ResponseEntity<List<Match>> getLiveMatches() {
		return new ResponseEntity<>(matchService.getLiveMatches(), HttpStatus.OK);
	}

	// This method handles GET requests to "/matches/all".
	// It will return a list of all matches (live and completed).
	@GetMapping("/all")
	public ResponseEntity<List<Match>> getAllMatches() {
		return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
	}
}
