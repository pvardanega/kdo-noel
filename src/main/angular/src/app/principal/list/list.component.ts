import { Component, OnInit }  from '@angular/core';
import { Response }           from "@angular/http";

import { PrincipalService }   from "../principal.service";

@Component({
  selector: 'list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  envies = [];

  constructor(private principalService: PrincipalService) {}

  ngOnInit() {
    this.principalService.myList()
      .subscribe(
        (response: Response) => {
          let json = response.json();
          this.envies = json.envies;
        },
        (error: Error) => {
          console.error(error);
        }
      );
  }
}
