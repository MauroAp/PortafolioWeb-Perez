/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.perez.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Perez Mauro
 */
public class dtoDatosP {
      
   @NotBlank
   private String nombreP;
   @NotBlank
   private String descripcionP;
   @NotBlank
    private String imgP;    

    public dtoDatosP() {
    }

    public dtoDatosP(String nombreP, String descripcionP, String imgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
   
   
}
