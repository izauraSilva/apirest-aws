package br.com.izatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.izatec.converter.DozerConverter;
import br.com.izatec.data.vo.ProductVO;
import br.com.izatec.exception.ResourceNotFoundException;
import br.com.izatec.repository.ProductRepository;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<ProductVO> listAll() {
        return DozerConverter.parseListObjects(repo.findAll(), ProductVO.class);
    }
     
    public ProductVO get(Integer id) throws ResourceNotFoundException {
    	var entity = repo.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("no record found"));
        return DozerConverter.parseObject(entity, ProductVO.class);
    }
    
    /*public void save(Product product) {
        repo.save(product);
    }*/
     
    /*public Product get(Integer id) {
        return repo.findById(id).get();
    }*/
     
   /* public void delete(Integer id) {
        repo.deleteById(id);
    }*/
}
