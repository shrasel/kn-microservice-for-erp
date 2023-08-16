package com.kinbenaki.ordermicroservice.Repository;

import com.kinbenaki.ordermicroservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
