package edu.dod.core.domain;

/**
 * DeliveryStatusCriteria Domain.
 *
 * @author sky
 * @version 140506
 */
public class DeliveryStatusCriteria {

    /**
     * Check flag to indicate whether this item is modified.
     */
    private boolean changeCheckFlag;

    /**
     * Demand ID.
     */
    private String demandId;

    /**
     * Timestamp.
     */
    private String timeStamp;

    /**
     * Room ID.
     */
    private String roomId;

    /**
     * Room name.
     */
    private String roomName;

    /**
     * Item ID.
     */
    private String itemId;

    /**
     * Item name.
     */
    private String itemName;

    /**
     * Quantity.
     */
    private String quantity;

    /**
     * Veracity of the demand request.
     */
    private String veracity;

    /**
     * Delivery status.
     */
    private String deliveryStatus;

    /**
     * Constructor.
     */
    public DeliveryStatusCriteria(boolean changeCheckFlag, String demandId,
                                  String timeStamp, String roomId, String roomName, String itemId,
                                  String itemName, String quantity, String veracity,
                                  String deliveryStatus) {
        super();
        this.changeCheckFlag = changeCheckFlag;
        this.demandId = demandId;
        this.timeStamp = timeStamp;
        this.roomId = roomId;
        this.roomName = roomName;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.veracity = veracity;
        this.deliveryStatus = deliveryStatus;
    }

    public boolean isChangeCheckFlag() {
        return changeCheckFlag;
    }

    public String getDemandId() {
        return demandId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getVeracity() {
        return veracity;
    }

    public void setVeracity(String veracity) {
        this.veracity = veracity;
        changeCheckFlag = true;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        changeCheckFlag = true;
    }

}
