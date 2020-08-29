package com.example.digifarm.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table(value = "MERCHANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @PrimaryKey
    private UUID merchantId= UUID.randomUUID();
    private String username;
    private String password;
    private LocalDate creationDate= LocalDate.now();
}
