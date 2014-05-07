package edu.dod.core.controller;

import edu.dod.core.domain.Building;
import edu.dod.core.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * A controller having a set of methods to handle the request related to buildings of the application.
 *
 * @author sky
 * @version 140506
 */
@Controller
public class BuildingsController {

    /**
     * BuildingService class which provides a business logic related to buildings.
     */
	@Autowired
    private BuildingService bs;

    /**
     * Handle a GET request for the /buildings page.
     *
     * @return a list of buildings.
     */
	@RequestMapping(value = "/buildings", method = RequestMethod.GET)
    public Collection<Building> buildings() {
        return this.bs.findAllBuildings();
    }

    /**
     * Handle a GET request to /buildings/details/{buildingId} to show details of a building.
     *
     * @param buildingId a building ID.
     * @param model a holder for model attributes.
     * @return mapping the controller to building_details jsp.
     */
	@RequestMapping(value = "/buildings/details/{buildingId}")
	public String detail(@PathVariable("buildingId") String buildingId, Model model) {
		Building building = this.bs.findBuildingById(buildingId);
		model.addAttribute(building);
		model.addAttribute("roomsInTheBuilding", building.getRooms());
		return "building_details";
	}
	
	/**
	 * Produce JSON format.
     *
	 * @return a list of JSON objects representing buildings.
	 */
	@RequestMapping(value = "/buildings/buildings", method = RequestMethod.GET, produces="application/json;charset=utf-8")
    public @ResponseBody Object castBuildings() {
		return bs.convertBuildingsToJson(bs.findAllBuildings());
    }
	
}
