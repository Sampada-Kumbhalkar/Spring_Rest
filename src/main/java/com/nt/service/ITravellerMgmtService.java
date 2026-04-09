package com.nt.service;

import java.util.List;

import com.nt.vo.TravellerVo;

public interface ITravellerMgmtService {
	 public String registerTraveller(TravellerVo vo);///add
	 
	 public List<TravellerVo> showAllTravellers();//display
	 public TravellerVo showTravellerById(int id);//show by id

	 public String updateHeadingToByCurrentLocation(String currentLocation, String newDestinaton) ;

	 public String updateTraveller(TravellerVo vo);
	 public String deleteTravellerById(int id);
			

	 
	 

}
