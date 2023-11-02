import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AxiosService } from 'src/app/services/axios.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  data: string[] = [];
  signinForm!: FormGroup;

  constructor(
    private axiosSerive: AxiosService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {

    this.usersForm();

    this.axiosSerive.request(
      "GET",
      "/messages",
      {}
    ).then (
      (response) => {
        console.log(response);
        
      }
    )
  }

  usersForm() {
    this.signinForm = this.fb.group({
      email: [''],
      password: ['']
    })
  }

  get email() {
    return this.signinForm.get('email');
  }

  get password() {
    return this.signinForm.get('password');
  }

  usersubmit() {
    
    const { email, password } = this.signinForm.value;
    this.axiosSerive.request(
      "POST",
      "/login",
      {
        email: email,
        password: password
      }
    )

  }

}
