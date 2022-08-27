/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Service;

import com.porfolio.perez.Entity.DatosP;
import com.porfolio.perez.Repository.RDatosP;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Perez Mauro
 */
@Service
@Transactional
public class SDatosP {
       
    @Autowired
    RDatosP rDatosP;
    
    
    public List<DatosP> list(){
        return rDatosP.findAll();
    }
    
    public Optional<DatosP> getOne(int id){
        return rDatosP.findById(id);
    }
    public Optional<DatosP> getByNombreP(String nombreP){
        return rDatosP.findByNombreP(nombreP);
    }
    
    public void save(DatosP datosP){
       rDatosP.save(datosP); 
    }
    
   public void delete(int id){
       rDatosP.deleteById(id);
   }
   public boolean existsById(int id){
       return rDatosP.existsById(id);
   }
   
   public boolean existsByNombreP(String nombreP){
       return rDatosP.existsByNombreP(nombreP);
   }
}

