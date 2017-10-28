package com.imooc.aop.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.imooc.aop.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save1(Long id) {
		// TODO Auto-generated method stub
		System.out.println("save1"+id);
		return null;
	}

	@Override
	public Product delete1(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
