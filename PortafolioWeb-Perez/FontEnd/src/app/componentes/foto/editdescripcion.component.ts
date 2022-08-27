import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Descripcion } from 'src/app/model/descripcion';
import { DescripcionService } from 'src/app/service/descripcion.service';

@Component({
  selector: 'app-editdescripcion',
  templateUrl: './editdescripcion.component.html',
  styleUrls: ['./editdescripcion.component.css']
})
export class EditdescripcionComponent implements OnInit {
  descripcion: Descripcion = null;
  
  constructor(
    private descripcionS: DescripcionService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id =this.activatedRouter.snapshot.params['id'];
    this.descripcionS.details(id).subscribe(
      data =>{
        this.descripcion = data;
      }, err =>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.descripcionS.update(id, this.descripcion).subscribe(
      data => {
        this.router.navigate([''])
      }, err =>{
        alert("Error al modificar la educacion");
        this.router.navigate([''])

      }
    )
  }

}