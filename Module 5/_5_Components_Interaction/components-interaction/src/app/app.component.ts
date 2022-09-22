import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'components-interaction';
  numberVote: number = 5;

  timeMax: number = 100;

  changeNumberVote(newNumberVote: number) {
    this.numberVote = newNumberVote;
  }

  changeTime(newTime: number) {
    this.timeMax = newTime;
  }

}
