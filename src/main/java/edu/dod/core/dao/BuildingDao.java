package edu.dod.core.dao;


import edu.dod.core.domain.Building;

import java.util.List;

/**
 * Building Data Access Object.
 *
 * @author sky
 * @version 140506
 */
public interface BuildingDao {

    /**
     * Find all castBuildings from the database.
     *
     * @return a list of buildings.
     */
	public List<Building> findAll();

    /**
     * Find a building by ID.
     *
     * @param building_id a building ID.
     * @return a building.
     */
	public Building findById(String building_id);

}
