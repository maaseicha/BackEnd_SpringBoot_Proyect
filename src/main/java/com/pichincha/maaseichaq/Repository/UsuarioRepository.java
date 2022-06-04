package com.pichincha.maaseichaq.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pichincha.maaseichaq.Entity.*;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public abstract Usuario findByCedula(String cedula);
    public  abstract Usuario findByEmail(String email);
}
