package com.imooc.aop.dao;

import com.imooc.aop.domain.Product;

public interface ProductDao{// extends JpaRepository<Product,Long> {
    public Product findById(Long id);
    
    public Product save1(Long id);
    
    public Product delete1(Long id);
}
