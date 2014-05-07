package edu.dod.core.controller;

import edu.dod.core.domain.Room;
import edu.dod.core.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * A controller having a set of methods to handle the request related to rooms of the application.
 *
 * @author sky
 * @version 140506
 */
@Controller
public class RoomsController {

    /**
     * RoomService class which provides a business logic related to rooms.
     */
	@Autowired
    private RoomService rs;

	/**
	 * Get /rooms page to Simply render all the room information.
	 */
	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public Collection<Room> rooms() {
		return this.rs.findAllRooms();
	}

    /**
     * Get /rooms/details/{roomId} to render a specific room information.
     *
     * @param roomId a room ID.
     * @param model a holder for model attributes.
     * @return room_detail.jsp page.
     */
	@RequestMapping(value = "/rooms/details/{roomId}")
	public String detail(@PathVariable("roomId") String roomId, Model model) {
		Room room = this.rs.findRoomById(Integer.parseInt(roomId));
		model.addAttribute(room);
		model.addAttribute("itemsInTheRoom", room.getItemMaxAllotmentForRooms());
		return "room_details";
	}

    /**
     * Find all the rooms in a specific building.
     *
     * @param buildingId a building ID.
     * @return a list of rooms.
     */
	@RequestMapping(value = "/rooms/roomsinbuilding", method = RequestMethod.GET, produces="application/json;charset=utf-8")
    public @ResponseBody Object roomsInTheBuilding(@RequestParam(value = "buildingId", required = true) String buildingId) {
		return this.rs.findAllRoomsInBuilding(buildingId);
    }
	
}