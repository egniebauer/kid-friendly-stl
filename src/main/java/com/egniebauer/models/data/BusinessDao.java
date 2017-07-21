package com.egniebauer.models.data;

import com.egniebauer.models.Business;
import com.egniebauer.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Elizabeth G Niebauer
 */

@Repository
@Transactional
public interface BusinessDao extends CrudRepository<Business, Integer> {
}
