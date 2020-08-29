package com.example.digifarm.services.impl;

import com.example.digifarm.repository.ProduceRepository;
import com.example.digifarm.repository.entity.Produce;
import com.example.digifarm.services.ProduceService;
import com.example.digifarm.wrapper.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProduceServiceImpl implements ProduceService {

    private final ProduceRepository produceRepository;

    @Override
    public ResponseWrapper<Produce> saveProduce(Produce produce) {
        ResponseWrapper wrapper =new ResponseWrapper();
        wrapper.setData(produceRepository.save(produce));
        wrapper.setMessage("Produce created successfully");
        wrapper.setCode(HttpStatus.OK.value());
        return wrapper;
    }

    @Override
    public ResponseWrapper<List<Produce>> getAllProduce() {
        ResponseWrapper wrapper =new ResponseWrapper();
        wrapper.setData(produceRepository.findAll());
        wrapper.setMessage("Produce fetched successfully");
        wrapper.setCode(HttpStatus.OK.value());
        return wrapper;
    }

    @Override
    public ResponseWrapper<Optional<Produce>> getProduce(UUID uuid) {
        ResponseWrapper wrapper =new ResponseWrapper();
        wrapper.setData(produceRepository.findById(uuid));
        wrapper.setMessage("Produce fetched successfully");
        wrapper.setCode(HttpStatus.OK.value());
        return wrapper;
    }

    @Override
    public ResponseWrapper deleteProduce(UUID uuid) {
        ResponseWrapper wrapper =new ResponseWrapper();
        produceRepository.deleteById(uuid);
        wrapper.setMessage("Produce deleted successfully");
        wrapper.setCode(HttpStatus.OK.value());
        return wrapper;
    }
}
