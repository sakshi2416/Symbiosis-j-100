// Import necessary Angular modules  
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SupplService } from 'src/app/suppl.service';

@Component({
  selector: 'app-my-supplier',
  templateUrl: './my-supplier.component.html',
  styleUrls: ['./my-supplier.component.css'] // Correct: Now it's an array
})
export class MySupplierComponent implements OnInit {

    newSupplier = { name: '', contact: '', address: '' };
    showAddSupplierForm: boolean = false;
  
    constructor(private supplierService: SupplService) {}
  
    ngOnInit(): void {
      this.loadSuppliers();
    }
  
    loadSuppliers(): void {
      this.supplierService.getSuppliers().subscribe({
        next: (data: { id: number; name: string; contact: string; address: string; }[]) => {
          this.suppliers = data;
        },
        error: (err: any) => {
          console.error('Error fetching suppliers:', err);
        }
      });
    }
  
  
  
    suppliers = [
      {
        id: 1,
        name: 'sakshi shinde',
        contact: '987-654-3210',
        address: '456 Wellness Ave, HealthCity',
      },
      {
        id: 2,
        name: 'Anju sharma',
        contact: '987-654-3210',
        address: 'Satpur',
      },
      {
        id: 3,
        name: 'Minal Shrivastava',
        contact: '987-654-3210',
        address: 'Satpur',
      }
    ];
    
    
  
    // Add new supplier to the list
    addSupplier() {
        
      alert(this.newSupplier.name);  // Debugging: Show alert with supplier name
    
      if (this.newSupplier.name && this.newSupplier.contact && this.newSupplier.address) {
        // Call the supplier service to send the new supplier to the backend
        this.supplierService.addSupplier(this.newSupplier).subscribe({
          next: (data) => {
            // Add the returned supplier (with ID from backend) to the array
            this.suppliers.push(data);  
            this.newSupplier = { name: '', contact: '', address: '' };  // Reset form fields
            this.showAddSupplierForm = false;  // Close the form
            alert('Supplier added successfully!');
          },
          error: (err) => {
            console.error('Failed to add supplier:', err);
            alert('Failed to add supplier. Please try again.');
          }
        });
      }
    }
    
    
  
    // Delete a supplier from the list
    deleteSupplier(id: number): void {
      if (confirm('Are you sure you want to delete this supplier?')) {
        this.supplierService.deleteSupplier(id).subscribe({
          next: () => {
            this.suppliers = this.suppliers.filter((s) => s.id !== id);
          },
          error: (err) => {
            console.error('Failed to delete supplier:', err);
            alert('Error deleting supplier');
          }
        });
      }
    }
  }
