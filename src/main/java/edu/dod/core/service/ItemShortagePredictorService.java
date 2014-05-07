package edu.dod.core.service;


import edu.dod.core.domain.Item;
import edu.dod.core.domain.ShortagePredictionCriteria;

import java.util.Collection;

/**
 * ItemShortagePredictor service to provide item shortage prediction logic.
 *
 * @author sky
 * @version 140506
 */
public interface ItemShortagePredictorService {

    /**
     * Predict Item Shortage.
     * Has not yet fully implemented.
     *
     * @param shortagePredictionCriteria {@link edu.dod.core.domain.ShortagePredictionCriteria}.
     * @return a collection of {@link edu.dod.core.domain.Item}.
     */
	Collection<Item> predictItemShortage(ShortagePredictionCriteria shortagePredictionCriteria);

}
