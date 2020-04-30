package br.com.izatec.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.izatec.data.vo.ProductVO;
import br.com.izatec.entity.Product;

public class MockProduct {

	public Product mockEntity() {
		return mockEntity(0);
	}

	public ProductVO mockVO() {
		return mockVO(0);
	}

	public List<Product> mockEntityList() {
		List<Product> persons = new ArrayList<Product>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}

	public List<ProductVO> mockVOList() {
		List<ProductVO> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockVO(i));
		}
		return persons;
	}

	private Product mockEntity(Integer number) {
		Product product = new Product();
		product.setId(number);
		product.setName("product " + number);
		product.setPrice((float) 1.0);
		return product;
	}

	private ProductVO mockVO(Integer number) {
		ProductVO vo = new ProductVO();
		vo.setId(number);
		vo.setName("product A");
		vo.setPrice((float) 1.0);
		return vo;
	}

}
