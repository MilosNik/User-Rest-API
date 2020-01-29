package rs.milnik.userRestApi.dao;

import java.util.List;

import rs.milnik.userRestApi.entity.User;

public interface UserDAO {

	public List<User> findAll();

	public User findById(int theId);

	public void save(User theUser);

	public void deleteById(int theId);

}
