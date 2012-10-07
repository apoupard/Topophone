package com.topophone.backend.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.topophone.backend.bean.MenuTab;
import com.topophone.backend.dao.impl.MenuTabDaoHibernateImpl;

@ImplementedBy(value=MenuTabDaoHibernateImpl.class)
public interface MenuTabDao {

	List<MenuTab> getMenuTabs();

}
