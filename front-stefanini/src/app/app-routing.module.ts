import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './pages/formulario/form.component';
import { ResumenComponent } from './pages/resumen/resumen.component';
import { ModalComponent } from './components/modal/modal.component';

const routes: Routes = [
  {
    path: 'persona/:numeroDocumento',
    component: ResumenComponent
  },
  {
    path: 'modal',
    component: ModalComponent
  },
  {
    path: '',
    component: FormComponent,
    pathMatch: 'full'
  },

  {
    path: '**',
    component: FormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }