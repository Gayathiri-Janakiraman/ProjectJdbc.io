package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void AddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);

		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 3L);

		System.out.println("User Added Cart List for Checkout");
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void RemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("\nItem List for Customer after Remove");
		try {
			// cartDao.removeCartItem(1, 2l);
			cartDao.removeCartItem(1, 5L);
			cartDao.removeCartItem(1, 3l);
			Cart cart = cartDao.getAllCartItems(1);

			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}

		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testGetAllCartItems() {

	}

	public static void main(String[] args) throws CartEmptyException {
		AddCartItem();
		RemoveCartItem();

	}

}
