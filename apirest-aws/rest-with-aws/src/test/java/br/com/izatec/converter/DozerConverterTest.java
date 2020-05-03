package br.com.izatec.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.izatec.converter.mocks.MockProduct;
import br.com.izatec.data.vo.ProductVO;
import br.com.izatec.entity.Product;


public class DozerConverterTest {

	MockProduct inputObject;

	@Before
	public void setUp() {
		inputObject = new MockProduct();
	}

	@Test
	public void parseEntityToVOTest() {
		ProductVO output = DozerConverter.parseObject(inputObject.mockEntity(), ProductVO.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Name ", output.getName());
		Assert.assertEquals("Price ", output.getPrice());	       
	}

	@Test
	public void parseEntityListToVOListTest() {	       
		List<ProductVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), ProductVO.class);
		ProductVO outputZero = outputList.get(0);	        
		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("Name ", outputZero.getName());
		Assert.assertEquals("Price ", outputZero.getPrice());
	}

	@Test
	public void parseVOToEntityTest() {
		Product output = DozerConverter.parseObject(inputObject.mockVO(), Product.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Name ", output.getName());
		Assert.assertEquals("Price ", output.getPrice());
	}

	@Test
	public void parserVOListToEntityListTest() {
		List<Product> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Product.class);
		Product outputZero = outputList.get(0);	        
		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("Name ", outputZero.getName());
		Assert.assertEquals("Price ", outputZero.getPrice());      
	}

}
