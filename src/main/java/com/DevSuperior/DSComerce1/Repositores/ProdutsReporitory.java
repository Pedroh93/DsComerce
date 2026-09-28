package com.DevSuperior.DSComerce1.Repositores;

import com.DevSuperior.DSComerce1.Entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutsReporitory extends JpaRepository<Product,Long> {
}
