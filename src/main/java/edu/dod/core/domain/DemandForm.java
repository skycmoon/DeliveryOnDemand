package edu.dod.core.domain;

/**
 * DemandForm Domain.
 * <p>This class is used to request a demand of items in a specific room.</p>
 *
 * @author sky
 * @version 140506
 */
public class DemandForm {

    /**
     * Building ID.
     */
	private String buildingId;

    /**
     * Room ID.
     */
    private String roomId;

    /**
     * Item ID.
     */
    private String itemId;

    /**
     * Demand Quantity.
     */
    private String demandQuantity;

    /**
     * Reason.
     */
    private String reason;
	
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDemandQuantity() {
		return demandQuantity;
	}
	public void setDemandQuantity(String demandQuantity) {
		this.demandQuantity = demandQuantity;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
