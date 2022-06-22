package net.codejava.spring.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.dao.ContactDAOImpl;
import net.codejava.spring.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/derby");
		dataSource.setUsername("root");
		dataSource.setPassword("Progamer102");
		
		dao = new ContactDAOImpl(dataSource);
		
	}
	
	
	@Test
	void testSave() {
	
		Contact contact = new Contact("testName", "testCity", "KY", "40522", "testOwnership");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		
		Contact contact = new Contact(4, "DontaesTrack", "DontaeCity", "KY", "40522", "Dontae");
		int result = dao.update(contact);
		
		assertTrue(result > 0);
		
		
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = dao.get(id);
		
		if(contact != null) {
			System.out.println(contact);
		}
		
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 5;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> listTracks = dao.list();
		
		for(Contact c : listTracks) {
			System.out.println(c);
		}
		
		assertTrue(!listTracks.isEmpty());
	}

}
