package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.FavoritesDao;
import com.cognizant.moviecrusier.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecrusier.dao.MovieListDao;
import com.cognizant.moviecrusier.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecrusier.model.MovieList;

/**
 * Servlet implementation class AddToFavorites
 */
@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		long userId=1l;
		long movielistId = Long.parseLong(request.getParameter("movielistId"));
				
		favoritesDao.addFavoritemovies(userId, movielistId);
		
		MovieListDao movieListDao  = new MovieListDaoSqlImpl();
		List<MovieList> movieList = movieListDao.getMovieListCustomer();
		
		request.setAttribute("movie", movieList);;
		request.setAttribute("addtofavoritesstatus",true);
		
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
