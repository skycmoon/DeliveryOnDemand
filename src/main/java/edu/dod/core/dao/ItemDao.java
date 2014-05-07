package edu.dod.core.dao;


import edu.dod.core.domain.Item;

import java.util.List;

/**
 * Item Data Access Object.
 *
 * @author sky
 * @version 140506
 */
public interface ItemDao {

    /**
     * Find all items.
     *
     * @return a list of {@link edu.dod.core.domain.Item}
     */
	public List<Item> findAll();

    /**
     * Find an item by item ID.
     *
     * @param itemId an item ID.
     * @return {@link edu.dod.core.domain.Item}
     */
	public Item findById(int itemId);

    /**
     * Update an item.
     *
     * @param item {@link edu.dod.core.domain.Item}
     * @return {@link edu.dod.core.domain.Item}
     */
	public Item update(Item item);

}
