package com.nt.repository;

import java.util.List;

import com.nt.entity.TravellerEntity;

public interface ITravellerRepo {
	
	 public int saveTraveller(TravellerEntity entity);
	 public List<TravellerEntity> findAll();
	 TravellerEntity getTravellerById(int id);
	 public int updateHeadingToByLocation(String loc, String dest) ;
	 public void updateTravellerData(TravellerEntity entity);
	 public void deleteTravellerId(int id);
	
	
	}


   
