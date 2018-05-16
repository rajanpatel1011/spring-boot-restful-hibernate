package entry.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entry.restful.Customer;


@Repository
public class CustomerDAO {
	@Autowired
	private SessionFactory sf;
	
	public void createCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		session.save(customer);
		ts.commit();
		session.close();
	}
	
	public Customer getCustomerById(int CustomerId) {
		Session session = sf.openSession();
		Customer c = (Customer)session.get(Customer.class, CustomerId);
		if(c==null) {
			throw new NullPointerException("Customer not Found");
		}
		
		session.close();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(){
		Session session = sf.openSession();
		Query query = session.createQuery("Select c from entry.restful.Customer c");
		List<Customer> list = query.list();
		session.close();
		return list;
	}
} 
