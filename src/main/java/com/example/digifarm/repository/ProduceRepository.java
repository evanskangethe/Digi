package com.example.digifarm.repository;

import com.example.digifarm.repository.entity.Produce;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProduceRepository extends CassandraRepository<Produce, UUID> {
}
