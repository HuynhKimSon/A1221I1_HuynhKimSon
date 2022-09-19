import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {

  colors = [
    { id: 1, name: "#0000cc" },
    { id: 2, name: "#cc0099" },
    { id: 3, name: "#ffffcc" },
    { id: 4, name: "#00cc66" },
    { id: 5, name: "#663300" }
  ];

  code: string = this.colors[0].name;


  constructor() { }

  ngOnInit(): void {
  }

  changeColorValue(code) {
    this.code = code;
  }

}
