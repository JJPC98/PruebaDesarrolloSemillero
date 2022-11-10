import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { MascotaService } from 'src/app/service/mascota.service';
import { AgregareditarmascotaComponent } from './agregareditarmascota/agregareditarmascota.component';

@Component({
  selector: 'app-mascotas',
  templateUrl: './mascotas.component.html',
  styleUrls: ['./mascotas.component.css']
})
export class MascotasComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  displayedColumns: string[] = ['idmascota', 'nombre', 'especie', 'raza', 'fechanacimiento', 'dueño', 'fecharegistro', 'acciones'];
  dataSource: MatTableDataSource<any>;

  constructor(private mascota: MascotaService, public dialog: MatDialog, private _snackBar: MatSnackBar) {
    this.dataSource = new MatTableDataSource();
   }

  ngOnInit(): void {
    this.mostrarPacientes()
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  mostrarPacientes() {
    this.mascota.getMostrarMascotas().subscribe(data => {
      /* console.log(data); */
      this.dataSource = new MatTableDataSource(data.data);
       this.dataSource.paginator = this.paginator;
    })
  }

  addEditPaciente(id?: number) {
    /* console.log(id) */
    const dialogRef = this.dialog.open(AgregareditarmascotaComponent, {
      width: '550px',
      disableClose: true,
      data: { id: id }
    });
  }

  eliminarPaciente(id: any) {
    this.mascota.deleteMascota(id).subscribe(() => {
      this.mostrarPacientes();
      this.mensajeExito();
    })
  }

  mensajeExito() {
    this._snackBar.open("Mascota eliminada con exito!", '', {
      duration: 2000
    });
  }

}
