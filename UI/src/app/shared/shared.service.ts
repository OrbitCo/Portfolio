import { Injectable } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
@Injectable({
    providedIn: 'root'
})
export class SharedService {

    constructor() { }

    onlyDecimalNumberKey(event) {
        let e = event;
        if ([46, 8, 9, 27, 13, 110, 190].indexOf(e.keyCode) !== -1 ||
            // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
            // Allow: Ctrl+C
            (e.keyCode == 67 && e.ctrlKey === true) ||
            // Allow: Ctrl+X
            (e.keyCode == 88 && e.ctrlKey === true) ||
            // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    }

    onlyAlphabets(event) {
        var charCode = event.keyCode;
        if (charCode == 17 || charCode == 16) {
            return false;
        }
        if (charCode > 36 && charCode < 41 || charCode == 32 || charCode > 95 && charCode < 105 || charCode == 9 || charCode == 8 || charCode == 46 || (charCode > 64 && charCode < 91) || (charCode > 111 && charCode < 123))
            return true;
        else {
            return false;
        }
    }

    getFormatedDate(date: NgbDateStruct): string {
        let month;
        let day;
        if (date.month < 10) {
            month = "0" + date.month;
        } else {
            month = date.month;
        }

        if (date.day < 10) {
            day = "0" + date.day;
        } else {
            day = date.day;
        }

        return `${date.year}-${month}-${day}`;
    }
}
