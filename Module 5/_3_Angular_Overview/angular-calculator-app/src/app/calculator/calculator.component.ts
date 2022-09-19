import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  result: number = 0;


  constructor() { }

  ngOnInit(): void {
  }

  calculate(operator, firstNumber, secondNumber) {

    switch (operator) {
      case ('+'):
        this.result = parseFloat(firstNumber) + parseFloat(secondNumber);
        break;
      case ('-'):
        this.result = parseFloat(firstNumber) - parseFloat(secondNumber);
        break;
      case ('*'):
        this.result = parseFloat(firstNumber) * parseFloat(secondNumber);
        break;
      case ('/'):
        this.result = parseFloat(firstNumber) / parseFloat(secondNumber);
        break;
    }
  }

}
