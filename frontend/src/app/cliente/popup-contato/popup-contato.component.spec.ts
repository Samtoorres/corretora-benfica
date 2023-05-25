import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopupContatoComponent } from './popup-contato.component';

describe('PopupContatoComponent', () => {
  let component: PopupContatoComponent;
  let fixture: ComponentFixture<PopupContatoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PopupContatoComponent]
    });
    fixture = TestBed.createComponent(PopupContatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
