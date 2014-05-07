package edu.dod.core.service;


import edu.dod.core.domain.Room;
import edu.dod.core.domain.RoomPojoForJson;

import java.util.List;

/**
 * Room Service to provide room business logic.
 * @author sky
 * @version 140506
 */
public interface RoomService {

    /**
     * Find all rooms.
     *
     * @return a list of {@link edu.dod.core.domain.Room}.
     */
	List<Room> findAllRooms();

    /**
     * Find all rooms in a specific building.
     *
     * @param buildingId a building ID in sting.
     * @return a list of {@link edu.dod.core.domain.RoomPojoForJson}.
     */
	List<RoomPojoForJson> findAllRoomsInBuilding(String buildingId);

    /**
     * Find a room by ID.
     *
     * @param roomId a room ID.
     * @return {@link edu.dod.core.domain.Room}.
     */
	Room findRoomById(int roomId);

    /**
     * Find a room by ID in string.
     *
     * @param roomId a room ID in string.
     * @return {@link edu.dod.core.domain.Room}.
     */
	Room findRoomById(String roomId);

}
