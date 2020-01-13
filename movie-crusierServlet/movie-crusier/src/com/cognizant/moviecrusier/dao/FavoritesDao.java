package com.cognizant.moviecrusier.dao;

import com.cognizant.moviecrusier.model.Favorites;

public interface FavoritesDao {
	public void addFavoritemovies(long userId, long movieListId);
		
	public Favorites getAllFavoritemovies(long userId) throws FavoritesEmptyException;
		
	public void removeFavoritemovies(long userId, long movieListId);
}

