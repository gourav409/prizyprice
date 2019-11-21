package prizy.pricer.gourav_prizy_pricer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import prizy.pricer.gourav_prizy_pricer.interfaces.PrizyRepo;
import prizy.pricer.gourav_prizy_pricer.pojo.Product;
import prizy.pricer.gourav_prizy_pricer.pojo.StoreProduct;
import prizy.pricer.gourav_prizy_pricer.repository.ProductInsertRepository;
import prizy.pricer.gourav_prizy_pricer.services.ProductServices;

@Controller
public class TestController {
	
	@Autowired
	PrizyRepo prizyRepo;
	
	@Autowired
	ProductServices productService;
	
	@Autowired
	ProductInsertRepository pir;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("storeproduct")
	public String storeProductForm(@Valid StoreProduct storeProduct, BindingResult bindingResult, Model model) {
		model.addAttribute("storeProduct", new StoreProduct());
		return "home";
	}
	@PostMapping("storeproduct")
	public String storeProductSubmit(@Valid StoreProduct storeProduct, BindingResult bindingResult) {
		//custom query for insertion
		//pir.insertWithQuery(storeProduct);
		prizyRepo.save(storeProduct);
		return "result";
	}
	
	@GetMapping("viewproduct")
	public String viewProductForm(@Valid StoreProduct product, BindingResult bindingResult, Model model) {
		model.addAttribute("barcode", new Product());
		List<String> storeProduct = (List<String>) prizyRepo.selectDistinctProduct();
		model.addAttribute("listStoreProduct", storeProduct);
		return "viewproductform";
	}
	
	@PostMapping("viewproduct")
	public String viewProductSubmit(Model model, HttpServletRequest request) {
		
		String barCode = request.getParameter("Productbarcode");
		double avgPrice = prizyRepo.findAveragePrice(barCode);
		double highestPrice = prizyRepo.findHighestPrice(barCode);
		double lowestPrice = prizyRepo.findLowestPrice(barCode);
		
		double idealPrice = productService.calculateIdealPrice(barCode);
			StoreProduct product = new StoreProduct();
		  product.setAveragePrice(avgPrice); 
		  product.setHighestPrice(highestPrice);
		  product.setLowestPrice(lowestPrice);
		  product.setIdealPrice(idealPrice);
		  Product p = new Product();
		  p.setBarCode(barCode);
		  product.setProduct(p);
		 
		
		model.addAttribute("storeProduct", product);
		return "viewproduct";
	}

}