import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HerosListComponent } from '../app/heros-list/heros-list.component';
import { NewHeroComponent } from '../app/new-hero/new-hero.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';

// Listado de vinculaciones entre URL y Component
const routes: Routes =[
  // Que la ruta raiz cargue por defecto el dashboard
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  // Rutas estaticas
  {path: "heroes", component: HerosListComponent},
  {path: "newheroes", component: NewHeroComponent},
  {path: "dashboard", component: DashboardComponent},
  // Ruta con parametros
  {path: 'detail/:id', component: HeroDetailComponent}
]

@NgModule({
  declarations: [],
  imports: [
    // CommonModule
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
