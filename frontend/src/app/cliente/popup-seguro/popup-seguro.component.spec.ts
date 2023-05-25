import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopupSeguroComponent } from './popup-seguro.component';

describe('PopupSeguroComponent', () => {
  let component: PopupSeguroComponent;
  let fixture: ComponentFixture<PopupSeguroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PopupSeguroComponent]
    });
    fixture = TestBed.createComponent(PopupSeguroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
