package entry.restful;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import entry.dao.CustomerDAO;

@RestController
@RequestMapping(value="root")
public class DemoRESTservices {
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/test",method=RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	public String testService() {
		return "Working";
	}
	@RequestMapping(value="/open", method = RequestMethod.GET)
	public ModelAndView opneHomePage() {
		return new ModelAndView("index");
	}
	@RequestMapping(value="/testXML", method = RequestMethod.GET, produces =MediaType.APPLICATION_XML_VALUE)
	public Customer getCustomer1() {
		return new Customer(123,"rahul",24);
		
	}
	@RequestMapping(value="/testJSON",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer2() {
		return new Customer(123,"rahl",23);
	}
	
	@RequestMapping(value="/store", method = RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String storeCustomer(@RequestBody Customer customer) {
		customerDAO.createCustomer(customer);
		return "Customer with an id"+customer.getCustomerId()+"Stored";
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET, consumes=MediaType.APPLICATION_XML_VALUE)
	public Customer getCustomer(@PathVariable("id")int customerId) {
		return customerDAO.getCustomerById(customerId);
	}
	@RequestMapping(value="/getAll",method= RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public List<Customer> getAllCustomer() {
		return customerDAO.getAllCustomers();
	}
}
