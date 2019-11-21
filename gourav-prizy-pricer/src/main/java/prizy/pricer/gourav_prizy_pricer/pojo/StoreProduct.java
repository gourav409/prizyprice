package prizy.pricer.gourav_prizy_pricer.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
@Entity
public class StoreProduct{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Store store;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Product product;
	
	@Column(nullable = false)
	private double price;
	
	@Column
	private String notes;
	
	
	  @Transient double averagePrice;
	  
	  @Transient double highestPrice;
	  
	  @Transient double lowestPrice;
	  
	  @Transient int noOfPrice;
	  
	  @Transient double idealPrice;
	 
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getAveragePrice() {
		return averagePrice;
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public int getNoOfPrice() {
		return noOfPrice;
	}
	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public void setNoOfPrice(int noOfPrice) {
		this.noOfPrice = noOfPrice;
	}
	public double getIdealPrice() {
		return idealPrice;
	}
	public void setIdealPrice(double idealPrice) {
		this.idealPrice = idealPrice;
	}
	
	 
}
