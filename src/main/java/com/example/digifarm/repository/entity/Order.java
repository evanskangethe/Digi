package com.example.digifarm.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Table(value = "ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @PrimaryKey
    private UUID merchantId= UUID.randomUUID();
    private UUID userId;
    private String produceIds;
    private LocalDate creationDate= LocalDate.now();
}
