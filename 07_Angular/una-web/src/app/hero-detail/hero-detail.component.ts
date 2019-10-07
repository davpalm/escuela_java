import { Component, OnInit, Input } from '@angular/core';
import { Hero } from '../model/hero';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {
  // Esta propiedad viene de algun componente externo
  @Input() hero: Hero;

  constructor(private route: ActivatedRoute, private heroSrv: HeroService, private location: Location) { }

  ngOnInit() {
    this.getHero();
  }

  getHero(): void {
    // Cogemos el id del parametro de la url /detail/:id
    const id = this.route.snapshot.paramMap.get('id');
    this.hero = this.heroSrv.getHero(parseInt(id));
  }

}
