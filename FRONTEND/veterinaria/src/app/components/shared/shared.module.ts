import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

// Modulos
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { MatTableExporterModule } from 'mat-table-exporter';


// Angular Material
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatDialogModule} from '@angular/material/dialog';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { DatePipe } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
        // Angular Material
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatSnackBarModule,
        ReactiveFormsModule,
        MatToolbarModule,
        MatIconModule,
        MatCardModule,
        MatTableModule,
        HttpClientModule,
        MatTooltipModule,
        MatDialogModule,
        MatPaginatorModule,
        MatSelectModule,
        MatDatepickerModule,
        MatNativeDateModule,
        DatePipe,
        MatTableExporterModule
        
  ],
  exports: [
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatTableModule,
    HttpClientModule,
    MatTooltipModule,
    MatDialogModule,
    MatPaginatorModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    DatePipe,
    MatTableExporterModule
  
  ]
})
export class SharedModule { }
