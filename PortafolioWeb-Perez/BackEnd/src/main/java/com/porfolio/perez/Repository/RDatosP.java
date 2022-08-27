/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Repository;

import com.porfolio.perez.Entity.DatosP;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Perez Mauro
 */
public interface RDatosP extends JpaRepository<DatosP, Integer>{
    
    public Optional<DatosP> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
    
}