package com.example.sakshi.service;

import org.springframework.beans.factory.annotation.Autowired;  // Importing the Autowired annotation for dependency injection
import org.springframework.stereotype.Service;        //Importing the Service annotation to mark this class as a service layer component
import com.example.sakshi.model.Supplier;       // Importing the Supplier model to work with Supplier objects
import com.example.sakshi.Repository.copy.*;     // Importing the SupplierRepository interface to interact with the database

import java.util.List;        // Importing List to work with lists of suppliers


//The @Service annotation marks this class as a service component in Spring
@Service
public class SupplierService {

	// Autowiring the SupplierRepository, which allows Spring to automatically inject the repository dependency
    @Autowired
    private SupplierRepository supplierRepository;

    
 // Method to fetch all suppliers from the database
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();       //returning method from another file that has findAll() method.
    }


    // Method to save a supplier to the database
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
