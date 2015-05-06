package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer2")
public class Customer {
	@Id
//	@GeneratedValue
	@Column(name="cust_id")
	private int id;
	@Column(name="cust_name", length=30)
	private String name;
	@Column(name="cust_email", length=50)
	private String email;
	
	@PrePersist
	public void beforeInsert() {
		System.out.println("Before inserting customer");
	}
	@PostPersist
	public void afterInsert() {
		System.out.println("After inserting customer");
	}
	
	@PreUpdate
	public void beforeUpdate() {
		System.out.println("Before updating customer");
	}
	@PostUpdate
	public void afterUpdate() {
		System.out.println("After updating customer");
	}
	
	@PreRemove
	public void beforeDelete() {
		System.out.println("Before deleting customer");
	}
	@PostRemove
	public void afterDelete() {
		System.out.println("After deleting customer");
	}
	
	@PostLoad
	public void afterSelect() {
		System.out.println("After selecting customer");
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
