package com.isilVentasSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isilVentasSpring.entity.CategoriaProducto;

/*Esta interface Repository nos va a permitir hacer los querys en la tabla de BD*/
@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto,Integer> {
	List<CategoriaProducto> findAll();
	CategoriaProducto findById(int id);
}
