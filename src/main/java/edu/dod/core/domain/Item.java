package edu.dod.core.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Item domain representing a item.
 *
 * @author sky
 * @version 140506
 */
@Entity
@Table(name = "Items")
@NamedQueries({
        @NamedQuery(name = "Item.findById", query = "select distinct i from " +
                "Item i left join fetch i.itemMaxAllotmentForRooms imar where i.itemId = :id")
})
public class Item {

    /**
     * Item ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    /**
     * Item name.
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * Item type.
     */
    @ManyToOne
    @JoinColumn(name = "item_type")
    private ItemType itemType;

    /**
     * Quantity currently in the storage.
     */
    @Column(name = "total_quantity_on_hand")
    private int quantityOnHand;

    /**
     * Max allotment number of this item in specific rooms.
     * <p>
     * MappedBy means the property in the ItemMaxAllotmentForRoom class that provides the
     * association(foreign key)
     * </p>
     */
    @OneToMany(mappedBy = "pk.item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemMaxAllotmentForRoom> itemMaxAllotmentForRooms = new HashSet<ItemMaxAllotmentForRoom>();

    /**
     * DemandHistory for the Item.
     */
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DemandHistory> demandHistory = new HashSet<DemandHistory>();

    /**
     * This empty constructor is required by hibernate binding mechanism.
     */
    public Item() {
    }

    /**
     * Constructor.
     */
    public Item(int itemId, String itemName, int quantityOnHand) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityOnHand = quantityOnHand;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Set<ItemMaxAllotmentForRoom> getItemMaxAllotmentForRooms() {
        return this.itemMaxAllotmentForRooms;
    }

    public void setItemMaxAllotmentForRooms(Set<ItemMaxAllotmentForRoom> itemMaxAllotmentForRooms) {
        this.itemMaxAllotmentForRooms = itemMaxAllotmentForRooms;
    }

    public void addItemMaxAllotmentForRoom(ItemMaxAllotmentForRoom itemAllotmentForRoom) {
        itemAllotmentForRoom.setItem(this);
        getItemMaxAllotmentForRooms().add(itemAllotmentForRoom);
    }

    public void removeItemMaxAllotmentForRoom(ItemMaxAllotmentForRoom itemAllotmentForRoom) {
        getItemMaxAllotmentForRooms().remove(itemAllotmentForRoom);
    }

    public Set<DemandHistory> getDemandHistory() {
        return demandHistory;
    }

    public void setDemandHistory(Set<DemandHistory> demandHistory) {
        this.demandHistory = demandHistory;
    }

    public void addADemandHistory(DemandHistory demandHistory) {
        demandHistory.setItem(this);
        getDemandHistory().add(demandHistory);
    }

    public void removeADemandHistory(DemandHistory demandHistory) {
        getDemandHistory().remove(demandHistory);
    }

}
