import { Component } from "@angular/core";

@Component({
    selector: 'navi-bar',
    template: `<div clas = "top-bar" >
                <div class="top-bar-title">First Angular 2 Practice</div>
                <div>
                    <ul class = "menu">
                        <li class = "nav-menu"><a [routerLink]= "['/admin']" >Admin</a></li>
                    </ul>
                </div>
               </div> 
        `,
    styleUrls: ['./navbar-component.css']
})

export class NavComponent {

}