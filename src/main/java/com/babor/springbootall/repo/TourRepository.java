package com.babor.springbootall.repo;

import com.babor.springbootall.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
}
