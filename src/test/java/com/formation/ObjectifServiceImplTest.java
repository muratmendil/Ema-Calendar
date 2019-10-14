package com.formation;

import static org.junit.Assert.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.service.ObjectifService;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
public class ObjectifServiceImplTest {
	
	@Autowired
	ObjectifService objectifService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateObjectif() { 
		
		Objectif ob = new Objectif();
		ob.setTitle("Anglais");
		ob.setStart("2018/08/22 12:00");
		ob.setEnd("2018/08/23 12:00");
		ob.setUserId(1);
		
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
	}

	@Test
	public void testFindById() {
		
		Objectif ob = new Objectif();
		ob.setTitle("Anglais");
		ob.setStart("2018/08/22 12:00");
		ob.setEnd("2018/08/23 12:00");
		ob.setUserId(1);

		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		
		
		Objectif findObjectif = null;
		try {
			findObjectif = objectifService.findById(1);
			Assert.assertNotNull(findObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(findObjectif);
			System.out.println(e.getExeptionMessage());
		}
	}

	@Test
	public void testGetAll() {
		
		Objectif ob = new Objectif();
		ob.setTitle("Francais");
		ob.setStart("2018/08/22 12:00");
		ob.setEnd("2018/08/23 12:00");
		ob.setUserId(1);
		
		Objectif ob2 = new Objectif();
		ob2.setTitle("Espagnole");
		ob2.setStart("2018/08/22 12:00");
		ob2.setEnd("2018/08/23 12:00");
		ob2.setUserId(2);
		
		Objectif createObjectif = null;
		Objectif createObjectif2 = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			createObjectif2 = objectifService.createObjectif(ob2);
			Assert.assertNotNull(createObjectif2);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
			Assert.assertNull(createObjectif2);
		} 
		
		List<Objectif> obs = null;
		try {
			obs = objectifService.findAllByUserId(1);
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
		}
	} 
} 
