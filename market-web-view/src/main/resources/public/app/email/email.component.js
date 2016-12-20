"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var router_1 = require("@angular/router");
var email_service_1 = require("./email.service");
var email_model_1 = require("./email.model");
var EmailComponent = (function () {
    function EmailComponent(emailService, elementRef, zone, router) {
        this.emailService = emailService;
        this.elementRef = elementRef;
        this.zone = zone;
        this.router = router;
        window.angularComponentRef = { component: this, zone: this.zone };
    }
    EmailComponent.prototype.ngOnInit = function () {
        this.email = new email_model_1.Email();
    };
    EmailComponent.prototype.validarConsulta = function () {
        var _this = this;
        if (this.validaEmail(this.email)) {
            this.emailService.validarConsulta(this.email)
                .subscribe(function (res) {
                _this.emails = res;
                var data = _this.construirDados();
                _this.plotarDataTable(data);
            }, function (error) {
                alert('Ocorreu um erro ao tentar validar a consulta. Verifique a sintaxe.');
            });
        }
    };
    EmailComponent.prototype.enviarEmails = function () {
        if (this.validaEmail(this.email)) {
            this.emailService.enviarEmails(this.email)
                .subscribe(function (res) {
                alert('Emails enviados com sucesso.');
            }, function (error) {
                console.log(error);
                alert('Ocorreu um erro ao tentar enviar os emails. Verifique a sintaxe.');
            });
        }
    };
    EmailComponent.prototype.validaEmail = function (email) {
        if (email) {
            if (!email.descricao) {
                alert('Descrição - Preenchimento Obrigatório.');
                return false;
            }
            if (!email.consultaEmails) {
                alert('Consulta - Preenchimento Obrigatório.');
                return false;
            }
        }
        else {
            alert('Preencha os campos Obrigatórios.');
            return false;
        }
        return true;
    };
    EmailComponent.prototype.construirDados = function () {
        var data = [];
        this.emails.forEach(function (email) {
            var array = [
                email
            ];
            data.push(array);
        });
        return data;
    };
    EmailComponent.prototype.plotarDataTable = function (data) {
        if (this.table) {
            jQuery(this.elementRef.nativeElement).find('#table-emails').DataTable().destroy();
        }
        this.table = jQuery(this.elementRef.nativeElement).find('#table-emails').DataTable({
            data: data,
            responsive: true,
            columns: [
                { title: "Email" },
            ],
            language: {
                url: "resources/Portuguese-Brasil.json"
            }
        });
    };
    EmailComponent.prototype.destruirDataTablePessoa = function () {
        jQuery(this.elementRef.nativeElement).find('#table-emails').DataTable().destroy();
        alert('destroy');
    };
    EmailComponent.prototype.getColumnOpcoes = function (id) {
        return "<div style=\"text-align: center;\">"
            + "<a onclick=\"window.angularComponentRef.component.viewEdit(" + id + ");\" class=\"btn btn-sm btn-inverse m-r-5\" ><i class=\"fa fa-pencil\"></i></a>"
            + "<a onclick=\"window.angularComponentRef.component.viewDetail(" + id + ");\" class=\"btn btn-sm btn-success m-r-5\" ><i class=\"fa fa-file-text\"></i></a>"
            + "<a data-target=\"#modal-alert-delete\" data-toggle=\"modal\" "
            + "class=\"btn btn-sm btn-danger m-r-5\" onclick=\"window.angularComponentRef.component.viewDelete(" + id + ");\"><i class=\"fa fa-times\"></i></a>"
            + "</div>";
    };
    EmailComponent = __decorate([
        core_1.Component({
            selector: 'email',
            templateUrl: 'partials/email/envia.html'
        }), 
        __metadata('design:paramtypes', [email_service_1.EmailService, core_1.ElementRef, core_1.NgZone, router_1.Router])
    ], EmailComponent);
    return EmailComponent;
}());
exports.EmailComponent = EmailComponent;
//# sourceMappingURL=email.component.js.map