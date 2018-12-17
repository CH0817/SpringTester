package tw.com.rex.springtester.dao;

import org.springframework.data.repository.CrudRepository;
import tw.com.rex.springtester.model.dao.User;

public interface UserDao extends CrudRepository<User, Long> {}
