import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AuthService } from "src/app/services/auth.service";
import { mustMatch } from "src/app/validators/mustMatch";

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"],
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = "";
  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.signupForm = this.formBuilder.group(
      {
        firstName: ["", [Validators.required, Validators.minLength(3)]],
        lastName: ["", [Validators.required, Validators.minLength(5)]],
        email: ["", [Validators.required, Validators.email]],
        password: [
          "",
          [
            Validators.required,
            Validators.pattern(
              /^(?=\D*\d)(?=.*[$@$!%*?&])(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,12}$/
            ),
          ],
        ],
        ConfirmPassword: [""],
      },
      //Custom Validators
      {
        validator: mustMatch("password", "ConfirmPassword"),
      }
    );
  }
  signup() {
    console.log(this.signupForm.value);
    this.signupForm.value.roles  = ["admin","user"];
    this.authService.register(this.signupForm.value).subscribe(
      (data) => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      (err) => {
        this.isSignUpFailed = true;
        console.log("here error from BE", err);
        this.errorMessage = err.error.message;
        console.log("this.errorMessage ", this.errorMessage );
        
      }
    );
  }
}
