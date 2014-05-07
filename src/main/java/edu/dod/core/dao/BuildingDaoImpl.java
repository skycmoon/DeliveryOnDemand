package edu.dod.core.dao;

import edu.dod.core.domain.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Implementation of the {@link edu.dod.core.dao.BuildingDao}.
 *
 * @author sky
 * @version 140506
 */
@Transactional
@Repository("BuildingDao")
public class BuildingDaoImpl implements BuildingDao {

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
	public List<Building> findAll() {
		Session session = my_sessionFactory.getCurrentSession();
		return session.createQuery("from Building b").list();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Building findById(String building_id) {
		Session session = my_sessionFactory.getCurrentSession();
		return (Building) session.getNamedQuery("Building.findById")
				.setParameter("id", building_id).uniqueResult();
	}

}
