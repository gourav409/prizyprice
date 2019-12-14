package com.ecomm.gourav_e_comm.services;

import java.util.List;

import com.ecomm.gourav_e_comm.pojo.Item;

public interface IEcommServices {
	public abstract List<Item> sortItemByPrice(List<Item> itemList);
}
