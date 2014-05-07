package edu.dod.core.service;


import edu.dod.core.domain.Item;
import edu.dod.core.domain.ItemAllotmentNumberPojoForJson;
import edu.dod.core.domain.ItemPojoForJson;

import java.util.List;

/**
 * Item service to provide item business logic.
 *
 * @author sky
 * @version 140506
 */
public interface ItemService {

    /**
     * Find all {@link edu.dod.core.domain.Item}.
     * @return a list of {@link edu.dod.core.domain.Item}.
     */
	List<Item> findAllItems();

    /**
     * Find all {@link edu.dod.core.domain.Item} in a {@link edu.dod.core.domain.Room}.
     *
     * @param RoomId a room ID.
     * @return a list of {@link edu.dod.core.domain.ItemPojoForJson}.
     */
	List<ItemPojoForJson> findItemsInRoom(String RoomId);

    /**
     * Find allotment number for a specific {@link edu.dod.core.domain.Room} and {@link edu.dod.core.domain.Item}.
     *
     * @param roomId a room ID.
     * @param itemId an item ID.
     * @return {@link edu.dod.core.domain.ItemAllotmentNumberPojoForJson}.
     */
	ItemAllotmentNumberPojoForJson findAllotmentNumber(String roomId, String itemId);

    /**
     * Find an item by an item ID.
     *
     * @param itemId an item ID.
     * @return {@link edu.dod.core.domain.Item}.
     */
	Item findItemById(int itemId);

    /**
     * Find an item by an item ID in string form.
     *
     * @param itemId an item ID in string form.
     * @return {@link edu.dod.core.domain.Item}.
     */
	Item findItemById(String itemId);

    /**
     * Update {@link edu.dod.core.domain.Item} with new data.
     *
     * @param item {@link edu.dod.core.domain.Item}.
     */
	void updateItem(Item item);

}
