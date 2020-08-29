package com.example.digifarm.services;

import com.example.digifarm.repository.entity.Produce;
import com.example.digifarm.wrapper.ResponseWrapper;

import java.util.List;
import java.util.UUID;

public interface ProduceService {
    ResponseWrapper<Produce> saveProduce(Produce produce);
    ResponseWrapper<List<Produce>> getAllProduce();
    ResponseWrapper<Produce> getProduce(UUID uuid);
}
