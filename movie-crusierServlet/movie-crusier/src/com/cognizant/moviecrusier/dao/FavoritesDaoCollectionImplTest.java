package com.cognizant.moviecrusier.dao;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.MovieList;

public class FavoritesDaoCollectionImplTest {
	
	public static void testAddFavoritemovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoritemovies(1, 2L);
		favoritesDao.addFavoritemovies(1, 5L);
		favoritesDao.addFavoritemovies(2, 1L);
		favoritesDao.addFavoritemovies(2, 3L);
		System.out.println("User Added Movie List for Checkout");
		Favorites favorites = favoritesDao.getAllFavoritemovies(1);
		for(MovieList movieList : favorites.getMovieList()) {
			System.out.println(movieList);
		 	}
		}
	public static void testRemoveFavoritemovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("\nMovie List for Customer after Remove");
		try {
		favoritesDao.removeFavoritemovies(1, 2l);
		favoritesDao.removeFavoritemovies(1, 5L);
		favoritesDao.removeFavoritemovies(1, 3l);
		Favorites favorites = favoritesDao.getAllFavoritemovies(1);
		for(MovieList movieList : favorites.getMovieList()) {
		System.out.println(movieList);
		}
		System.out.println("No.of.Favorites:" +favorites.getMovieList().size());
	   		}catch(FavoritesEmptyException e) {
		System.out.println(e.getMessage());
		}
	}
	
	public static void testGetAllMovieLists() {

		}
		
	public static void main(String[]args) throws FavoritesEmptyException {
			  testAddFavoritemovies();
			  testRemoveFavoritemovies();
	}
	
}

		
	

