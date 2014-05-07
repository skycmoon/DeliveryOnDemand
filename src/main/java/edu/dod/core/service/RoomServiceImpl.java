package edu.dod.core.service;

import edu.dod.core.dao.BuildingDao;
import edu.dod.core.dao.RoomDao;
import edu.dod.core.domain.Building;
import edu.dod.core.domain.Room;
import edu.dod.core.domain.RoomPojoForJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * An implementation of {@link edu.dod.core.service.RoomService}.
 *
 * @author sky
 * @version 140506
 */
@Service("RoomService")
public class RoomServiceImpl implements RoomService {

    /**
     * RoomDao to access the room table.
     */
	@Autowired
    RoomDao roomDao;

    /**
     * BuildingDAO to access the building table.
     */
	@Autowired
    BuildingDao buildingDao;

    /**
     * {@inheritDoc}
     */
	@Override
	public List<Room> findAllRooms() {
		return roomDao.findAllRooms();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public List<RoomPojoForJson> findAllRoomsInBuilding(String buildingId) {
		Building building = buildingDao.findById(buildingId);
		if (building != null) {
			Iterator<Room> itr = building.getRooms().iterator();
			List<RoomPojoForJson> roomListInTheBuilding = new ArrayList<RoomPojoForJson>();
			Room room;
			while (itr.hasNext()) {
				room = itr.next();
				roomListInTheBuilding.add(new RoomPojoForJson(String.valueOf(room.getRoomId()), room.getRoomName()));
			}
			return roomListInTheBuilding;
		} else {
			System.out.println("ERROR");
			return null;
		}
		
		
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Room findRoomById(int roomId) {
		return roomDao.findById(roomId);
	}

    /**
     * {@inheritDoc}
     * @param roomId a room ID in string.
     * @return
     */
	@Override
	public Room findRoomById(String roomId) {
		return roomDao.findById(Integer.parseInt(roomId));
	}
	
}
