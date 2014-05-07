package edu.dod.core.dao;

import edu.dod.core.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Implementation of the {@link edu.dod.core.domain.Room}.
 *
 * @author sky
 * @version 140506
 */
@Transactional
@Repository("RoomDao")
public class RoomDaoImpl implements RoomDao{

    /**
     * SessionFactory object which connects the application to the database.
     */
	private SessionFactory my_sessionFactory;

    /**
     * Setter for the SessionFactory.
     *
     * @param sessionFactory a SessionFactory.
     */
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		my_sessionFactory = sessionFactory;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public List<Room> findAllRooms() {
		Session session = my_sessionFactory.getCurrentSession();
		return session.createQuery("from Room r").list();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Room findById(int roomId) {
		Session session = my_sessionFactory.getCurrentSession();
		return (Room) session.getNamedQuery("Room.findById")
				.setParameter("id", roomId).uniqueResult();
	}

}
