package com.babor.springbootall.repo;

import com.babor.springbootall.domain.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepository extends PagingAndSortingRepository<Staff,Integer> {
}
