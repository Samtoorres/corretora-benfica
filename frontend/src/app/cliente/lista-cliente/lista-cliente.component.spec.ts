import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaClienteComponent } from './lista-cliente.component';

describe('ListaClienteComponent', () => {
  let component: ListaClienteComponent;
  let fixture: ComponentFixture<ListaClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListaClienteComponent]
    });
    fixture = TestBed.createComponent(ListaClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
