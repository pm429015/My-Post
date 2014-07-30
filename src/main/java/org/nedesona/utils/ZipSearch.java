package org.nedesona.utils;

import java.util.ArrayList;
import java.util.List;

import org.nedesona.domain.Zip;
import org.nedesona.service.ZipManager;
import org.springframework.beans.factory.annotation.Autowired;

public class ZipSearch {
	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public static List<Double> search(Double lat, Double lon, Double distance) {
		// compute max and min latitudes / longitudes for search square

		Double radius = 3959.0;
		
		List<Double> minMaxDist = new ArrayList<Double>();
//		Double latMax = rad2deg(Math.asin(Math.sin(deg2rad(lat)))
//				* Math.cos(distance / radius) + Math.cos(deg2rad(lat))
//				* Math.sin(distance / radius) * Math.cos(deg2rad(0)));
		
		Double latMax = Math.toDegrees( Math.asin(
	            Math.sin(Math.toRadians(lat)) * Math.cos(distance/radius) + 
	            Math.cos(Math.toRadians(lat)) * Math.sin(distance/radius) * Math.cos(Math.toRadians(0))) );
		

		Double latMin = Math.toDegrees( Math.asin(
	            Math.sin(Math.toRadians(lat)) * Math.cos(distance/radius) + 
	            Math.cos(Math.toRadians(lat)) * Math.sin(distance/radius) * Math.cos(Math.toRadians(180))));


		Double lonMax = rad2deg(deg2rad(lon)
				+ Math.atan2(
						Math.sin(deg2rad(90)) * Math.sin(distance / radius)
								* Math.cos(deg2rad(lat)),
						Math.cos(distance / radius) - Math.sin(deg2rad(lat))
								* Math.sin(deg2rad(latMax))));

		Double lonMin = rad2deg(deg2rad(lon)
				+ Math.atan2(
						Math.sin(deg2rad(270)) * Math.sin(distance / radius)
								* Math.cos(deg2rad(lat)),
						Math.cos(distance / radius) - Math.sin(deg2rad(lat))
								* Math.sin(deg2rad(latMax))));
		minMaxDist.add(latMax);
		minMaxDist.add(latMin);
		minMaxDist.add(lonMax);
		minMaxDist.add(lonMin);
		
		System.out.println(latMax+" "+latMin+" "+lonMax+" "+lonMin);
		
				return minMaxDist;
	}
	
	public static void main(String [ ] args){
		ZipSearch.search(38.007898, -84.534520, 5.0);
	}
	
}
