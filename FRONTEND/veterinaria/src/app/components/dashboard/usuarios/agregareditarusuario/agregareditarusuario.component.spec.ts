import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregareditarusuarioComponent } from './agregareditarusuario.component';

describe('AgregareditarusuarioComponent', () => {
  let component: AgregareditarusuarioComponent;
  let fixture: ComponentFixture<AgregareditarusuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregareditarusuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgregareditarusuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
