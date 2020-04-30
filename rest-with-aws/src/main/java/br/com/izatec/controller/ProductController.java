package br.com.izatec.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.izatec.data.vo.ProductVO;
import br.com.izatec.exception.ResourceNotFoundException;
import br.com.izatec.exception.UnsuportedOperationException;
import br.com.izatec.request.converters.NumberConverter;
import br.com.izatec.service.ProductService;

@RestController
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    @GetMapping("/products")
    public List<ProductVO> list() {
        return service.listAll();
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductVO> get(@PathVariable String id) throws NumberFormatException, ResourceNotFoundException {

    	if (!NumberConverter.isNumeric(id)) {
    		throw new UnsuportedOperationException("Please set a numeric value");
    	}

    	try {
    		var product = service.get(Integer.valueOf(id)); 
    		return new ResponseEntity<ProductVO>(product, HttpStatus.OK);
    	} catch (NoSuchElementException e) {
    		return new ResponseEntity<ProductVO>(HttpStatus.NOT_FOUND);
    	}      
    }
   
    /*@PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }*/
    
    /*@PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }*/
    
    /*@DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/
    
}