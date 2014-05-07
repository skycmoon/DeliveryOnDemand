package edu.dod.core.controller;

import edu.dod.core.domain.Item;
import edu.dod.core.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * A controller having a set of methods to handle the request related to items of the application.
 *
 * @author sky
 * @version 140506
 */
@Controller
public class ItemsController {

    /**
     * ItemService class which provides a business logic related to items.
     */
	@Autowired
	private ItemService is;
	
	/**
	 * Get /item page to render all the items.
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public Collection<Item> items() {
		return is.findAllItems();
	}

    /**
     * Get /items/details/{itemId} page to render a specific item.
     *
     * @param itemId a item ID.
     * @param model a holder for model attributes.
     * @return item_details.jsp.
     */
	@RequestMapping(value = "/items/details/{itemId}")
	public String detail(@PathVariable("itemId") String itemId, Model model) {
		Item item = this.is.findItemById(Integer.parseInt(itemId));
		model.addAttribute(item);
		model.addAttribute("roomsTheItemIn", item.getItemMaxAllotmentForRooms());
		return "item_details";
	}

    /**
     * Returns all the items in a specific room in JSON format.
     *
     * @param roomId a room ID.
     * @return all the items in the room.
     */
	@RequestMapping(value = "/items/itemsinroom", method = RequestMethod.GET, produces="application/json;charset=utf-8")
    public @ResponseBody Object itemsInTheRoom(@RequestParam(value = "roomId", required = true) String roomId) {
		return this.is.findItemsInRoom(roomId);
    }

    /**
     * Returns a item allotment in a room in JSON format.
     *
     * @param roomId a room ID.
     * @param itemId an item ID.
     * @return the allotment for a specific room and item.
     */
	@RequestMapping(value = "/items/itemAllotment", method = RequestMethod.GET, produces="application/json;charset=utf-8")
    public @ResponseBody Object itemAllotmentForTheRoom(@RequestParam(value = "roomId", required = true) String roomId, 
    		@RequestParam(value = "itemId", required = true) String itemId) {
		return this.is.findAllotmentNumber(roomId, itemId);
    }
}