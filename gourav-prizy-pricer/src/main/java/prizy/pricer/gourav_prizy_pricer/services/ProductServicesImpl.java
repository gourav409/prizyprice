package prizy.pricer.gourav_prizy_pricer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prizy.pricer.gourav_prizy_pricer.interfaces.PrizyRepo;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	PrizyRepo prizyRepo;
	
	@Override
	public double calculateIdealPrice(String productBarCode) {
		double idealPrice = 0;
		double totalPrice = prizyRepo.findSumOfPrices(productBarCode);
		double sumOfMaxTwo = prizyRepo.findSumOfTwoMax(productBarCode);
		double sumOfMinTwo = prizyRepo.findSumOfTwoMin(productBarCode);
		int count = prizyRepo.findNumberOfPriceCollected(productBarCode);
		if(count > 4) {
			count -= 4;
			idealPrice = (totalPrice-sumOfMaxTwo-sumOfMinTwo)/count;
			idealPrice = (idealPrice + ((idealPrice*20)/100));
			return idealPrice;
		}
		else {
			return prizyRepo.findAveragePrice(productBarCode);
		}
	}
}
