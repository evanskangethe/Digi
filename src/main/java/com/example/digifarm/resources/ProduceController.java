package com.example.digifarm.resources;

import com.example.digifarm.repository.entity.Produce;
import com.example.digifarm.services.impl.ProduceServiceImpl;
import com.example.digifarm.wrapper.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produce")
@RequiredArgsConstructor
public class ProduceController {

    private final ProduceServiceImpl produceService;

    /**
     * fetch all produce
     * @return
     */
    @GetMapping(value = "/fetch-all")
    public ResponseEntity<ResponseWrapper<Produce>> fetchAll() {
        return new ResponseEntity(produceService.getAllProduce(), HttpStatus.OK);
    }

    /**
     * fetch one produce
     * @param uuid
     * @return
     */
    @GetMapping(value = "/fetch/{id}")
    public ResponseEntity<ResponseWrapper<Produce>> fetchOne(@PathVariable("id") UUID uuid) {
        return new ResponseEntity(produceService.getProduce(uuid), HttpStatus.OK);
    }

    /**
     * Create produce
     * @param produce
     * @return
     */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseWrapper<Produce>> create(Produce produce) {
        return new ResponseEntity(produceService.saveProduce(produce), HttpStatus.OK);
    }

    /**
     * Update produce
     * @param produce
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<ResponseWrapper<Produce>> update(Produce produce) {
        return new ResponseEntity(produceService.saveProduce(produce), HttpStatus.OK);
    }

    /**
     * Delete produce
     * @param uuid
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseWrapper<Produce>> delete(UUID uuid) {
        return new ResponseEntity(produceService.deleteProduce(uuid), HttpStatus.OK);
    }
}
