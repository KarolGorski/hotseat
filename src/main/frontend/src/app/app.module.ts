import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EcinemaComponent } from './ecinema/ecinema.component';
import { MoviesComponent } from './ecinema/movies/movies.component';
import { SeancesComponent } from './ecinema/seances/seances.component';
import { SeatsComponent } from './ecinema/seats/seats.component';
import { HallsComponent} from './ecinema/halls/halls.component';
import { ClientsComponent} from './ecinema/clients/clients.component';
import { RepertoireComponent} from './ecinema/repertoire/repertoire.component';
import { Identifiers } from '@angular/compiler';

@NgModule({
  declarations: [
    AppComponent,
    EcinemaComponent,
    MoviesComponent,
    SeancesComponent,
    HallsComponent,
    SeatsComponent,
    ClientsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 

}


export class Movie {
  id: number;
  name: string
  duration: number;

  constructor(id: number, name: string, duration: number) {
    this.id = id; 
    this.name = name;
    this.duration = duration
  }
}

export class Seance {
  id: number;
  movie: Movie;
  seats: Seat[] = [];

  constructor(id: number, movie: Movie, seats: Seat[]) {
    this.id = id; 
    this.movie = movie;
    this.seats = seats;
  }
}

export class Seat {
  id: number;
  client: Client;

  constructor(id: number, client: Client) {
    this.id = id; 
    this.client = client;
  }
}

export class Client {
  id: number;
  name: String;

  constructor(id: number, name: string) {
    this.id = id; 
    this.name = name;
  }
}

export class Hall {
  id: number;
  seatsQuantity: number;

  constructor(id: number, seatsQuantity: number) {
    this.id = id; 
    this.seatsQuantity = seatsQuantity;
  }
}

export class Repertoire {
  seances: Seance[] = [];
}

//https://www.baeldung.com/spring-angular-ecommerce