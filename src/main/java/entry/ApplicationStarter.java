package entry;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApplicationStarter {

	
	public static void main(String[] args) {
         SpringApplication.run(ApplicationStarter.class);
	
	}
	@Bean
	public SessionFactory loadSessionFactory(HibernateEntityManagerFactory emf) {
		return emf.getSessionFactory();
	}
	
}
