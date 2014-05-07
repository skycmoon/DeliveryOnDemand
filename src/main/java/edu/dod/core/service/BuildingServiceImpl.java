package edu.dod.core.service;


import edu.dod.core.dao.BuildingDao;
import edu.dod.core.domain.Building;
import edu.dod.core.domain.BuildingPojoForJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An Implementation of {@link edu.dod.core.service.BuildingService}.
 *
 * @author sky
 * @version 140506
 */
@Service("BuildingService")
public class BuildingServiceImpl implements BuildingService {

    /**
     * Building DAO.
     */
    @Autowired
    BuildingDao buildingDao;

    /**
     * {@inheritDoc}
     */
    @Override
	public List<Building> findAllBuildings() {
        return buildingDao.findAll();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	public List<BuildingPojoForJson> convertBuildingsToJson(List<Building> buildings) {
		List<BuildingPojoForJson> buildingListInJSONFormat = new ArrayList<BuildingPojoForJson>();
    	Iterator<Building> itr = buildings.iterator();
    	Building building;
    	while (itr.hasNext()) {
			building = itr.next();
			buildingListInJSONFormat.add(new BuildingPojoForJson(building.getBuildingId(), building.getBuildingName()));
		}
		return buildingListInJSONFormat;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Building findBuildingById(String buildingId) {
		return buildingDao.findById(buildingId);
	}

}
