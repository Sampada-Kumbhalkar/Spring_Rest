package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.TravellerEntity;
import com.nt.exception.TravellerNotFoundException;
import com.nt.repository.ITravellerRepo;
import com.nt.vo.TravellerVo;

@Service
public class TravellerMgmtServiceImpl implements ITravellerMgmtService{

	 @Autowired
	    private ITravellerRepo travellerRepo;
	@Override
	public String registerTraveller(TravellerVo vo) {
		  //convert vo to Entity
        TravellerEntity entity = new TravellerEntity();
        BeanUtils.copyProperties(vo, entity);
        
        //set required data
        entity.setCreatedBy(System.getProperty("user.name"));
        
        int idVal = travellerRepo.saveTraveller(entity);
        return "Traveller is saved with id value :: " + idVal;
    }
	//=========================================
	@Override
	public List<TravellerVo> showAllTravellers() {

	    // get entity list from DAO
	    List<TravellerEntity> listEntity = travellerRepo.findAll();

	    // create entity class obj into  VO object
	    List<TravellerVo> listVO = new ArrayList<>();

	    // convert using for-loop (NOT stream)
	    for (TravellerEntity entity : listEntity) {
	        TravellerVo vo = new TravellerVo();
	        BeanUtils.copyProperties(entity, vo);
	        listVO.add(vo);
	    }

	    return listVO;
	}
	//==================================
	@Override
	public TravellerVo showTravellerById(int id) {

	    TravellerEntity entity = travellerRepo.getTravellerById(id);
	    try {
	    if (entity == null) {
	        throw new TravellerNotFoundException("Traveller not found with id: " + id);
	    }
	    }
	    catch(TravellerNotFoundException t)
	    {
	    	t.printStackTrace();
	    }

	    TravellerVo vo = new TravellerVo();
	    BeanUtils.copyProperties(entity, vo);

	    return vo;
	}
//=============================================================
	@Override
	public String updateHeadingToByCurrentLocation(String currentLocation, String newDestinaton) {
	    //use Repo
	    int count = travellerRepo.updateHeadingToByLocation(currentLocation,newDestinaton);
	   

	    return count + " no.of Travellers locaton is changed";
	}
	//======================================
	@Override
	public String updateTraveller(TravellerVo vo) {
	    //findById
	    TravellerEntity entity = travellerRepo.getTravellerById(vo.getTid());
	    //copy new data replacing old data
	    BeanUtils.copyProperties(vo, entity);
	    //update the object
	    travellerRepo.updateTravellerData(entity);
	    return vo.getTid() + " Traveller is updated";
	}
	//==================================
	 @Override
	  public String deleteTravellerById(int id) {
		    //findById
		    TravellerEntity entity = travellerRepo.getTravellerById(id);
		 //delete the Traveller
	      travellerRepo.deleteTravellerId(id);
	      return "Traveller Found and Deleted";
	  }
}




	
	
