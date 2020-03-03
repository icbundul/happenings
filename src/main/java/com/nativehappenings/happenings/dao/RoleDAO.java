package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.ERole;
import com.nativehappenings.happenings.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
