/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Controller;

import com.porfolio.perez.Dto.dtoDescripcion;
import com.porfolio.perez.Entity.IDescripcion;
import com.porfolio.perez.Security.Controller.Mensaje;
import com.porfolio.perez.Service.SDescripcion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Perez Mauro
 */
@RestController
@RequestMapping("/descripcion")
@CrossOrigin (origins ="http:localhost:4200")

public class CDescripcion {
    @Autowired
    
    SDescripcion sDescripcion;
    
     
    @GetMapping("/lista")
    public ResponseEntity<List<IDescripcion>> list(){
        List<IDescripcion> list = sDescripcion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<IDescripcion> getById(@PathVariable("id") int id){
        if(!sDescripcion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        IDescripcion descripcion= sDescripcion.getOne(id).get();
        return new ResponseEntity(descripcion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sDescripcion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sDescripcion.delete(id);
        return new ResponseEntity(new Mensaje("A cerca de eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoDescripcion dtodescripcion){
        if(StringUtils.isBlank(dtodescripcion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sDescripcion.existsByNombreE(dtodescripcion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        IDescripcion descripcion = new IDescripcion(
                dtodescripcion.getNombreE(), dtodescripcion.getDescripcionE()
        );
        sDescripcion.save(descripcion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDescripcion dtodescripcion){
        if(!sDescripcion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sDescripcion.existsByNombreE(dtodescripcion.getNombreE()) && sDescripcion.getByNombreE(dtodescripcion.getNombreE()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
            if(StringUtils.isBlank(dtodescripcion.getNombreE())){
                return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
         }
            
            IDescripcion descripcion=sDescripcion.getOne(id).get();
            
            descripcion.setNombreE(dtodescripcion.getNombreE());
            descripcion.setDescripcionE(dtodescripcion.getDescripcionE());
            
            sDescripcion.save(descripcion);
            
            return new ResponseEntity(new Mensaje("Descripcion actualizada"), HttpStatus.OK);
            
   }
            
            
    
}
