import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DueñoService } from 'src/app/service/dueño.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregareditarusuario',
  templateUrl: './agregareditarusuario.component.html',
  styleUrls: ['./agregareditarusuario.component.css']
})
export class AgregareditarusuarioComponent implements OnInit {

  tipodocumento: string[] = ['C.C', 'C.E', 'PASAPORTE'];


  formUsuario!: FormGroup;
  operacion: string = 'Agregar '
  id: any | undefined;

  constructor(private fb: FormBuilder, private dueño: DueñoService, public dialogRef: MatDialogRef<AgregareditarusuarioComponent>, private _snackBar: MatSnackBar,
    @Inject(MAT_DIALOG_DATA) public data: any) {
    this.construirFormulario();
    this.id = data.id
  }

  ngOnInit(): void {
    this.editar(this.id);
  }

  editar(id: any | undefined) {
    if (id !== undefined) {
      this.operacion = 'Editar '
      this.getUsuario(id);
    }
  }

  cancelar() {
    this.dialogRef.close();
  }

  getUsuario(res: any) {
    console.log(res)
    this.formUsuario.setValue({
      idpropietario: res.idpropietario,
      tipoid: res.tipoid,
      nombre: res.nombre,
      ciudad: res.ciudad,
      direccion: res.direccion,
      telefono: res.telefono
    })
  }

  construirFormulario() {
    this.formUsuario = this.fb.group({
      idpropietario: [null, Validators.required],
      tipoid: [null, Validators.required],
      nombre: [null, Validators.required],
      ciudad: [null, Validators.required],
      direccion: [null, Validators.required],
      telefono: [null, Validators.required]
    })
  }

  guardar() {
    //Agregar
    const datos = this.formUsuario.value;
    this.dueño.getGuardarDueño(datos).subscribe()
    console.log('Datos de mi formulario: ', datos);
  }

  guardaroactualizar() {

    if (this.id == undefined) {
      //Agregar
      this.guardar();
      this._snackBar.open("El cliente fue agregado con exito!", '', {
        duration: 2000
      });
      Swal.fire(
        'Cliente Agregado con EXITO!', '',
      )
      location.reload()
    } else {
      //Editar
      const datos = this.formUsuario.value;
      this.dueño.editarDueño(datos).subscribe()
      console.log('Datos de mi formulario: ', datos);
      this._snackBar.open("El cliente fue actualizado con exito!", '', {
        duration: 2000
      });
      location.reload()
    }

    this.dialogRef.close();
  }

}
