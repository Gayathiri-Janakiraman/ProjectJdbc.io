package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("###.00");
	static ArrayList<MenuItem> menuitem;
	static List<MenuItem> menuitemList;

	public static void display(ArrayList<MenuItem> menuitem) {
		System.out.format("\n\n%15s%25s%15s%15s%15s%15s%15s", "Id", "Name", "Price", "Date of Launch", "Active",
				"Category", "Free Delivery");

		for (MenuItem menuItem : menuitemList) {
			System.out.format("\n" + "%15s%25s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), sdf.format(menuItem.getDateofLaunch()),
					menuItem.getActive() ? "Yes" : "No", menuItem.getCategory(),
					menuItem.getFreeDelivery() ? "Yes" : "No");
		}
	}

	public static void testGetMenuItemListAdmin() {
		System.out.println("***Item List for Admin***");
		menuitemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		display(menuitem);

	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("\n\n***Item List for Customer***");
		menuitemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		display(menuitem);

	}

	public static void testmodifyMenuItem() {
		System.out.println("\n\n***Modified Menu Item***");
		MenuItem menuItem = new MenuItem(1L, "AB", 1256.23f, true, new DateUtil().convertToDate("15/03/2017"),
				"Dessert", true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
		System.out.println("\nModified " + menuItem);
	}

	public static void testgetMenuItem() {
		System.out.println("\n\n***Get Menu Item***");
		long menuItemId = 2;
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		System.out.format("\n\n%15s%25s%15s%15s%15s%15s%15s", "Id", "Name", "Price", "Date of Launch", "Active",
				"Category", "Free Delivery");
		System.out.format("\n" + "%15s%25s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
				df.format(menuItem.getPrice()), sdf.format(menuItem.getDateofLaunch()),
				menuItem.getActive() ? "Yes" : "No", menuItem.getCategory(), menuItem.getFreeDelivery() ? "Yes" : "No");

	}

	public static void main(String[] args) {

		ConnectionHandler.getConnection();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testmodifyMenuItem();
		testgetMenuItem();
	}

}
