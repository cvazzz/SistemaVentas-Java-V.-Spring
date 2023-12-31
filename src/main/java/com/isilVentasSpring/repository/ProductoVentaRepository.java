package com.isilVentasSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isilVentasSpring.entity.CategoriaProducto;
import com.isilVentasSpring.entity.ProductoVenta;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta,Integer> {
	List<ProductoVenta> findByCategoria(CategoriaProducto categoriaProducto);
	ProductoVenta findByCodigo(int codigo);
	@Transactional
	void deleteByCodigo(int codigo);
}
