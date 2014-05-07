package edu.dod.core.dao;

import edu.dod.core.domain.DemandHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;

/**
 * Implementation of the {@link edu.dod.core.dao.DemandHistoryDao}.
 *
 * @author sky
 * @version 140506
 */
@Transactional
@Repository("DemandHistoryDao")
public class DemandHistoryDaoImpl implements DemandHistoryDao {

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
    @SuppressWarnings("unchecked")
	public Collection<DemandHistory> findAll() {
		Session session = my_sessionFactory.getCurrentSession();
		return session.createQuery("from DemandHistory").list();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public DemandHistory update(DemandHistory demandHistory) {
		Session session = my_sessionFactory.getCurrentSession();
		session.saveOrUpdate(demandHistory);
		return demandHistory;
	}

}
