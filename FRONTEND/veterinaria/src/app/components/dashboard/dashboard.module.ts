import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { SharedModule } from '../shared/shared.module';
import { DashboardComponent } from './dashboard.component';
import { NavegacionComponent } from './navegacion/navegacion.component';
import { MascotasComponent } from './mascotas/mascotas.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AgregareditarusuarioComponent } from './usuarios/agregareditarusuario/agregareditarusuario.component';
import { AgregareditarmascotaComponent } from './mascotas/agregareditarmascota/agregareditarmascota.component';


@NgModule({
  declarations: [
    DashboardComponent,
    NavegacionComponent,
    MascotasComponent,
    UsuariosComponent,
    AgregareditarusuarioComponent,
    AgregareditarmascotaComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    SharedModule
  ]
})
export class DashboardModule { }
