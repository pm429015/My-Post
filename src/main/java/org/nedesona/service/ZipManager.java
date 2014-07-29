package org.nedesona.service;

import java.util.List;

import org.nedesona.domain.Zip;


public interface ZipManager {

	Zip findByZip(String id);
	
	List<Zip> searchZips(double maxLat, double minLat, double maxLon, double minLon);
	
}
