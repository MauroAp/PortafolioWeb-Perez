/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Security.Service;

import com.porfolio.perez.Security.Entity.Rol;
import com.porfolio.perez.Security.Enums.RolNombre;
import com.porfolio.perez.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
      public void save(Rol rol){
          irolRepository.save(rol);
      }
}
