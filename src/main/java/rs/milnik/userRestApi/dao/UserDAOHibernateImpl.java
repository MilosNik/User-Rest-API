package rs.milnik.userRestApi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rs.milnik.userRestApi.entity.User;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

	private EntityManager entityManager;

	@Autowired
	public UserDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<User> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		List<User> users = theQuery.getResultList();

		return users;

	}

	@Override
	public User findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		User theUser = currentSession.get(User.class, theId);

		return theUser;
	}

	@Override
	public void save(User theUser) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public void deleteById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from User where id=:userId");

		theQuery.setParameter("userId", theId);

		theQuery.executeUpdate();

	}

}
