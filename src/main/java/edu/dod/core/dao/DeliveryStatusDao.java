package edu.dod.core.dao;


import edu.dod.core.domain.DeliveryStatus;

import java.util.Collection;

/**
 * DeliveryStatus Data Access Object.
 *
 * @author sky
 * @version 140506
 */
public interface DeliveryStatusDao {

    /**
     * Find all DeliveryStatus.
     *
     * @return a collection of DeliveryStatuses.
     */
	public Collection<DeliveryStatus> findAll();

    /**
     * Find a DeliveryStatus by demand ID.
     *
     * @param demandId a demand ID.
     * @return a DeliveryStatus related to the demand ID.
     */
	public DeliveryStatus findById(int demandId);

    /**
     * Update the DeliveryStatus.
     *
     * @param deliveryStatus a DeliveryStatus.
     * @return a updated DeliveryStatus.
     */
	public DeliveryStatus update(DeliveryStatus deliveryStatus);

}
