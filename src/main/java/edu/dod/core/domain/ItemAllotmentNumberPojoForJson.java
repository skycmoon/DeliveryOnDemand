package edu.dod.core.domain;

/**
 * JSON format of ItemAllotment number.
 *
 * @author sky
 * @version 140506
 */
public class ItemAllotmentNumberPojoForJson {

    /**
     * Item allotment number in string format for JSON conversion.
     */
	private String itemAllotment;

    /**
     * Constructor.
     */
	public ItemAllotmentNumberPojoForJson(String itemAllotment) {
		this.itemAllotment = itemAllotment;
	}

	public String getItemAllotment() {
		return itemAllotment;
	}

	public void setItemAllotment(String itemAllotment) {
		this.itemAllotment = itemAllotment;
	}
	
}
