package org.nedesona.utils;

import org.nedesona.domain.Zip;
import org.nedesona.service.ZipManager;
import org.springframework.beans.factory.annotation.Autowired;

public class ZipSearch {
	
	@Autowired
	private ZipManager zipManager;
	
	public void  search(String zipcode){
		
		Zip zip = zipManager.findByZip(zipcode);
		System.out.println("show: lat:"+zip.getLatitude()+"  long:"+zip.getLongitude());
	}
	
	
	public static void main(String [ ] args)
	{	String zip = "35004";
		ZipSearch zs = new ZipSearch();
	      zs.search(zip);
	}
}
