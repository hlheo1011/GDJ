package com.gdu.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.service.MovieService;

@Controller
public class MovieController {

	
	@Autowired
	private MovieService movieService;
	
	/*
	@Autowired
	private SecurityUtil securityUtil;
	*/
	
	@GetMapping("/")
	public String index() {
		return "index";
	}


	@ResponseBody
	@GetMapping(value="/searchAllMovies", produces="application/json; charset=UTF-8")
	public List<MovieDTO> movieList() {
		return movieService.getMovieList();
	}

	
	/*
	@ResponseBody
	@GetMapping(value="/searchMovie", produces="application/json; charset=UTF-8")
	*/

}
