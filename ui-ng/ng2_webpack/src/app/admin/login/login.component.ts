import { Component } from "@angular/core";
import { UserService } from "../adminShared/admin.service";
import { Router } from "@angular/router";

@Component({
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent {
    email: string;
    password1: string;
    

    constructor(private userServ: UserService, private router: Router) {

    }

    login(){
        this.userServ.login(this.email,this.password1);
        this.userServ.verifyUser();
    }

    signUp(){
        this.router.navigate(['/admin/signup']);
    }

    cancel(){
        this.router.navigate(['']);
    }

    logout(){
        this.userServ.logout();
    }
}
