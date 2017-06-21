import { Component, OnInit }  from '@angular/core';
import { Response }           from "@angular/http";

import { PrincipalService }   from './principal/principal.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  me: String = '';

  constructor(private principalService: PrincipalService) {}

  ngOnInit() {
    this.principalService.me()
    .subscribe(
      (response: Response) => {
        let json = response.json();
        this.me = json.firstName + " " + json.lastName;
      },
      (error: Error) => {
        console.error(error);
      }
    );
  }
}
