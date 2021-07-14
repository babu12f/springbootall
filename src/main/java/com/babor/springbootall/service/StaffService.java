package com.babor.springbootall.service;

import java.util.List;

import com.babor.springbootall.data.StaffRepository;
import com.babor.springbootall.models.StaffMember;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<StaffMember> getAllStaff(){
        return staffRepository.findAll();
    }
}