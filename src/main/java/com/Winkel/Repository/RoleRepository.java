package com.Winkel.Repository;

import com.Winkel.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role ,Long> {
    Role findByName(String name);
}
