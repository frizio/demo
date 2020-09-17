package cloud.frizio.web.demo.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.frizio.web.demo.mvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @Autowired
  private SessionFactory sessionFactory;


  @Override
  @Transactional
  public List<Customer> getCustomers() {
    //Get the current hibernate session
    Session session = sessionFactory.getCurrentSession();
    // Create a query
    Query<Customer> query = session.createQuery("from Customer", Customer.class);
    // Execute query and get result list
    List<Customer> customers = query.getResultList();
    //Return the results
    return customers;
  }
  
}
