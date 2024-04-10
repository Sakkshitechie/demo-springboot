package com.example.demo.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Demo;
public interface DemoRepository extends JpaRepository<Demo, Integer> {
	//JPQL Query
	@Query("SELECT demo FROM Demo demo WHERE CONCAT(demo.id, ' ', demo.name, ' ', demo.description, ' ', demo.price)LIKE %?1%")
	public List<Demo> getAllDemo(int id);
	public List<Demo> search(int id);
	public List<Demo> findByname(String name);
	public Page<Demo> findAll(Pageable pageable);
	public List<Demo> findAll();
}