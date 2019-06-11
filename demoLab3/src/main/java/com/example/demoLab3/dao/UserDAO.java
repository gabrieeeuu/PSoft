package main.java.com.example.demoLab3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demoLab3.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

    @Query(value="Select u from User u where u.login=plogin")
    User findByLogin(@Param("plogin") String login);
}