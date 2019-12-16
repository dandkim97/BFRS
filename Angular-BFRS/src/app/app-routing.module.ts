import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddLoginComponent } from './add-login/add-login.component';
import { AdminMsgComponent } from './admin-msg/admin-msg.component';
import { UpdateMsgComponent } from './update-msg/update-msg.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'add',
    component: AddLoginComponent
  },
  {
    path: 'viewAdminMsg',
    component: AdminMsgComponent
  },
  {
    path: 'viewAdminMsg/update',
    component: UpdateMsgComponent
  },
  {
    path: 'viewAdminMsg/update/:id',
    component: UpdateMsgComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
