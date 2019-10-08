import { Component, OnInit } from '@angular/core';
import { HeroRestService } from '../hero-rest.service';
import { Hero } from '../model/hero';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-hero-rest',
  template: `
  <li>
    <ul>
      <li *ngFor = "let hero of heroesRecibidos">
        {{hero.id}} - {{hero.name}}
      </li>
    </ul>
    <div>
      <input [(ngModel)]="id" placeholder="id">
      <input [(ngModel)]="name" placeholder="Name">
      <input type="button" (click)="enviar()" value="SEND">
    </div>
  </li>
  `
})
export class HeroRestComponent implements OnInit {

  heroesRecibidos: Hero[];
  id: string;
  name: string;
  constructor(private heroesRestSrv: HeroRestService) { }

  enviar(){
    let newHero = new Hero();
    newHero.id = parseInt(this.id);
    newHero.name = this.name;
    this.heroesRestSrv.add(newHero).subscribe( (obj) => {
      this.ngOnInit();
    });
  }

  ngOnInit() {
    let observableArrayHeroes: Observable<Hero[]>;
    observableArrayHeroes = this.heroesRestSrv.getHeroes();
    // La ejecucion continua hasta que el array es recibido. Para recibirlo asincronamente nos suscribimos al Observable
    observableArrayHeroes.subscribe( heroesRec => this.heroesRecibidos = heroesRec );
  }

}
