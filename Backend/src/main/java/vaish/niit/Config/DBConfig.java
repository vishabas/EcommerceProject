package vaish.niit.Config;
import java.util.Properties;



import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import vaish.niit.Model.Cart;
import vaish.niit.Model.Category;
import vaish.niit.Model.OrderDetail;
import vaish.niit.Model.Product;
import vaish.niit.Model.Supplier;
import vaish.niit.Model.UserDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("vaish.niit")

public class DBConfig {
	
	@Bean (name="datasource")
	public DataSource getH2Datasource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
	datasource.setUsername("sa");
	datasource.setPassword("");

	System.out.println("===Creating DataSource Bean==");
	return datasource;
	}
	    @Bean(name="sessionFactory")
	    public SessionFactory getSessionFactory() {
	    Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2Datasource());
		factory1.addProperties(hibernateproperties);
		factory1.addAnnotatedClass(Category.class);
        factory1.addAnnotatedClass(Product.class);
        factory1.addAnnotatedClass(UserDetail.class);
        factory1.addAnnotatedClass(Supplier.class);
        factory1.addAnnotatedClass(Cart.class);
        factory1.addAnnotatedClass(OrderDetail.class);
	     SessionFactory sessionFactory=factory1.buildSessionFactory();
		System.out.println("===Creating the SessionFactory Bean====");
		return sessionFactory;
		
		}
	
@Bean(name="txManager")

public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	System.out.println("Creating the TransactionManager Bean");
	return new HibernateTransactionManager(sessionFactory);
	

}
}
