package edu.dod.core.dao;


import edu.dod.core.domain.DemandHistory;

import java.util.Collection;
import java.util.Date;

/**
 * DemandHistory Data Access Object.
 *
 * @author sky
 * @version 140506
 */
public interface DemandHistoryDao {

    /**
     * Find all DemandHistory.
     *
     * @return a collection of {@link edu.dod.core.domain.DemandHistory}
     */
	public Collection<DemandHistory> findAll();

    /**
     * Update a DemandHistory.
     *
     * @param demandHistory {@link edu.dod.core.domain.DemandHistory}
     * @return
     */
	public DemandHistory update(DemandHistory demandHistory);

}
