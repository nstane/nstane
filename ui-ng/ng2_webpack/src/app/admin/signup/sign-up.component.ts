import { Component } from "@angular/core";
import { UserService } from "../adminShared/admin.service";
import { Router } from "@angular/router";

@Component({
    templateUrl: './sign-up.component.html',
    styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent {
    email:string;
    password1:string;
    password2:string;

    passwordFail:boolean;

    constructor(private userServ: UserService, private router:Router){

    }

    signUp(){
        if(this.password1 !== this.password2){
            this.passwordFail = true;
        }else{
            this.passwordFail = false;
            this.userServ.register(this.email,this.password1);
            this.userServ.verifyUser();
        }
    }

    cancel(){
        this.router.navigate(['/admin/login']);
    }
 }