package edu.dod.core.service;


import edu.dod.core.domain.Building;
import edu.dod.core.domain.BuildingPojoForJson;

import java.util.List;


/**
 * Building service to provide business logic.
 *
 * @author sky
 * @version 140506
 */
public interface BuildingService {

    /**
     * Find all buildings.
     *
     * @return a list of {@link edu.dod.core.domain.Building}
     */
	List<Building> findAllBuildings();

    /**
     * Convert a list of {@link edu.dod.core.domain.Building} to JSON format.
     *
     * @param buildings a list of {@link edu.dod.core.domain.Building}.
     * @return a list of {@link edu.dod.core.domain.BuildingPojoForJson}.
     */
	List<BuildingPojoForJson> convertBuildingsToJson(List<Building> buildings);

    /**
     * Find a building by ID.
     *
     * @param buildingId a building ID.
     * @return {@link edu.dod.core.domain.Building}.
     */
    Building findBuildingById(String buildingId);
}
