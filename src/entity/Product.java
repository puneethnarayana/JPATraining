package entity;

import java.awt.BufferCapabilities.FlipContents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_Product")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="Product_ID")
	private int productID;
	
	@Column(name="Product_Name")
	private String productName;
	
	@Column(name="Product_Quantity")
	private int Quantity;

	public Product(){}

	@Override
	public String toString() {
		//System.out.println("ID: "+productID+" Product: "+productName+" Quantity: "+Quantity);
		return "ID:"+productID+" Product: "+productName+" Quantity: "+Quantity;
	}

	public Product(int quantity, String productName) {
		this.Quantity = quantity;
		this.productName = productName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
