package com.example.digifarm.repository;

import com.example.digifarm.repository.entity.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {
    @AllowFiltering
    User findByUsername(String username);
}
