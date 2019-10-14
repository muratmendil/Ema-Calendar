package com.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.service.ObjectifService;

@RestController
@RequestMapping("/calendar")
@EnableEurekaClient
public class ObjectifApi {

	@Autowired
	private ObjectifService objectifService;
	
	
	@GetMapping("user/{id}/objectifs")
	public List<Objectif> getObjectifs(@PathVariable(value = "id") int id){
		List<Objectif> objectifs = new ArrayList<>();			
			try {
			   objectifs =  objectifService.findAllByUserId(id);
			   return objectifs;
			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return objectifs;
			} 
	 }
	
	
	@GetMapping("objectif/{id}")
	public Objectif getObjectif(@PathVariable(value = "id") int id){
		Objectif objectif = new Objectif();			
			try {
			   objectif =  objectifService.findById(id);
			   return objectif;
			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return objectif;
			} 
	 }

	
	 @PostMapping("/newObjectif")
	 public Objectif createObjectif(@Valid @RequestBody Objectif objectif){
		try {
			Objectif newObjectif =  objectifService.createObjectif(objectif);
			return newObjectif;
		} catch (ErrorExeption e) {
			return new Objectif();
		} 
	 }
	 
	 
	 @PutMapping("/updateObjectif")
	 public Objectif updateObjectif(@Valid @RequestBody Objectif objectif){
		 try {
				Objectif newObjectif =  objectifService.createObjectif(objectif);
				return objectif;
			} catch (ErrorExeption e) {
				return new Objectif();
			} 
	 }
	 

	 @DeleteMapping("/deleteObjectif/{id}")
	 public boolean deleteObjectif (@PathVariable(value = "id") int id){
		 objectifService.deleteObjectif(id);
			return true;
	 }
}
