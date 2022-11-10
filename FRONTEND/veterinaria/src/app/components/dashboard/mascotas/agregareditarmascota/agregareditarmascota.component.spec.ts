import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregareditarmascotaComponent } from './agregareditarmascota.component';

describe('AgregareditarmascotaComponent', () => {
  let component: AgregareditarmascotaComponent;
  let fixture: ComponentFixture<AgregareditarmascotaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregareditarmascotaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgregareditarmascotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
