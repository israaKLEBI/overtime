import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = `${environment.apiBaseUrl}/api/employees`;

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  calculateOvertime(employeeId: number, startDate: string, endDate: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${employeeId}/overtime`, {
      params: { startDate, endDate }
    });
  }
}