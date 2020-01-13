package com.cognizant.truyum.dao;

import java.util.Date;

import java.util.ArrayList;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		super();
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();

			MenuItem item1 = new MenuItem(1L, "Sandwich", 99.00f, true, new DateUtil().convertToDate("15/03/2017"),
					"Main course", true);
			MenuItem item2 = new MenuItem(2L, "Burger", 129.00f, true, new DateUtil().convertToDate("23/12/2017"),
					"Main course", false);
			MenuItem item3 = new MenuItem(3L, "Pizza", 149.00f, true, new DateUtil().convertToDate("21/08/2018"),
					"Main course", false);
			MenuItem item4 = new MenuItem(4L, "French Fries", 57.00f, false, new DateUtil().convertToDate("02/07/2017"),
					"starter", true);
			MenuItem item5 = new MenuItem(5L, "Chocalate Brownie", 32.00f, true,
					new DateUtil().convertToDate("02/12/2022"), "Dessert", true);
			menuItemList.add(item1);
			menuItemList.add(item2);
			menuItemList.add(item3);
			menuItemList.add(item4);
			menuItemList.add(item5);

		}

	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// Initialize an arrayList for type medium
		ArrayList<MenuItem> filteredMenuItem = new ArrayList<MenuItem>();
		// iterate through menuItemlist
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateofLaunch().before(new Date())) {
				if (menuItem.getActive()) {
					filteredMenuItem.add(menuItem);

				}

			}

		}
		return filteredMenuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);

			}

		}

	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;

			}
		}
		return null;
	}

}
