import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service'; // Chemin corrigé
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: any[] = [];
  selectedEmployee: any = null;
  startDate: string = '';
  endDate: string = '';
  overtimeResult: any = null;
  loading: boolean = false;
  error: string | null = null;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.loading = true;
    this.error = null;
    
    this.employeeService.getEmployees().subscribe({
      next: (data: any[]) => {
        this.employees = data;
        this.loading = false;
      },
      error: (err: any) => {
        this.error = 'Erreur lors du chargement des employés';
        this.loading = false;
        console.error(err);
      }
    });
  }

  calculateOvertime(): void {
    if (!this.selectedEmployee || !this.startDate || !this.endDate) return;

    this.loading = true;
    this.error = null;
    
    this.employeeService.calculateOvertime(
      this.selectedEmployee.id,
      this.startDate,
      this.endDate
    ).subscribe({
      next: (result: any) => {
        this.overtimeResult = result;
        this.loading = false;
      },
      error: (err: any) => {
        this.error = 'Erreur lors du calcul des heures supplémentaires';
        this.loading = false;
        console.error(err);
      }
    });
  }
}