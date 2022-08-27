import { Component, OnInit } from '@angular/core';
import { Descripcion } from 'src/app/model/descripcion';
import { DescripcionService } from 'src/app/service/descripcion.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-foto',
  templateUrl: './descripcion.component.html',
  styleUrls: ['./descripcion.component.css']
})
export class FotoComponent implements OnInit {

  descripcion: Descripcion[]=[];
 
  constructor(private descripcionS: DescripcionService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarDescripcion();
    if(this.tokenService.getToken()){
      this.isLogged =true;
    } else{
      this.isLogged = false;
    }

  }

  cargarDescripcion(): void{
    this.descripcionS.lista().subscribe(
      data =>{
        this.descripcion = data;
      }
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.descripcionS.delete(id).subscribe(
        data =>{
          this.cargarDescripcion();
        }, err => {
          alert("No se pudo eliminar");
        }
      )
    }
  }
}