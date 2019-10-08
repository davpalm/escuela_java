import { Injectable } from '@angular/core';
import { Hero } from './model/hero';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HeroRestService {

  urlApiRest = "http://localhost:8084/CRUD_Vista_JSTL/api/heroes";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': "application/json"})
  };

  constructor(private httpCli: HttpClient) { 
  }

/*
  getHeroes(): Observable<Hero[]>{
    return of(this.arrayHeroes); // Devolvemos un observable que encapsula el array. Inmediatamente emite el evento de que ya tiene el array
  }
*/

  getHeroes(): Observable<Hero[]>{
    let observResp: Observable<Hero[]>;
    observResp = this.httpCli.get<Hero[]>(this.urlApiRest);
    // Aqui no definimos las callback, mejor que las defina donde las necesitan. Devolvemos el observable para que
    // se pueda gestionar desde fuera del servicio
    return observResp;
  }

  add(newHero: Hero): Observable<Hero>{
    return this.httpCli.post<Hero>(this.urlApiRest, newHero, this.httpOptions);
  }
}
