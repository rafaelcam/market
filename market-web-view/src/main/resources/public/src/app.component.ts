declare var App: any;

import { Component, AfterViewInit } from '@angular/core';
@Component({
  selector: 'my-app',
  templateUrl: '../partials/main.html'
})
export class AppComponent implements AfterViewInit {

    ngAfterViewInit() {
          App.init();
    }

}