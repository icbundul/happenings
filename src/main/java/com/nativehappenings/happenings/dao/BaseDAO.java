package com.nativehappenings.happenings.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class BaseDAO<T, TD extends Serializable> extends GenericDAOImpl<T, TD> {
}
