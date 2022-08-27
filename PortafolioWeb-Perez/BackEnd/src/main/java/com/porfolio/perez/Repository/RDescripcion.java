/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Repository;

import com.porfolio.perez.Entity.IDescripcion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDescripcion extends JpaRepository<IDescripcion, Integer>{
    
    public Optional<IDescripcion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
