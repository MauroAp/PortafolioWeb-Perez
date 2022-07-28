
package com.porfolio.perez.Interface;

import com.porfolio.perez.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto pero lo busca por id
    public void deletePersona(Long id);
    
    //buscar una persona
    public Persona findPersona(Long id);
    
}
