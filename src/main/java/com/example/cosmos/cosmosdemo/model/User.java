package com.example.cosmos.cosmosdemo.model;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "User")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    private String id;
    
    private String firstName;
    @PartitionKey
    private String lastName;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s, %s", id, firstName, lastName, address, phone);
    }
}
