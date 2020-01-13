package com.cognizant.moviecrusier.dao;

import java.util.Date;


import com.cognizant.moviecrusier.util.Dateutil;

import java.util.ArrayList;

import java.util.List;

import com.cognizant.moviecrusier.model.MovieList;

public class MovieListDaoCollectionImpl implements MovieListDao{
	private static List<MovieList> movieList;
		
	public MovieListDaoCollectionImpl() {
		super();
		if( movieList == null) {
		movieList = new ArrayList<MovieList>(); 
				 
		MovieList movie1 = new MovieList(1L, "Avatar", 2787965087L, true, new Dateutil().convertToDate("15/03/2017"), "Science Fiction", true);
	    MovieList movie2 = new MovieList(2L, "The Avengers", 1518812988L, true, new Dateutil().convertToDate("23/12/2017"), "Superhero", false);
		MovieList movie3 = new MovieList(3L, "Titanic", 2187463944L, true, new Dateutil().convertToDate("21/08/2017"), "Romance", false);
		MovieList movie4 = new MovieList(4L, "Jurassic World", 1671713208L, false, new Dateutil().convertToDate("02/07/2017"), "Science Fiction", true);
	    MovieList movie5 = new MovieList(5L, "Avengers: End Game", 2750760348L, true, new Dateutil().convertToDate("02/12/2022"), "Superhero", true);
	    movieList.add(movie1);
		movieList.add(movie2);
	    movieList.add(movie3);
		movieList.add(movie4);
		movieList.add(movie5);
		}
			
	}

	@Override
	public List<MovieList> getMovieListAdmin() {
		return movieList;
		}

	@Override
	public List<MovieList> getMovieListCustomer() {
		
		//Initialize an arrayList for type medium
		ArrayList<MovieList> filteredMovieList=new ArrayList<MovieList>();
		//iterate through MovieListlist
		for(MovieList MovieList : movieList) {
			if(MovieList.getDateofLaunch().before(new Date())) {
				if(MovieList.getActive()) {
					filteredMovieList.add(MovieList);
			}
		}		
	}
	return filteredMovieList;
 }

	 @Override
	 public void modifyMovieList(MovieList movielist) {
			for(int i = 0; i < movieList.size(); i++) {
				if(movieList.get(i).getId() ==  movielist.getId()) {
					movieList.set(i,  movielist);
				}
				
			}
			
		}

	@Override
	public MovieList getMovieList(long MovielistId) {
		for (MovieList movieList : movieList) {
			if(movieList.getId() ==  MovielistId) {
				return movieList;
				}
			}
			return null;
		}
		
	}

