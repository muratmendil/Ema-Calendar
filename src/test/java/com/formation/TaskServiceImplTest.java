package com.formation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.service.ObjectifService;
import com.formation.service.TaskService;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceImplTest {

	@Autowired
	TaskService taskService;
	
	@Autowired
	ObjectifService objectifService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateTask() {
		Task task = new Task();
		Objectif ob = new Objectif();
		ob.setTitle("Espagnol");
		ob.setStart("2018/08/22 12:00");
		ob.setEnd("2018/08/23 12:00");
		ob.setUserId(1);

		Task createTask = null;
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		
		task.setTitle("Verre irréguliers");
		task.setStart("2018/08/22 12:00");
		task.setEnd("2018/08/23 12:00");
		task.setPlace("Paris");
		task.setPriorityLevel(2);
		
		try {
			createTask = taskService.createTask(task);
			Assert.assertNotNull(createTask);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createTask);
		} 

	}

	@Test
	public void testFindById() {
		Task task = null;
		try {
			task = taskService.findById(1);
			Assert.assertNotNull(task);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(task);
			System.out.println(e.getExeptionMessage());
		}
	}

	@Test
	public void testDeleteTask() {
		Task task = new Task();
		Objectif ob = new Objectif();
		ob.setTitle("Espagnol");
		ob.setStart("2018/08/22 12:00");
		ob.setEnd("2018/08/23 12:00");
		ob.setUserId(1);
		
		Task createTask = null;
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		
		task.setTitle("Verre irréguliers");
		task.setStart("2018/08/22 12:00");
		task.setEnd("2018/08/23 12:00");
		task.setPlace("Paris");
		task.setPriorityLevel(2);
		task.setObjectifId(createObjectif.getId());
		//task.setObjectif(createObjectif);
		try {
			createTask = taskService.createTask(task);
			Assert.assertNotNull(createTask);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createTask);
		} 
		int id = task.getId();
		
		taskService.deleteTask(id);
		Task finalTask = null;
		try {
			finalTask = taskService.findById(id);
			Assert.assertNotNull(task);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(finalTask);
			System.out.println(e.getExeptionMessage());
		}
	
	} 
}
 