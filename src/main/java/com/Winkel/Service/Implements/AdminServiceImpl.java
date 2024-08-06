package com.Winkel.Service.Implements;

import com.Winkel.Dto.AdminDto;
import com.Winkel.Model.Admin;
import com.Winkel.Repository.AdminRepository;
import com.Winkel.Repository.RoleRepository;
import com.Winkel.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDto adminDto) {
       Admin admin = new Admin();
       admin.setFirstName(admin.getFirstName());
       admin.setLastName(admin.getLastName());
       admin.setUserName(admin.getUserName());
       admin.setPassword(admin.getPassword());
       admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}
