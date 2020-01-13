package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Item List for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
		System.out.println("Number of items in cart:" + menuItemList.size());

	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("\nItem List for Customer");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
		System.out.println("Number of items in cart:" + menuItemList.size());

	}

	public static void testModifyMenuItem() {
		MenuItem item = new MenuItem(5L, "Chocalate", 52.00f, true, new DateUtil().convertToDate("02/12/2022"),
				"Dessert", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(item);
		System.out.println("\n***Modified Menu Item List***");
		testGetMenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getMenuItem(item.getId());
		System.out.println("\nModified Item Details\n" + modified_item);
	}

	public static void main(String[] args) {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

}