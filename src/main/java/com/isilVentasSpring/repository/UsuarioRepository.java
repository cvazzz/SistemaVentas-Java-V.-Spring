package com.isilVentasSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isilVentasSpring.entity.Usuario;

/*Esta interface Repository nos va a permitir hacer los querys en la tabla de BD*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	Usuario findByCorreoAndPassword(String correo, String password);
}
