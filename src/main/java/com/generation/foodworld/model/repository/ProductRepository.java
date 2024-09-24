package com.generation.foodworld.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.foodworld.model.entities.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> 
{

}