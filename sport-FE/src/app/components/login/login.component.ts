import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "src/app/services/auth.service";
import { TokenStorageService } from "src/app/services/token-storage.service";
import jwt_decode from "jwt-decode";
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  title: string = "Login";
  user: any = {};

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = "";
  roles: string[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
    /* necessaire seulement si je veux utiliser des validateurs*/
    this.loginForm = this.formBuilder.group({
      email: [""],
      password: [""],
    });
  }
  login() {
    console.log("This is my user : ", this.user);
    this.authService.login(this.user).subscribe(
      (data) => {
        console.log("here data after login", data);
        console.log("here data after login", data);

        this.tokenStorage.saveToken(data.accessToken);
        console.log("Here decoded token", this.getDecodedAccessToken(data.accessToken));
        
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.router.navigate(["profile"]);
      },
      (err) => {
        console.log("here error after login", err);

        // this.errorMessage = err.error.message;
        // this.isLoginFailed = true;
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }
  getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    } catch (Error) {
      return null;
    }
  }
}
