import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import {EmailComponent} from "./email/email.component";
import {ProductListComponent} from "./product/product.list.component";

// Route Configuration
export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'email', component: EmailComponent },
    { path: 'product/list', component: ProductListComponent }
    //{ path: 'pessoa/new', component: NewPessoaComponent },
    //{ path: 'pessoa/edit/:id', component: EditPessoaComponent },
    //{ path: 'pessoa/detail/:id', component: DetailPessoaComponent },
    //{ path: 'endereco', component: FindEnderecoComponent }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);