package com.cognizant.truyum.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id) values (?,?)";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, menuItemId);
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

	public static final String GET_ALL_CART_ITEMS = "SELECT  me_id,me_name, me_free_delivery, me_price,me_category FROM cart INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id INNER JOIN user on user.us_id = cart.ct_us_id WHERE user.us_id=?";

	public static final String GET_TOTAL = "SELECT  sum(menu_item.me_price) as Total FROM cart INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id INNER JOIN user on user.us_id = cart.ct_us_id WHERE user.us_id=?";

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		ArrayList<MenuItem> menuitemList = new ArrayList<MenuItem>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menu_item = null;
		Cart cart = new Cart();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_CART_ITEMS);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				menu_item = new MenuItem();
				menu_item.setId(resultSet.getLong("me_id"));
				menu_item.setName(resultSet.getString("me_name"));
				menu_item.setPrice(resultSet.getFloat("me_price"));
				menu_item.setCategory(resultSet.getString("me_category"));
				menu_item.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuitemList.add(menu_item);
			}
			if (menuitemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuitemList);
			// Total
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			double total = 0.0;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getDouble("Total");
			}
			cart.setTotal(total);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatementTotal != null) {
					preparedStatementTotal.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

    public static final String DELETE_CART = "delete from truyum.cart where ct_us_id=? and ct_me_id=? limit 1";
    
	@Override
	public void removeCartItem(long userId, long menuItemId) {
        @SuppressWarnings("unused")
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
        Connection connection = ConnectionHandler.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_CART);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, menuItemId);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            try {

                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {

            }

        }
    }

}
