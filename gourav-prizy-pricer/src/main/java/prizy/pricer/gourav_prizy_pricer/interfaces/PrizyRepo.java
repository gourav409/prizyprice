package prizy.pricer.gourav_prizy_pricer.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import prizy.pricer.gourav_prizy_pricer.pojo.StoreProduct;

@Repository
public interface PrizyRepo extends JpaRepository<StoreProduct, Integer>{
	
	@Query(value = "SELECT avg(price) FROM store_product WHERE product_bar_code = ?1", nativeQuery = true)
	  double findAveragePrice(String productBarCode);
	@Query(value = "SELECT min(price) FROM store_product WHERE product_bar_code = ?1", nativeQuery = true)
	  double findLowestPrice(String productBarCode);
	@Query(value = "SELECT max(price) FROM store_product WHERE product_bar_code = ?1", nativeQuery = true)
	  double findHighestPrice(String productBarCode);
	@Query(value = "SELECT count(price) FROM store_product WHERE product_bar_code = ?1", nativeQuery = true)
	  int findNumberOfPriceCollected(String productBarCode);
	
	@Query(value = "SELECT sum(price) FROM store_product WHERE product_bar_code = ?1", nativeQuery = true)
	  int findSumOfPrices(String productBarCode);
	@Query(value = "SELECT sum(price) FROM (SELECT price FROM store_product  WHERE product_bar_code = ?1 ORDER BY price DESC LIMIT 2) AS subquery", nativeQuery = true)
	  int findSumOfTwoMax(String productBarCode);
	@Query(value = "SELECT sum(price) FROM (SELECT price FROM store_product  WHERE product_bar_code = ?1 ORDER BY price ASC LIMIT 2) AS subquery", nativeQuery = true)
	  int findSumOfTwoMin(String productBarCode);
	@Query(value = "Select distinct product_bar_code from store_product", nativeQuery = true)
	  List<String> selectDistinctProduct();
	@Query(value = "SELECT * FROM store_product WHERE product_bar_code = ?1", nativeQuery = true)
	  StoreProduct selectProduct(String productBarCode);
	
}
