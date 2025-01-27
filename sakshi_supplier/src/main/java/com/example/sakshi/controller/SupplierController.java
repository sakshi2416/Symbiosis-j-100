package com.example.sakshi.controller;

//Importing necessary classes and annotations
import com.example.sakshi.model.Supplier;  // Importing the Supplier model class
import com.example.sakshi.Repository.copy.*;  // Importing the SupplierRepository class for database interactions
import org.springframework.beans.factory.annotation.Autowired;  // Importing the Autowired annotation for dependency injection
import org.springframework.web.bind.annotation.*;  // Importing Spring annotations for HTTP request mapping

import java.util.List;

//Marks the class as a REST controller that will handle HTTP requests
@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http:localhost:4200")
public class SupplierController {

	
// Dependency Injection of the SupplierRepository to access database operations
    @Autowired
    private SupplierRepository supplierRepository;

// Handle HTTP GET requests to retrieve all suppliers
    @GetMapping  // Maps this method to a GET request at "/api/suppliers"
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

 // Handle HTTP POST requests to add a new supplier
    @PostMapping    // Maps this method to a POST request at "/api/suppliers"
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

 // Handle HTTP DELETE requests to delete a supplier by its ID
    @DeleteMapping("/{id}")    // Maps this method to a DELETE request at "/api/suppliers/{id}"
    public void deleteSupplier(@PathVariable Long id) {
        supplierRepository.deleteById(id);
    }
}

