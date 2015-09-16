package com.donc.controllers;

import com.donc.dto.TestTableDTO;
import com.donc.entities.TestTable;
import com.donc.exceptions.NotFoundException;
import com.donc.repo.TestTableRepo;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by donovan on 15/09/16.
 */
@RestController
@RequestMapping("/testtable")
public class TestTableController {

    @Autowired
    private TestTableRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TestTableDTO>> getTestTable() {
        List<TestTable> tt = repo.findAll();
        if (tt==null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        List<TestTableDTO> dtos = new ArrayList<>();
        tt.forEach(testTable -> dtos.add(new TestTableDTO(testTable.getId(), testTable.getText())));
        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<TestTableDTO> getTestTable(@PathVariable int id) {

        TestTable tt = repo.findOne(id);
        if (tt==null) {
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            throw new NotFoundException(id);
        }
        TestTableDTO dto = new TestTableDTO();
        dto.setId(tt.getId());
        dto.setText(tt.getText());
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TestTableDTO> deleteTestTable(@PathVariable int id) {
        repo.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<TestTableDTO> createTestTable(@RequestBody TestTableDTO dto, UriComponentsBuilder ucb) {
        TestTable tt = new TestTable();
        tt.setText(dto.getText());
        repo.save(tt);
        dto.setId(tt.getId());

        HttpHeaders headers = new HttpHeaders();
        URI location = ucb.path("/testtable/").path(String.valueOf(tt.getId())).build().toUri();
        headers.setLocation(location);

        return new ResponseEntity(dto, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<TestTableDTO> updateTestTable(@RequestBody TestTableDTO dto, UriComponentsBuilder ucb) {
        TestTable tt = repo.findOne(dto.getId());
        tt.setText(dto.getText());
        repo.save(tt);

        HttpHeaders headers = new HttpHeaders();
        URI location = ucb.path("/testtable/").path(String.valueOf(tt.getId())).build().toUri();
        headers.setLocation(location);

        return new ResponseEntity(dto, headers, HttpStatus.CREATED);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> entityNotFound(NotFoundException e) {
        Error error = new Error("TestTable not for for id " + e.getId());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


}
