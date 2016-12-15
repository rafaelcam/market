import {Component, ElementRef, NgZone, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {EmailService} from "./email.service";
import {Email} from "./email.model";

declare var jQuery:any;

@Component({
    selector: 'email',
    templateUrl: 'partials/email/envia.html'
})
export class EmailComponent implements OnInit {
    emails: string[];
    email: Email;
    table: any;

    ngOnInit(): void {
        this.email = new Email();
    }

    constructor(public emailService: EmailService,
                public elementRef: ElementRef,
                public zone: NgZone,
                public router: Router) {
        (<any>window).angularComponentRef = {component: this, zone: this.zone};
    }

    public validarConsulta(): void {
        if(this.validaEmail(this.email)) {
            this.emailService.validarConsulta(this.email)
                .subscribe(res => {
                    this.emails = res;
                    var data = this.construirDados();
                    this.plotarDataTable(data);
                }, error => {
                    alert('Ocorreu um erro ao tentar validar a consulta. Verifique a sintaxe.');
                });
        }
    }

    public enviarEmails(): void {
        if(this.validaEmail(this.email)) {
            this.emailService.enviarEmails(this.email)
                .subscribe(res => {
                    alert('Emails enviados com sucesso.');
                }, error => {
                    console.log(error);
                    alert('Ocorreu um erro ao tentar enviar os emails. Verifique a sintaxe.');
                });
        }
    }

    private validaEmail(email: Email): boolean {
        if(email) {
            if(!email.descricao) {
                alert('Descrição - Preenchimento Obrigatório.');
                return false;
            } if(!email.consultaEmails) {
                alert('Consulta - Preenchimento Obrigatório.');
                return false;
            }
        } else {
            alert('Preencha os campos Obrigatórios.');
            return false;
        }

        return true;
    }

    private construirDados() {
        var data = [];

        this.emails.forEach(email => {
            var array = [
                email
            ];

            data.push(array);
        });

        return data;
    }

    private plotarDataTable(data: any[]) {
        if(this.table) {
            jQuery(this.elementRef.nativeElement).find('#table-emails').DataTable().destroy();
        }

        this.table = jQuery(this.elementRef.nativeElement).find('#table-emails').DataTable({
            data: data,
            responsive: true,
            columns: [
                {title: "Email"},
            ],
            language: {
                url: "resources/Portuguese-Brasil.json"
            }
        });
    }

    public destruirDataTablePessoa() {
        jQuery(this.elementRef.nativeElement).find('#table-emails').DataTable().destroy();
        alert('destroy');
    }

    private getColumnOpcoes(id: number) {
        return "<div style=\"text-align: center;\">"
            +"<a onclick=\"window.angularComponentRef.component.viewEdit("+id+");\" class=\"btn btn-sm btn-inverse m-r-5\" ><i class=\"fa fa-pencil\"></i></a>"
            +"<a onclick=\"window.angularComponentRef.component.viewDetail("+id+");\" class=\"btn btn-sm btn-success m-r-5\" ><i class=\"fa fa-file-text\"></i></a>"
            +"<a data-target=\"#modal-alert-delete\" data-toggle=\"modal\" "
            +"class=\"btn btn-sm btn-danger m-r-5\" onclick=\"window.angularComponentRef.component.viewDelete("+id+");\"><i class=\"fa fa-times\"></i></a>"
            +"</div>";
    }
}