package com.isilVentasSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isilVentasSpring.entity.ClienteEmpresa;

/*Esta interface Repository nos va a permitir hacer los querys en la tabla de BD*/
@Repository
public interface ClienteEmpresaRepository extends JpaRepository<ClienteEmpresa,Integer>{
	List<ClienteEmpresa> findAll();
	void deleteById(int codigo);
	ClienteEmpresa findById(int codigo);
	List<ClienteEmpresa> findByRucContainsAndCorreoContains(String ruc, String correo);
}
