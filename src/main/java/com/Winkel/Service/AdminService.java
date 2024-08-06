package com.Winkel.Service;

import com.Winkel.Dto.AdminDto;
import com.Winkel.Model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
