import { Injectable } from "@angular/core";

import {
    CanActivate,
    Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot
} from '@angular/router'

import * as firebase from "firebase";

@Injectable()
export class UserService implements CanActivate {
    userLoggedin: boolean = false;
    loginedUser: String;
    authUser: any;

    constructor(private router: Router) {
        firebase.initializeApp(
            {
                apiKey: "AIzaSyAXOeSGFU1UGLKerSLRlIU-UjKRgDyWPy8",
                authDomain: "angularjs2-54f80.firebaseapp.com",
                databaseURL: "https://angularjs2-54f80.firebaseio.com",
                projectId: "angularjs2-54f80",
                storageBucket: "",
                messagingSenderId: "54944923349"
            }
        )
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let url: String = state.url;

        return this.verifyLogin(url);
    }

    verifyLogin(url: String): boolean {
        if (this.userLoggedin) return true;
        this.router.navigate(['/admin/login']);
        return false;
    }

    register(email: string, password: string) {
        firebase.auth().createUserWithEmailAndPassword(email, password).catch(function (error) {
            alert(error.message+' Please try Again!');
        })
    }

    verifyUser() {
        this.authUser = firebase.auth().currentUser;
        if (this.authUser) {
            alert('Welcome '+this.authUser.email);
            this.loginedUser = this.authUser.email;
            this.userLoggedin = true;
            this.router.navigate(['/admin']);
        }
    }

    login(loginEmail: string, loginPassword: string) {
        firebase.auth().signInWithEmailAndPassword(loginEmail, loginPassword).catch(function (error) {
            alert(error.message+' unable to login. Try again.');
        })
    }

    logout() {
        this.userLoggedin = false;
        firebase.auth().signOut().then(
            function () {
                alert('Logged Out')
            }, function (error) {
                alert(error.message+' unable to logout. Try again');
            }
        );
    }
}