package com.pelotonbook.models.data;


import com.pelotonbook.models.RaceDayEntity;
import com.pelotonbook.models.Rider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Kevin on 4/30/2017.
 */
@Repository
@Transactional
public interface RaceDayDao extends CrudRepository<RaceDayEntity, Integer> {
}