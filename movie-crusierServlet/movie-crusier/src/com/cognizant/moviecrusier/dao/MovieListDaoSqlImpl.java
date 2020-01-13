package com.cognizant.moviecrusier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecrusier.model.MovieList;
import com.cognizant.moviecrusier.util.Dateutil;

public class MovieListDaoSqlImpl implements MovieListDao {

	public static final String MOVIE_LIST_DETAILS = "SELECT * FROM movie_list";

	public static final String MOVIE_LIST = "SELECT * FROM movie_list WHERE mov_date_of_launch > CURDATE() AND mov_active = 'No'";

	public static final String MODIFY_MOVIE = "Update movie_list Set mov_title=?,mov_gross=?, mov_active= ?, mov_date_of_launch= ?, mov_genre= ?, mov_has_teaser=? where mov_id= ?";

	public static final String GET_MOVIE_LIST = "SELECT * FROM movie_list WHERE mov_id = ?";

	@Override
	public List<MovieList> getMovieListAdmin() {

		ArrayList<MovieList> movieList = new ArrayList<MovieList>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {
			preparedstatement = connection.prepareStatement(MOVIE_LIST_DETAILS);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MovieList movie_list = new MovieList();
				movie_list.setId(resultset.getLong("mov_id"));
				movie_list.setTitle(resultset.getString("mov_title"));
				movie_list.setGross(resultset.getLong("mov_gross"));
				movie_list.setActive(resultset.getString("mov_active").equals("Yes"));
				movie_list.setDateofLaunch(resultset.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultset.getString("mov_genre"));
				movie_list.setHasteaser(resultset.getString("mov_has_teaser").equals("Yes"));
				movieList.add(movie_list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public List<MovieList> getMovieListCustomer() {

		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MovieList> movieList = new ArrayList<MovieList>();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {
			preparedstatement = connection.prepareStatement(MOVIE_LIST);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MovieList movie_list = new MovieList();
				movie_list.setId(resultset.getLong("mov_id"));
				movie_list.setTitle(resultset.getString("mov_title"));
				movie_list.setGross(resultset.getLong("mov_gross"));
				movie_list.setActive(resultset.getString("mov_active").equals("Yes"));
				movie_list.setDateofLaunch(resultset.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultset.getString("mov_genre"));
				movie_list.setHasteaser(resultset.getString("mov_has_teaser").equals("Yes"));
				movieList.add(movie_list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public void modifyMovieList(MovieList movielist) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;

		try {
			preparedstatement = connection.prepareStatement(MODIFY_MOVIE);
			preparedstatement.setString(1, movielist.getTitle());
			preparedstatement.setFloat(2, movielist.getGross());
			preparedstatement.setString(3, movielist.getActive() ? "Yes" : "No");
			new Dateutil();
			preparedstatement.setDate(4, Dateutil.convertToSqlDate(movielist.getDateofLaunch()));
			preparedstatement.setString(5, movielist.getGenre());
			preparedstatement.setString(6, movielist.getHasteaser() ? "Yes" : "No");
			preparedstatement.setLong(7, movielist.getId());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public MovieList getMovieList(long MovielistId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		MovieList movie_list = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MOVIE_LIST);
			preparedstatement.setLong(1, MovielistId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				movie_list = new MovieList();
				movie_list.setId(resultset.getLong("mov_id"));
				movie_list.setTitle(resultset.getString("mov_title"));
				movie_list.setGross(resultset.getLong("mov_gross"));
				movie_list.setActive(resultset.getString("mov_active").equals("Yes"));
				movie_list.setDateofLaunch(resultset.getDate("mov_date_of_launch"));
				movie_list.setGenre(resultset.getString("mov_genre"));
				movie_list.setHasteaser(resultset.getString("mov_has_teaser").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedstatement.close();
				if (resultset != null)
					resultset.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return movie_list;

	}
}
