import { DatePipe } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DateAdapter } from '@angular/material/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MascotaService } from 'src/app/service/mascota.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregareditarmascota',
  templateUrl: './agregareditarmascota.component.html',
  styleUrls: ['./agregareditarmascota.component.css']
})
export class AgregareditarmascotaComponent implements OnInit {

  maxDate: Date;
  especie: string[] = ['Perro', 'Gato'];
  formMascota!: FormGroup;
  operacion: string = 'Agregar '
  id: any | undefined;

  constructor(private fb: FormBuilder, private mascota: MascotaService, public dialogRef: MatDialogRef<AgregareditarmascotaComponent>, private _snackBar: MatSnackBar,
    @Inject(MAT_DIALOG_DATA) public data: any) {
    this.maxDate = new Date();
    this.construirFormularioMascota();
    this.id = data.id
  }

  ngOnInit(): void {
    this.editar(this.id)

  }

  editar(id: any | undefined) {
    if (id !== undefined) {
      this.operacion = 'Editar '
      this.getMascota(id);
    }
  }

  cancelar() {
    this.dialogRef.close();
  }

  getMascota(res: any) {
    console.log(res)
    this.formMascota.setValue({
      idmascota: res.idmascota,
      nombre: res.nombre,
      especie: res.especie,
      raza: res.raza,
      fechanacimiento: res.fechanacimiento,
      id_propietario: res.id_propietario,
      fecharegistro: res.fecharegistro
    })
  }

  construirFormularioMascota() {
    this.formMascota = this.fb.group({
      idmascota: [null, Validators.required],
      nombre: [null, Validators.required],
      especie: [null, Validators.required],
      raza: [null, Validators.required],
      fechanacimiento: [null, Validators.required],
      id_propietario: [null, Validators.required],
      fecharegistro: [null, Validators.required]
    })
  }

  guardar() {
    //Agregar
    const datos = this.formMascota.value;
    this.mascota.getGuardarMascota(datos).subscribe()
    console.log('Datos de mi formulario: ', datos);
  }

  guardaroactualizar() {

    if (this.id == undefined) {
      //Agregar
      this.guardar();
      this._snackBar.open("La mascota fue agregada con exito!", '', {
        duration: 2000
      });
      Swal.fire(
        'Mascota Agregada con EXITO!', '',
      )
      location.reload()
    } else {
      //Editar
      const datos = this.formMascota.value;
      this.mascota.editarMascota(datos).subscribe()
      console.log('Datos de mi formulario: ', datos);
      this._snackBar.open("La mascota fue actualizada con exito!", '', {
        duration: 2000
      });
      location.reload()
    }

    this.dialogRef.close();
  }

}

