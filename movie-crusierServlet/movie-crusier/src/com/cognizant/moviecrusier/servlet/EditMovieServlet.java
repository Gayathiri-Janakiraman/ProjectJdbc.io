package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieListDao;
import com.cognizant.moviecrusier.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecrusier.model.MovieList;
import com.cognizant.moviecrusier.util.Dateutil;

/**
 * Servlet implementation class EditMovie
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id=Long.parseLong(request.getParameter("id"));
		String title=request.getParameter("title");
		long gross=Long.parseLong(request.getParameter("gross"));
		boolean active=request.getParameter("active").equals("yes");
		Date dateofLaunch=new Dateutil().convertToDate(request.getParameter("dateofLaunch"));
		String genre=request.getParameter("genre");
		boolean hasteaser=request.getParameter("hasteaser")!=null;
		MovieList movielist=new MovieList(id,title,gross,active,dateofLaunch,genre,hasteaser);
		MovieListDao movieListDao  = new MovieListDaoSqlImpl();
		movieListDao.modifyMovieList(movielist);
		request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
		doGet(request, response);
	}

}
