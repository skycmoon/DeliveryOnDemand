package edu.dod.core.dao;

import edu.dod.core.domain.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Implementation of the {@link edu.dod.core.dao.ItemDao}.
 *
 * @author sky
 * @version 140506
 */
@Transactional
@Repository("ItemDao")
public class ItemDaoImpl implements ItemDao {

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
	public List<Item> findAll() {
		Session session = my_sessionFactory.getCurrentSession();
		return session.createQuery("from Item i").list();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Item findById(int itemId) {
		Session session = my_sessionFactory.getCurrentSession();
		return (Item) session.getNamedQuery("Item.findById")
				.setParameter("id", itemId).uniqueResult();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Item update(Item item) {
		Session session = my_sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
		return item;
	}

}
