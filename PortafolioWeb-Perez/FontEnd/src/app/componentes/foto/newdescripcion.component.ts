import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Descripcion } from 'src/app/model/descripcion';
import { DescripcionService } from 'src/app/service/descripcion.service';

@Component({
  selector: 'app-newdescripcion',
  templateUrl: './newdescripcion.component.html',
  styleUrls: ['./newdescripcion.component.css']
})
export class NewdescripcionComponent implements OnInit {
  nombreE: string;
  descripcionE: string;

  constructor(private descripcionS: DescripcionService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const descripcion = new Descripcion(this.nombreE, this.descripcionE);
    this.descripcionS.save(descripcion).subscribe(
      data =>{
        alert("Descripcion añadida correctamente");
        this.router.navigate([''])
      }, err =>{
        alert("fallo");
        this.router.navigate([''])
      }
    )
  }

}
