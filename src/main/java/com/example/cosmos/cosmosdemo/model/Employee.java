package com.example.cosmos.cosmosdemo.model;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "employee")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    @Id
    private String id;
    
    private String firstName;
    private String lastName;
    @PartitionKey
    private String department;
    private String phone;

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s, %s", id, firstName, lastName, department, phone);
    }
}
