package edu.dod.core.service;


import edu.dod.core.domain.DeliveryStatusForm;
import edu.dod.core.domain.DemandForm;
import edu.dod.core.domain.DemandHistory;

import java.util.Collection;

/**
 * Demand history service to provide business logic.
 *
 * @author sky
 * @version 140506
 */
public interface DemandHistoryService {

    /**
     * Find all {@link edu.dod.core.domain.DemandHistory}.
     *
     * @return a collection of {@link edu.dod.core.domain.DemandHistory}.
     */
	Collection<DemandHistory>findAllDemandHistory();

    /**
     * Extract a {@link edu.dod.core.domain.DeliveryStatusForm} from a collection
     * of {@link edu.dod.core.domain.DemandHistory}.
     *
     * @param demandHistories a collection of {@link edu.dod.core.domain.DemandHistory}.
     * @return {@link edu.dod.core.domain.DeliveryStatusForm}.
     */
	DeliveryStatusForm extractDeliveryStatusForm(Collection<DemandHistory> demandHistories);

    /**
     * Update a {@link edu.dod.core.domain.DemandForm}.
     *
     * @param demandForm {@link edu.dod.core.domain.DemandForm}.
     */
	void updateDemandHistory(DemandForm demandForm);

    /**
     * Update {@link edu.dod.core.domain.DeliveryStatusForm}.
     *
     * @param deliveryStatusForm {@link edu.dod.core.domain.DeliveryStatusForm}.
     */
	void updateDeliveryStatus(DeliveryStatusForm deliveryStatusForm);

}
