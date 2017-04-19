package com.pelotonbook.models.data;

import com.pelotonbook.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Kevin on 4/17/2017.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
}
