package edu.dod.core.domain;

/**
 * ShortagePredictionCriteria domain to get attributes to calculate item shortages.
 *
 * @author sky
 * @version 140506
 */
public class ShortagePredictionCriteria {

    /**
     * Reserve Ratio.
     */
    private String reserveRatio;

    /**
     * Target Date.
     */
    private String targetDate;

    public String getReserveRatio() {
        return reserveRatio;
    }

    public void setReserveRatio(String reserveRatio) {
        this.reserveRatio = reserveRatio;
    }

    public String getExpectedDeliveryDate() {
        return targetDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.targetDate = expectedDeliveryDate;
    }

}
