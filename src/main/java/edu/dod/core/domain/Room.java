package edu.dod.core.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Room domain representing a room.
 *
 * @author sky
 * @version 140506
 */
@Entity
@Table(name = "Rooms")
@NamedQueries({
        @NamedQuery(name = "Room.findById", query = "select distinct r from " +
                "Room r left join fetch r.itemMaxAllotmentForRooms imar where r.roomId = :id")
})
public class Room {

    /**
     * Room ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;

    /**
     * Room name.
     */
    @Column(name = "room_name")
    private String roomName;

    /**
     * Building ID.
     */
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    /**
     * A set of max allotment number of a item in a room.
     * <p>
     * mappedBy means the property in the ItemMaxAllotmentForRoom class that provides the
     * association(foreign key)
     * </p>
     */
    @OneToMany(mappedBy = "pk.room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemMaxAllotmentForRoom> itemMaxAllotmentForRooms = new HashSet<ItemMaxAllotmentForRoom>();

    /**
     * A set of DemandHistory for this room.
     */
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DemandHistory> demandHistory = new HashSet<DemandHistory>();

    /**
     * This empty constructor is required by hibernate binding mechanism.
     */
    public Room() {
    }

    /**
     * Constructor.
     *
     * @param roomId a room ID.
     * @param roomName a room name.
     */
    public Room(int roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<ItemMaxAllotmentForRoom> getItemMaxAllotmentForRooms() {
        return this.itemMaxAllotmentForRooms;
    }

    public void setItemMaxAllotmentForRooms(Set<ItemMaxAllotmentForRoom> itemMaxAllotmentForRooms) {
        this.itemMaxAllotmentForRooms = itemMaxAllotmentForRooms;
    }

    public void addItemMaxAllotmentForRoom(ItemMaxAllotmentForRoom itemAllotmentForRoom) {
        itemAllotmentForRoom.setRoom(this);
        getItemMaxAllotmentForRooms().add(itemAllotmentForRoom);
    }

    public void removeItemMaxAllotmentForRoom(ItemMaxAllotmentForRoom itemAllotmentForRoom) {
        getItemMaxAllotmentForRooms().remove(itemAllotmentForRoom);
    }

    public Set<DemandHistory> getDemandHistory() {
        return demandHistory;
    }

    public void setDemandHistory(Set<DemandHistory> demandHistory) {
        this.demandHistory = demandHistory;
    }

    public void addADemandHistory(DemandHistory demandHistory) {
        demandHistory.setRoom(this);
        getDemandHistory().add(demandHistory);
    }

    public void removeADemandHistory(DemandHistory demandHistory) {
        getDemandHistory().remove(demandHistory);
    }

}
