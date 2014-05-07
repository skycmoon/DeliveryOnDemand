package edu.dod.core.dao;


import edu.dod.core.domain.Room;

import java.util.List;

/**
 * Room Data Access Object.
 *
 * @author sky
 * @version 140506
 */
public interface RoomDao {

    /**
     * Find all rooms.
     *
     * @return a list of {@link edu.dod.core.domain.Room}
     */
	public List<Room> findAllRooms();

    /**
     * Find a room by the room ID.
     *
     * @param roomId a room ID.
     * @return {@link edu.dod.core.domain.Room}
     */
	public Room findById(int roomId);

}
