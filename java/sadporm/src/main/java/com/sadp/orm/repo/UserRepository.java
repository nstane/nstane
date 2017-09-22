/**
 * 
 */
package com.sadp.orm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadp.orm.dto.User;


/**
 * @author ntanwa
 *
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	List<User> findAll();
}
