package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoServicesImp implements DemoServices {
	
	@Autowired
	private final DemoRepository demoRepository;
	
	public DemoServicesImp() {
		this.demoRepository = null;
	}

	//constructor based dependency injection
	public DemoServicesImp(DemoRepository demoRepository) {
		super();
		this.demoRepository = demoRepository;
	}
	
	@Override
	public Demo save(Demo demo) {
		return demoRepository.save(demo);
	}
	
	@Override
	public List<Demo> getAllDemo(int id) {
	if(id != 0)
		return demoRepository.search(id);
	else 
		return demoRepository.findAll();
	}
	
	public Demo getDemoById(int id) {
		return demoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "id", id));
	}
	
	@Override
	public void deleteDemoById(int id) {
	 demoRepository.deleteById(id);
	}
	
	@Override
	public Page<Demo> findPaginated(int pageNo,int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending():Sort.by(sortField).descending();
		
		Pageable pageable = (Pageable) PageRequest.of(pageNo - 1, pageSize,sort);
		return demoRepository.findAll(pageable);
	}

	@Override
	public String findPaginated(int pageNo, String string, String sortField, Demo demo) {
		return null;
	}

}