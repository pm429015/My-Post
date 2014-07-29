package org.nedesona.dao;

import java.util.List;

import org.nedesona.domain.Zip;


public interface ZipDao {

	Zip findByZip(String id);
	
	List<Zip> searchZips(double maxLat, double minLat, double maxLon, double minLon);
	
}
