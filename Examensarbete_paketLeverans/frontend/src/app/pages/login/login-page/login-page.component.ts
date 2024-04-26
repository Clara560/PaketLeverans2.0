import {Component} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {KeycloakService} from "../../../shared/services/keycloak-service/keycloak.service";
import {Router} from "@angular/router";
import {SharedModule} from "../../../shared/shared.module";


@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.scss'
})
export class LoginPageComponent {

  public loginForm: FormGroup;
  private _keycloakService: KeycloakService;

  constructor(private router: Router, keycloakService: KeycloakService) {
    this._keycloakService = keycloakService;
    this.loginForm = new FormGroup({
      username: new FormControl(null, [Validators.required, Validators.minLength(3)]),
      password: new FormControl(null, [Validators.required, Validators.minLength(3)])
    })
  }

  public Login() {
    const loginRequest: LoginRequest = this.loginForm.value;
    this._keycloakService.login(loginRequest).subscribe({
      next: ((res) => {
        this.router.navigate(['/user/orders']);
      }),
      error: (error: Error) => {
        console.log(error)
      }
    })
  }
}

interface LoginRequest {
  username: string;
  password: string;
}
