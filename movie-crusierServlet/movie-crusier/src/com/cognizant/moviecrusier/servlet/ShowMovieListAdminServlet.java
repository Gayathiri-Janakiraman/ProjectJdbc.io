package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieListDao;
import com.cognizant.moviecrusier.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecrusier.model.MovieList;

/**
 * Servlet implementation class ShowMovieListAdmin
 */
@WebServlet("/ShowMovieListAdmin")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovieListAdminServlet() {
        super();	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieListDao movieListDao  = new MovieListDaoSqlImpl();
		List<MovieList> movieList = movieListDao.getMovieListAdmin();
		request.setAttribute("movie",movieList);
		request.getRequestDispatcher("movie-list-admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
