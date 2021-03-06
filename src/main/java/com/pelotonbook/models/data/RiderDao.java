package com.pelotonbook.models.data;

import com.pelotonbook.models.Rider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Kevin on 4/17/2017.
 */
@Repository
@Transactional
public interface RiderDao extends CrudRepository<Rider, Integer> {
}
