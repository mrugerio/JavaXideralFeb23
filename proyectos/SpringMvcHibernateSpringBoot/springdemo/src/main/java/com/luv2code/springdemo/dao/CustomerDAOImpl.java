package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}

}
