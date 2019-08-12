import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NgForm, Validators, FormBuilder } from '@angular/forms';
import{PortfolioApiService}  from '../shared/portfolio-api.service';
import{SharedService}  from '../shared/shared.service';
import {environment} from '../../environments/environment'
import {NgbModule,NgbDatepickerConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  userGroup: FormGroup;
  alertType = "success";
  alertMessage ='';
  userData:any;
  submitted:boolean;
  get f() { return this.userGroup.controls; }
  constructor(private portfolioApiService:PortfolioApiService,
    private sharedService:SharedService,
    config: NgbDatepickerConfig) {
    this.userGroup = new FormGroup({
      firstName: new FormControl('',Validators.required),
      lastName: new FormControl('',Validators.required),
      dob: new FormControl('',Validators.required),
      fundAmt: new FormControl('',Validators.required),
   });

   const currentDate = new Date();
   config.maxDate = {year:currentDate.getFullYear(), month:currentDate.getMonth()+1, day: currentDate.getDate()};
   config.minDate = {year: currentDate.getFullYear()-99, month: 12, day: 31};
   }

  ngOnInit() {
  
  }

  close(alert: any) {
   this.alertMessage="";
   this.alertMessage=null;
  }

  submitData()
  {
    this.submitted = true;
    if (this.userGroup.valid) {
      var dob = this.sharedService.getFormatedDate(this.userGroup.value.dob)
      let reqData = {
        "firstName":this.userGroup.value.firstName,
        "lastName":this.userGroup.value.lastName,
        "dob":dob,
        "fundAmt":this.userGroup.value.fundAmt
      }
      this.portfolioApiService.postApi(environment.BASE_URL+'portfolio/submitPortfolio',reqData).subscribe(res=>
      {
        this.userData=res;
        this.alertMessage ='Record Saved Successfully';
        this.submitted = false;
      })
    }
  }

  onlyDecimalNumberKey(event) {
    return this.sharedService.onlyDecimalNumberKey(event);
  }

  onlyAlphabets(event)
  {
    return this.sharedService.onlyAlphabets(event);
  }
}
