package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CountryMasterDTO;
import com.aspl.org.entity.CountryMaster;
import com.aspl.org.repository.CountryRepository;
import com.aspl.org.service.CountryMasterService;

@Service
@Transactional
public class CountryMasterServiceImpl implements CountryMasterService {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<CountryMasterDTO> getAllCountry() {
		List<CountryMasterDTO> countrys = new ArrayList<>();
		try {
			List<CountryMaster> countryEntities = countryRepository.findAll();
			for(CountryMaster country : countryEntities) {
				CountryMasterDTO countryDTO = new CountryMasterDTO();
				countryDTO.setCountryCode(country.getCountryCode());
				countryDTO.setCountryName(country.getCountryName());
				countryDTO.setCountryId(country.getCountryId());
				countrys.add(countryDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return countrys;
	}

}
