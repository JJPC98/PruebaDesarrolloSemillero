import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { DueñoService } from 'src/app/service/dueño.service';
import { AgregareditarusuarioComponent } from './agregareditarusuario/agregareditarusuario.component';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  displayedColumns: string[] = ['idpropietario', 'tipoid', 'nombre', 'ciudad', 'direccion', 'telefono', 'acciones'];
  dataSource: MatTableDataSource<any>;

  constructor(private dueño: DueñoService, public dialog: MatDialog, private _snackBar: MatSnackBar) {
    this.dataSource = new MatTableDataSource();
  }

  ngOnInit(): void {
    this.mostrar();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  mostrar() {
    this.dueño.getMostrarDueños().subscribe(data => {
    /*   console.log(data); */
      this.dataSource = new MatTableDataSource(data.data);
       this.dataSource.paginator = this.paginator;
    })
  }

  addEditUsuario(id?: number) {
    /* console.log(id) */
    const dialogRef = this.dialog.open(AgregareditarusuarioComponent, {
      width: '550px',
      disableClose: true,
      data: { id: id }
    });
  }

  eliminarUsuario(id: any) {
    this.dueño.deleteDueño(id).subscribe(() => {
      this.mostrar();
      this.mensajeExito();
    })
  }

  mensajeExito() {
    this._snackBar.open("Usuario eliminado con exito!", '', {
      duration: 2000
    });
  }
}



