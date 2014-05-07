package edu.dod.core.service;

import edu.dod.core.dao.ItemDao;
import edu.dod.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * An implementation of {@link edu.dod.core.service.ItemService}.
 *
 * @author sky
 * @version 140506
 */
@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    /**
     * ItemDAO to access item table.
     */
	@Autowired
	private ItemDao itemDao;

    /**
     * RoomService to use a room business logic.
     */
	@Autowired
	private RoomService roomService;

    /**
     * {@inheritDoc}
     */
	@Override
	public List<Item> findAllItems() {
		return itemDao.findAll();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public List<ItemPojoForJson> findItemsInRoom(String RoomId) {
		Room room = roomService.findRoomById(RoomId);
		Iterator<ItemMaxAllotmentForRoom> itr = room
				.getItemMaxAllotmentForRooms().iterator();
		List<ItemPojoForJson> itemListForTheBuilding = new ArrayList<ItemPojoForJson>();
		ItemMaxAllotmentForRoom itemMaxAllotmentForRoom;
		Item item;
		while (itr.hasNext()) {
			itemMaxAllotmentForRoom = itr.next();
			item = itemMaxAllotmentForRoom.getItem();
			itemListForTheBuilding.add(new ItemPojoForJson(String.valueOf(item
					.getItemId()), item.getItemName()));
		}
		return itemListForTheBuilding;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public ItemAllotmentNumberPojoForJson findAllotmentNumber(String RoomId,
			String ItemId) {
		Room room = roomService.findRoomById(RoomId);
		Iterator<ItemMaxAllotmentForRoom> itr = room
				.getItemMaxAllotmentForRooms().iterator();
		ItemMaxAllotmentForRoom itemMaxAllotmentForRoom;
		Item item;
		String number = "0";
		while (itr.hasNext()) {
			itemMaxAllotmentForRoom = itr.next();
			item = itemMaxAllotmentForRoom.getItem();
			if (item.getItemId() == Integer.parseInt(ItemId)) {
				number = String.valueOf(itemMaxAllotmentForRoom
						.getItemMaxAllotment());
			}
		}
		ItemAllotmentNumberPojoForJson itemAllotmentNumberPojoForJson = new ItemAllotmentNumberPojoForJson(
				number);
		return itemAllotmentNumberPojoForJson;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Item findItemById(int itemId) {
		return itemDao.findById(itemId);
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Item findItemById(String itemId) {
		return itemDao.findById(Integer.parseInt(itemId));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void updateItem(Item item) {
		itemDao.update(item);

	}

}
