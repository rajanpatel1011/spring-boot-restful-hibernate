package entry.restful;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement
@Entity
@Component
public class Customer {

	 @Column(length=8)
	 @Id
	 private int customerId;
	 @Column(length=10)
	 private String customerName;
	 @Column(length=3)
	 private int customerAge;
	 
	public Customer(int customerId, String customerName, int customerAge) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge
			   + "]";
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	 
	 
}
