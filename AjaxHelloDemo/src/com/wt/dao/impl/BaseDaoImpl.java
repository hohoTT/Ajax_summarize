package com.wt.dao.impl;

import java.util.List;

import com.wt.beans.Location;
import com.wt.dao.BaseDao;

public class BaseDaoImpl implements BaseDao{

	@Override
	public List<Location> getForList(String sql) {
		
//		List locations = getHibernateTemplate().find(sql);
//		
//		return locations;
		
		return null;
	}

}
