package com.cognizant.truyum.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public static final String MENU_ITEM_DETAILS = "select * from menu_item";

	public static final String MENU_ITEM = "select * from menu_item where me_date_of_launch > CURDATE() and me_active='Yes' ";

	public static final String MODIFY_MENU_ITEM = "update menu_item set " + "me_name=?,me_price=?,me_active=?,"
			+ "me_date_of_launch=?,me_category=?," + "me_free_delivery=?  where me_id=?";

	public static final String GET_MENU_ITEM = "select * from menu_item  where me_id=?";
	
	public List<MenuItem> getMenuItemListAdmin() {

		ArrayList<MenuItem> menuitemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {
			preparedstatement = connection.prepareStatement(MENU_ITEM_DETAILS);
			// A ResultSet object maintains a cursor pointing to its current row of data
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MenuItem menu_item = new MenuItem();
				menu_item.setId(resultset.getLong("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateofLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));
				menuitemList.add(menu_item);
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
		return menuitemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuitemList = new ArrayList<>();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {
			preparedstatement = connection.prepareStatement(MENU_ITEM);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MenuItem menu_item = new MenuItem();
				menu_item.setId(resultset.getLong("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateofLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));
				menuitemList.add(menu_item);
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
		return menuitemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;

		try {
			preparedstatement = connection.prepareStatement(MODIFY_MENU_ITEM);
			preparedstatement.setString(1, menuItem.getName());
			preparedstatement.setFloat(2, menuItem.getPrice());
			preparedstatement.setString(3, menuItem.getActive() ? "Yes" : "No");
			new DateUtil();
			preparedstatement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateofLaunch()));
			preparedstatement.setString(5, menuItem.getCategory());
			preparedstatement.setString(6, menuItem.getFreeDelivery() ? "Yes" : "No");
			preparedstatement.setLong(7, menuItem.getId());
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
	public MenuItem getMenuItem(Long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		MenuItem menu_item = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MENU_ITEM);
			preparedstatement.setLong(1, menuItemId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				menu_item = new MenuItem();
				menu_item.setId(resultset.getLong("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateofLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));

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
		return menu_item;

	}
}
