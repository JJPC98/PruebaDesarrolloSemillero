import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder, private _snackBar: MatSnackBar, private router: Router) { 
    this.form = this.fb.group({
      usuario: ['jpalacio', Validators.required],
      password: ['admin123', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  ingresar(){
    console.log(this.form)

    const usuario = this.form.value.usuario;
    const password = this.form.value.password;

    if(usuario == 'jpalacio' && password == 'admin123') {
      // Redireccionamos al menu principal
      this.router.navigate(['dashboard']);
    }else{
      // Mostramos un mensaje de error
      this.mensajerror();
      this.form.reset();
      location.reload();
    }
  }

  mensajerror() {
  this._snackBar.open('Usuario o contraseña incorrecta', '',{
    duration: 3000,
    horizontalPosition: 'center',
    verticalPosition: 'bottom'
  })
  }

}
