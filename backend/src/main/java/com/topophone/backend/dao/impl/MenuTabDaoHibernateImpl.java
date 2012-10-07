package com.topophone.backend.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.topophone.backend.bean.MenuTab;
import com.topophone.backend.dao.MenuTabDao;

public class MenuTabDaoHibernateImpl implements MenuTabDao {

	@Inject
	private final EntityManager entityManager;

	@Inject
	private MenuTabDaoHibernateImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MenuTab> getMenuTabs() {
		 final Query query = entityManager.createQuery("SELECT e FROM MenuTab e");
		 return (List<MenuTab>) query.getResultList();
	}
}
