/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Controller;

import com.porfolio.perez.Dto.dtoDatosP;
import com.porfolio.perez.Entity.DatosP;
import com.porfolio.perez.Security.Controller.Mensaje;
import com.porfolio.perez.Service.SDatosP;
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
@RequestMapping("/datosp")
@CrossOrigin (origins ="http:localhost:4200")
public class CDatosP {
    
   @Autowired
    
    SDatosP sDatosP;
    
     
    @GetMapping("/lista")
    public ResponseEntity<List<DatosP>> list(){
        List<DatosP> list = sDatosP.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<DatosP> getById(@PathVariable("id") int id){
        if(!sDatosP.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        DatosP datosP= sDatosP.getOne(id).get();
        return new ResponseEntity(datosP, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sDatosP.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sDatosP.delete(id);
        return new ResponseEntity(new Mensaje("A cerca de eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoDatosP dtodatosP){
        if(StringUtils.isBlank(dtodatosP.getNombreP())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sDatosP.existsByNombreP(dtodatosP.getNombreP())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        DatosP datosP = new DatosP(
                dtodatosP.getNombreP(), dtodatosP.getDescripcionP(),dtodatosP.getImgP()
        );
        sDatosP.save(datosP);
        return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDatosP dtodatosP){
        if(!sDatosP.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sDatosP.existsByNombreP(dtodatosP.getNombreP()) && sDatosP.getByNombreP(dtodatosP.getNombreP()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
            if(StringUtils.isBlank(dtodatosP.getNombreP())){
                return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
         }
            
            DatosP datosP=sDatosP.getOne(id).get();
            
            datosP.setNombreP(dtodatosP.getNombreP());
            datosP.setDescripcionP(dtodatosP.getDescripcionP());
            datosP.setDescripcionP(dtodatosP.getImgP());

            
            sDatosP.save(datosP);
            
            return new ResponseEntity(new Mensaje("Descripcion actualizada"), HttpStatus.OK);
            
   }
            
            
    
}

