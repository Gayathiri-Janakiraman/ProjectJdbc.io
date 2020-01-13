package com.cognizant.truyum.dao;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("###.00");
	static List<MenuItem> menuitemList;
	static ArrayList<MenuItem> menuitem;
	private static Scanner scan;

	public static void testaddCartItem() throws CartEmptyException, NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Id:");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().addCartItem(userId, menuItemId);
	}

	public static void testgetAllCartItems() throws CartEmptyException {
		System.out.println("Enter the Id:");

		   scan = new Scanner (System.in);
		   long userId = scan.nextLong();
	       Cart cart=new CartDaoSqlImpl().getAllCartItems(userId);
	       List<MenuItem> menu_item = cart.getMenuItemList();
	     	    	 
	       System.out.format("\n%-5s%-20s%-15s%-20s%-15s", "ID", "NAME", "PRICE", 
	               "CATEGORY", "FREE DELIVERY");
	       for(MenuItem menu_Item : menu_item) {
	    	 
	       System.out.format("\n%-5s%-20s%-15s%-20s%-15s", menu_Item.getId(), menu_Item.getName(),
	               "Rs." + df.format(menu_Item.getPrice()),
	               menu_Item.getCategory(), menu_Item.getFreeDelivery()? "Yes" : "No");
	       }
	       System.out.println("\nTotal" + cart.getTotal());
	    }

	public static void testremoveCartItem() throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter user id value to remove:");
        long userId = Long.parseLong(bf.readLine());
        System.out.println("Enter user menu item id value to remove");
        long menuItemId = Long.parseLong(bf.readLine());
        new CartDaoSqlImpl().removeCartItem(userId, menuItemId);
	}

	public static void main(String[] args) throws CartEmptyException, NumberFormatException, IOException {

		testaddCartItem();
		testgetAllCartItems();
		testremoveCartItem();
	}
}