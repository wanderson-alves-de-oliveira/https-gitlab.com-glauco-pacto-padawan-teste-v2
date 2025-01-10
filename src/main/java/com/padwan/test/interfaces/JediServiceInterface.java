package com.padwan.test.interfaces;

import java.util.List;

import com.padwan.test.dto.JediDTO;

public interface JediServiceInterface {

	List<JediDTO> listJediMastersAndApprentices();

	List<JediDTO> listJedisMidichloriansOver9000();

	List<IJediStatusCount> listJediStatusCount();
	
	JediDTO createJedi(JediDTO jedi);
}
