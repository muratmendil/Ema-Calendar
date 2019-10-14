package com.formation.dao;

import java.util.List;

import com.formation.model.Objectif;

public interface ObjectifDao {
	Objectif createObjectif(Objectif objectif);
	Objectif findById(int id);
	 void deleteObjectif(int id);
	List<Objectif> findAllByUserId(int id);
}
