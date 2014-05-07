package edu.dod.core.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * DemandHistory domain representing a demand request in detail.
 *
 * @author sky
 * @version 140506
 */
@Entity
@Table(name = "DemandHistory")
@NamedQueries({
        @NamedQuery(name = "DemandHistory.findBy", query = "select distinct d from " +
                "DeliveryStatus d left join fetch d.demandHistory where d.demandID = :id")
})
public class DemandHistory {

    /**
     * Demand ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "demand_id")
    private int demandId;

    /**
     * Timestamp.
     */
    @Column(name = "demand_timestamp")
    private Timestamp timestamp;

    /**
     * Room.
     */
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    /**
     * Item.
     */
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    /**
     * Demand Quantity.
     */
    @Column(name = "demand_quantity")
    private int demandQuantity;

    /**
     * Demand Reason.
     */
    @Column(name = "demand_reason")
    private String demandReason;

    /**
     * Delivery status.
     */
    @OneToOne(mappedBy = "demandHistory", cascade = CascadeType.ALL)
    private DeliveryStatus deliveryStatus;

    /**
     * This empty constructor is required by hibernate binding mechanism.
     */
    public DemandHistory() {

    }

    /**
     * Constructor
     */
    public DemandHistory(Room room, Item item, int demandQuantity,
                         String demandReason) {
        this.room = room;
        this.item = item;
        this.demandQuantity = demandQuantity;
        this.demandReason = demandReason;
    }

    public int getDemandId() {
        return demandId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

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

    public int getDemandQuantity() {
        return demandQuantity;
    }

    public void setDemandQuantity(int demandQuantity) {
        this.demandQuantity = demandQuantity;
    }

    public String getDemandReason() {
        return demandReason;
    }

    public void setDemandReason(String demandReason) {
        this.demandReason = demandReason;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

}
