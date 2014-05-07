package edu.dod.core.domain;

import javax.persistence.*;

/**
 * ItemMaxAllotmentForRoom domain to represent a max number of item numbers in a specific room.

 * @author sky
 * @version 140506
 */
@Entity
@Table(name = "ItemMaxAllotmentForRoom")
@AssociationOverrides({
		@AssociationOverride(name = "pk.room", joinColumns = @JoinColumn(name = "room_id")),
		@AssociationOverride(name = "pk.item", joinColumns = @JoinColumn(name = "item_id"))
})
public class ItemMaxAllotmentForRoom {

    /**
     * ItemMaxAllotmentForRoom composite keys.
     */
	@EmbeddedId
	private ItemMaxAllotmentForRoomPK pk = new ItemMaxAllotmentForRoomPK();

    /**
     * ItemMaxAllotment number.
     */
	@Column(name = "item_max_allotment")
	private int itemMaxAllotment;

	public ItemMaxAllotmentForRoomPK getPk() {
		return pk;
	}

	public void setPk(ItemMaxAllotmentForRoomPK pk) {
		this.pk = pk;
	}

	@Transient
	public Room getRoom() {
		return this.pk.getRoom();
	}

	public void setRoom(Room room) {
		this.pk.setRoom(room);
	}

	@Transient
	public Item getItem() {
		return this.pk.getItem();
	}

	public void setItem(Item item) {
		this.pk.setItem(item);
	}

	public int getItemMaxAllotment() {
		return itemMaxAllotment;
	}

	public void setItemMaxAllotment(int itemMaxAllotment) {
		this.itemMaxAllotment = itemMaxAllotment;
	}

}
