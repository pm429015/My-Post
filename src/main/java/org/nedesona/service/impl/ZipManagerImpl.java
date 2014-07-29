package org.nedesona.service.impl;

import java.util.List;

import org.nedesona.dao.ZipDao;
import org.nedesona.domain.Zip;
import org.nedesona.service.ZipManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipManagerImpl implements ZipManager{
	@Autowired
	private ZipDao zipDao;
	
	@Override
	public Zip findByZip(String id) {
		return zipDao.findByZip(id);
	}

	@Override
	public List<Zip> searchZips(double maxLat, double minLat, double maxLon, double minLon) {
		return zipDao.searchZips(maxLat, minLat, maxLon, minLon);
	}
	
}
