import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ecinema',
  templateUrl: './ecinema.component.html',
  styleUrls: ['./ecinema.component.css']
})
export class EcinemaComponent implements OnInit {
  private collapsed: boolean;
  private orderFinished: boolean;

  ngOnInit(): void {
    this.collapsed = true;
    this.orderFinished = false;
  }

  @ViewChild('seansesC')
    seancesC: seancesComponent;
 
    @ViewChild('repertoireC')
    repertoireC: repertoireComponent;
 
    @ViewChild('ordersC')
    ordersC: OrdersComponent;
 
    toggleCollapsed(): void {
        this.collapsed = !this.collapsed;
    }
 
    finishOrder(orderFinished: boolean) {
        this.orderFinished = orderFinished;
    }
 
    reset() {
        this.orderFinished = false;
        this.seancesC.reset();
        this.repertoireC.reset();
        this.ordersC.paid = false;
    }

}
