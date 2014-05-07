package edu.dod.core.domain;


/**
 * Json format for {@link edu.dod.core.domain.Room}.
 *
 * @author sky
 * @version 140506
 */
public class RoomPojoForJson {

    /**
     * Room ID.
     */
	private String roomId;

    /**
     * Room name.
     */
    private String roomName;

    /**
     * Constructor.
     */
	public RoomPojoForJson(String roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
	}
	
	public String getRoomId() {
		return roomId;
	}
	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	

}
