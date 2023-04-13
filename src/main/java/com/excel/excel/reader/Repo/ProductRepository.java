package com.excel.excel.reader.Repo;

import com.excel.excel.reader.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String>
{
}
