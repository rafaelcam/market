import {Injectable} from "@angular/core";

@Injectable()
export class MessageService {
    messages: any[];

    constructor() {
        this.messages = [];
    }

    loadErrorMessages(messages: any[]): void {
        this.messages = messages;
    }

    clearMessages(): void {
        this.messages = [];
    }
}