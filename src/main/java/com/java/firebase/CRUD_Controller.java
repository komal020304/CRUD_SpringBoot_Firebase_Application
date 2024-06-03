package com.java.firebase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CRUD_Controller {
    public CRUD_Service crudService;
    public CRUD_Controller(CRUD_Service crudService){
        this.crudService=crudService;
    }

    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD_operations crud) throws InterruptedException, ExecutionException {
        return crudService.createCRUD(crud);
    }

    @GetMapping("/get")
    public CRUD_operations getCRUD(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return crudService.getCRUD(documentId);
    }

    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD_operations crud) throws InterruptedException, ExecutionException {
        return crudService.updateCRUD(crud);
    }

    @PutMapping("/delete")
    public String deleteCRUD(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return crudService.deleteCRUD(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Test get endpoint is working");
    }
}


