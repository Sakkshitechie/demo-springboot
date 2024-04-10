package com.example.demo.services;

import com.example.demo.model.Demo;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface DemoServices {

    public Demo getDemoById(int id);
    public Demo save(Demo demo);
    void deleteDemoById(int id);
    public String findPaginated(int pageNo,String string, String sortField, Demo demo);
	public List<Demo> getAllDemo(int id);
	Page<Demo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}