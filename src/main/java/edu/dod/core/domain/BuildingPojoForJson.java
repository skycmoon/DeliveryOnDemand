package edu.dod.core.domain;

/**
 * JSON format of Building Domain .
 *
 * @author sky
 * @version 140506
 */
public class BuildingPojoForJson {

    /**
     * Building ID.
     */
	private String buildingId;

    /**
     * Building Name.
     */
	private String buildingName;

    /**
     * Constructor.
     *
     * @param buildingId a building ID.
     * @param buildingName a building name.
     */
	public BuildingPojoForJson(String buildingId, String buildingName) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
