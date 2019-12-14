package com.ecomm.gourav_e_comm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.gourav_e_comm.interfaces.IEcommRepo;
import com.ecomm.gourav_e_comm.pojo.Item;

@Service
public class EcommServicesImpl implements IEcommServices {

	@Autowired
	IEcommRepo eCommRepo;

	@Override
	public List<Item> sortItemByPrice(List<Item> itemList) {
		
		//Collections.sort(itemList);
		return itemList;
		
	}
	
	
	
//	@Override
//	public double calculateIdealPrice(String productBarCode) {
//		double idealPrice = 0;
//		double totalPrice = prizyRepo.findSumOfPrices(productBarCode);
//		double sumOfMaxTwo = prizyRepo.findSumOfTwoMax(productBarCode);
//		double sumOfMinTwo = prizyRepo.findSumOfTwoMin(productBarCode);
//		int count = prizyRepo.findNumberOfPriceCollected(productBarCode);
//		if(count > 4) {
//			count -= 4;
//			idealPrice = (totalPrice-sumOfMaxTwo-sumOfMinTwo)/count;
//			idealPrice = (idealPrice + ((idealPrice*20)/100));
//			return idealPrice;
//		}
//		else {
//			return prizyRepo.findAveragePrice(productBarCode);
//		}
//	}
}
