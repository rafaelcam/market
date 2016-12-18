import {Component} from "@angular/core";
import {MessageService} from "./message.service";

@Component({
    selector: 'messages',
    templateUrl: '../partials/message/messages.html'
})
export class MessageComponent {

    constructor(public messageService: MessageService) { }

    clearMessages(): void {
        this.messageService.clearMessages();
    }
}
