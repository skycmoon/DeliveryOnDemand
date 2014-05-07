package edu.dod.core.domain;


/**
 * JSON format representing an {@link edu.dod.core.domain.Item}.
 *
 * @author sky
 * @version 140506
 */
public class ItemPojoForJson {

    /**
     * Item ID.
     */
	private String itemId;

    /**
     * Item name.
     */
	private String itemName;

    /**
     * Constructor.
     *
     * @param itemId Item ID.
     * @param itemName Item name.
     */
	public ItemPojoForJson(String itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}
	
	public String getItemId() {
		return itemId;
	}
	
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
