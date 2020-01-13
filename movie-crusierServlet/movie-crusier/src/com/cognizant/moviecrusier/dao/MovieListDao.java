package com.cognizant.moviecrusier.dao;

import java.util.List;


import com.cognizant.moviecrusier.model.MovieList;

public interface MovieListDao {
	
	public List<MovieList> getMovieListAdmin();
		
	public List<MovieList> getMovieListCustomer();
		
	public void modifyMovieList(MovieList movielist);

	public MovieList getMovieList(long MovielistId);
}


