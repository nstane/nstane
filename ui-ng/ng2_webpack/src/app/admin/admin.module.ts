import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule } from "@angular/forms";

import { AdminComponent } from "./adminComponent/admin.component";
import { AdminMenuComponent } from "./adminMenu/adminmenu.component";
import { SignUpComponent } from "./signup/sign-up.component";
import { LoginComponent } from "./login/login.component";
import { UserService } from "./adminShared/admin.service";


const AdminRoutes: Routes = [
    {
        path: 'admin',
        component: AdminComponent,
        children: [
            { path: 'login', component: LoginComponent },
            { path: 'signup', component: SignUpComponent },
            { path: '', component: AdminMenuComponent, canActivate: [UserService] }
        ]
    }
];
@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        RouterModule.forChild(AdminRoutes)
    ],
    exports: [
        RouterModule
    ],
    declarations: [
        AdminComponent,
        AdminMenuComponent,
        LoginComponent,
        SignUpComponent
    ],
    providers: [
        UserService
    ]
})

export class AdminModule { }