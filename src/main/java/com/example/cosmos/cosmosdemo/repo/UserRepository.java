package com.example.cosmos.cosmosdemo.repo;

import org.springframework.stereotype.Repository;

import com.example.cosmos.cosmosdemo.model.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {

    //Flux<User> findByFirstName(String firstName);
}