package com.padwan.test.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.padwan.test.domain.Jedi;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.interfaces.IJediStatusCount;
import com.padwan.test.interfaces.JediServiceInterface;
import com.padwan.test.repository.JediRepository;

@Service
public class JediService implements JediServiceInterface {
	
	private final JediRepository repository;
	
	private final ModelMapper mapper;
	
	public JediService(JediRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<JediDTO> listJediMastersAndApprentices() {
		
		List<Jedi> jediRetorno = repository.listJediMastersAndApprentices();
		
		return mapper.map(jediRetorno, new TypeToken<List<JediDTO>>() {}.getType());
	}

	@Override
	public List<JediDTO> listJedisMidichloriansOver9000() {
		
		List<Jedi> jediRetorno = repository.listJedisMidichloriansOver9000();
		
		return mapper.map(jediRetorno, new TypeToken<List<JediDTO>>() {}.getType());
		
	}

	@Override
	public List<IJediStatusCount> listJediStatusCount() {
		
		List<IJediStatusCount> jediRetorno = repository.listJediStatusCount();
		
		return jediRetorno;
		
	}

	@Override
	public JediDTO createJedi(JediDTO jedi) {
		
		Jedi jediSalvar = mapper.map(jedi, Jedi.class);
		
		Jedi vagaRetorno = repository.save(jediSalvar);
		
		return mapper.map(vagaRetorno, JediDTO.class); 
	}

}
