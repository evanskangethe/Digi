package com.example.digifarm.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Table(value = "PRODUCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produce {
    @PrimaryKey
    private UUID prodiceId= UUID.randomUUID();
    private String name;
    private String descriprion;
    private BigDecimal price;
    private UUID farmerId;
    private LocalDate creationDate= LocalDate.now();
}
