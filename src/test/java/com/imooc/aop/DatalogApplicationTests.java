package com.imooc.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.aop.dao.ProductDao;
import com.imooc.aop.datalog.ActionDao;
import com.imooc.aop.datalog.DatalogAspect;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatalogApplicationTests {

	@Autowired(required=false)
	ProductDao productDao;
	@Autowired(required=false)
	ActionDao actionDao;
	@Autowired(required=false)
	DatalogAspect datalogAspect;

	@Test
	public void testInsert() {
		productDao.save1(1235L);
		System.out.println("new product id:+product.getId()");
	}

	/*@Test
	public void testUpdate(){
		Product product = productDao.findOne(1L);
		product.setName("test-update");
		product.setBuyPrice(new BigDecimal("23.5"));
		product.setOnlineTime(new Date());
		productDao.save(product);
	}

	@Test
	public void testDelete(){
		productDao.delete(1L);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	Product[] ss = {new Product()};
    	System.out.println(ss.length);
	}*/

}
