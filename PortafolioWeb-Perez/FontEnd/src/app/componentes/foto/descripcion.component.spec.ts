import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoComponent } from './descripcion.component';

describe('FotoComponent', () => {
  let component: FotoComponent;
  let fixture: ComponentFixture<FotoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FotoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
