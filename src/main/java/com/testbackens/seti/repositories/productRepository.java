package com.testbackens.seti.repositories;

import com.testbackens.seti.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface productRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.* FROM product p " +
            "JOIN sucursal s ON p.sucursal_id = s.id " +
            "JOIN franquicia f ON s.franquicia_id = f.id " +
            "WHERE f.id = :franquiciaId AND p.stock = " +
            "(SELECT MAX(p2.stock) FROM product p2 WHERE p2.sucursal_id = s.id) " +
            "ORDER BY p.stock DESC", nativeQuery = true)
    List<Product> findTopProductsByStockPerSucursalForFranquicia(@Param("franquiciaId") Long franquiciaId);
}
