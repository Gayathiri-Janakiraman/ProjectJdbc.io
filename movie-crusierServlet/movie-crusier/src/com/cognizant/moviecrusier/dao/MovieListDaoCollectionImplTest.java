package com.cognizant.moviecrusier.dao;

import java.util.List;


import com.cognizant.moviecrusier.model.MovieList;

import com.cognizant.moviecrusier.util.Dateutil;

	public class MovieListDaoCollectionImplTest {
		
	public static void  testGetMovieListAdmin() {
			System.out.println("Movie List for Admin");
			MovieListDao movieListDao=new MovieListDaoCollectionImpl();
			List<MovieList> movieLists = movieListDao.getMovieListAdmin();
			for(MovieList movieList : movieLists) {
				System.out.println(movieList);
			}
	}
		
	public static void testGetMovieListCustomer() {
			System.out.println("\nMovie List for People");
			MovieListDao movieListDao=new MovieListDaoCollectionImpl();
			List<MovieList> movieLists = movieListDao.getMovieListAdmin();
			for(MovieList movieList : movieLists) {
				System.out.println(movieList);
			}
			System.out.println("\nNumber of movies added to favorites:" +movieLists.size());
	}
		
	public static void testModifyMovieList() {
			MovieList movielist = new MovieList(5L, "End Game", 2750760348L, true, new Dateutil().convertToDate("02/12/2022"), "Superhero", true);
			MovieListDao movieListDao=new MovieListDaoCollectionImpl();
			movieListDao.modifyMovieList(movielist);
			System.out.println("\n***Modified Movie List***");
			testGetMovieListAdmin();
			MovieList modified_movie = movieListDao.getMovieList(movielist.getId());
			System.out.println("\nModified Movie Details\n" +modified_movie);
	}
	
	public static void main(String[] args) {
			
			testGetMovieListAdmin();
			testGetMovieListCustomer();
			testModifyMovieList();
	}

}


