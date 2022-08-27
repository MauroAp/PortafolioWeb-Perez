/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Service;

import com.porfolio.perez.Entity.IDescripcion;
import com.porfolio.perez.Repository.RDescripcion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SDescripcion {
    
    @Autowired
    RDescripcion rDescripcion;
    
    public List<IDescripcion> list(){
        return rDescripcion.findAll();
    }
    
    public Optional<IDescripcion> getOne(int id){
        return rDescripcion.findById(id);
    }
    public Optional<IDescripcion> getByNombreE(String nombreE){
        return rDescripcion.findByNombreE(nombreE);
    }
    
    public void save(IDescripcion descripcion){
       rDescripcion.save(descripcion); 
    }
    
   public void delete(int id){
       rDescripcion.deleteById(id);
   }
   public boolean existsById(int id){
       return rDescripcion.existsById(id);
   }
   
   public boolean existsByNombreE(String nombreE){
       return rDescripcion.existsByNombreE(nombreE);
   }
}
