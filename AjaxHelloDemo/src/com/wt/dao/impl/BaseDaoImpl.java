package com.wt.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wt.beans.Location;
import com.wt.dao.BaseDao;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

	@Override
	public List<Location> getForList(String sql) {
		
		List locations = getHibernateTemplate().find(sql);
		
		return locations;
	}

}
