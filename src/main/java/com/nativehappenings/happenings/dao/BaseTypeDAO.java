package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.BaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTypeDAO extends JpaRepository<BaseType, Long> {

}
