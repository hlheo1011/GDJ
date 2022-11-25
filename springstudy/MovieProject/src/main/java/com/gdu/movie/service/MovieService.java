package com.gdu.movie.service;

import java.util.List;

import com.gdu.movie.domain.MovieDTO;

public interface MovieService {
	
	public List<MovieDTO> getMovieList();
	public MovieDTO getMovieByNo(int no);
}
