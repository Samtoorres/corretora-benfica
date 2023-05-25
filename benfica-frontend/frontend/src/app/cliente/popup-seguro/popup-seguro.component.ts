import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-popup-seguro',
  templateUrl: './popup-seguro.component.html',
  styleUrls: ['./popup-seguro.component.scss']
})
export class PopupSeguroComponent {

  dados: any;

  constructor(public dialogRef: MatDialogRef<PopupSeguroComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  close(): void {
    this.dialogRef.close();
  }
}
