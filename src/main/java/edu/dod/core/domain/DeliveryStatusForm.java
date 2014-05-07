package edu.dod.core.domain;

import java.util.List;

/**
 * DeliveryStatusForm domain.
 * <p>This is used in the DemandHistory view to show and update the delivery history and delivery status.</p>
 *
 * @author sky
 * @version 140506
 */
public class DeliveryStatusForm {

    /**
     * A list of {@link edu.dod.core.domain.DeliveryStatusCriteria}
     */
	private List<DeliveryStatusCriteria> deliveryStatusList;

	public List<DeliveryStatusCriteria> getDeliveryStatusList() {
		return deliveryStatusList;
	}
	
	public void setDeliveryStatusList(List<DeliveryStatusCriteria> demandHistoryForms) {
		this.deliveryStatusList = demandHistoryForms;
	}
	
}
