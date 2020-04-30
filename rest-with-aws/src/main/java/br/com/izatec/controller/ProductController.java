package br.com.izatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.izatec.data.vo.ProductVO;
import br.com.izatec.service.ProductService;

@RestController
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    @GetMapping("/products")
    public List<ProductVO> list() {
        return service.listAll();
    }
    
    /*@GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable String id) {
    	
    	if (!NumberConverter.isNumeric(id)) {
    		throw new UnsuportedOperationException("Please set a numeric value");
    	}
    	
        try {
            Product product = service.get(Integer.valueOf(id));
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }*/
   
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