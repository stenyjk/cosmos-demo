package com.example.cosmos.cosmosdemo.repo;

import com.example.cosmos.cosmosdemo.model.Employee;
import com.example.cosmos.cosmosdemo.model.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends CosmosRepository<Employee, String> {
	/*
	 * Flux<User> findByFirstName(String firstName); Flux<User>
	 * findByDepartment(String department);
	 */}
