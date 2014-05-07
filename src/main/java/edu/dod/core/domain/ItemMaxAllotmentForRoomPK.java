package edu.dod.core.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * This class is to represent composite primary keys of ItemNMasAllotmentForRoom.
 * <p>Composite key class should implement {@link java.io.Serializable} in Hibernate.</p>
 *
 * @author sky
 * @version 140506
 */
@Embeddable
public class ItemMaxAllotmentForRoomPK implements Serializable {

    private static final long serialVersionUID = -1090603651631026323L;

    /**
     * Room.
     */
	@ManyToOne
	private Room room;

    /**
     * Item.
     */
	@ManyToOne
	private Item item;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
