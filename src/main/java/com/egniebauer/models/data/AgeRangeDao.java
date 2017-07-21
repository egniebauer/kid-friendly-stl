package com.egniebauer.models.data;

import com.egniebauer.models.AgeRange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Elizabeth G Niebauer
 */

@Repository
@Transactional
public interface AgeRangeDao extends CrudRepository<AgeRange, Integer> {
}
