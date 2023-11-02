import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AxiosService } from 'src/app/services/axios.service';
import { faEye, faEyeSlash,faEnvelope } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  userForm!: FormGroup;
  faEye = faEye;
  faEyeSlash = faEyeSlash;
  faMessage = faEnvelope;
  showPassword = false;
  
  constructor(
    private axios: AxiosService,   
    private fb: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.usersForm();
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }

  usersForm() {
    this.userForm = this.fb.group({
      first_name: [''],
      last_name: [''],
      email: [''],
      password: [''],
     })
  }

  get first_name() {
    return this.userForm.get('firstname');
  }
  get last_name() {
    return this.userForm.get('lastname');
  }

  get email() {
    return this.userForm.get('email');
  }

  get password() {
    return this.userForm.get('password');
  }

  submitUserData() {
  
    const { first_name, last_name, email, password } = this.userForm.value;
    this.axios.request(
      "POST",
      "/register",
      {
        first_name: first_name,
        last_name: last_name,
        email: email,
        password: password
      }
    )
  }

}
