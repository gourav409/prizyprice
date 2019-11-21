package prizy.pricer.gourav_prizy_pricer.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import prizy.pricer.gourav_prizy_pricer.pojo.StoreProduct;

@Repository
public class ProductInsertRepository {
 
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void insertWithQuery(StoreProduct product) {
        entityManager.createNativeQuery("INSERT INTO store_product (id, notes, price, product_bar_code, store_id) VALUES (?,?,?,?,?)")
          .setParameter(1, product.getId())
          .setParameter(2, product.getNotes())
          .setParameter(3, product.getPrice())
          .setParameter(4, product.getProduct().getBarCode())
          .setParameter(5, product.getStore().getId())
          .executeUpdate();
    }
 
}