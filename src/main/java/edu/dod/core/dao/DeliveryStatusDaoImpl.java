package edu.dod.core.dao;

import edu.dod.core.domain.DeliveryStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Implementation of the {@link edu.dod.core.dao.DeliveryStatusDao}.
 *
 * @author sky
 * @version 140506
 */
@Transactional
@Repository("DeliveryStatusDao")
public class DeliveryStatusDaoImpl implements DeliveryStatusDao{

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
	public Collection<DeliveryStatus> findAll() {
		Session session = my_sessionFactory.getCurrentSession();
		return session.createQuery("from DeliveryStatus d").list();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public DeliveryStatus findById(int demandId) {
		Session session = my_sessionFactory.getCurrentSession();
		return (DeliveryStatus) session.getNamedQuery("DeliveryStatus.findById")
				.setParameter("id", demandId).uniqueResult();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public DeliveryStatus update(DeliveryStatus deliveryStatus) {
		Session session = my_sessionFactory.getCurrentSession();
		session.saveOrUpdate(deliveryStatus);
		return deliveryStatus;
	}

}
