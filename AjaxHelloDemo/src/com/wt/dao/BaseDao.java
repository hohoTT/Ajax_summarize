package com.wt.dao;

import java.util.List;

import com.wt.beans.Location;

public interface BaseDao {

	public List<Location> getForList(String sql);
	
}
