
package com.porfolio.perez.Controller;

import com.porfolio.perez.Entity.Persona;
import com.porfolio.perez.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/persona/traer")
    public List<Persona>  getPersona(){
        return ipersonaService.getPersona();
        
    }
    
    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
        
    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/Persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
   
        ipersonaService.deletePersona(id);
       return "La persona fue eliminada correctamente";

    }  
    
    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre")String Nuevonombre,
                                @RequestParam("apellido")String Nuevoapellido,
                                @RequestParam("img")String Nuevoimg){
            Persona persona = ipersonaService.findPersona(id);
            
            persona.setNombre(Nuevonombre);
            persona.setApellido(Nuevoapellido);
            persona.setImg(Nuevoimg);
            
            return persona;
                    }
}    

  
