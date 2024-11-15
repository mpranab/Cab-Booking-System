import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCabsComponent } from './all-cabs.component';

describe('AllCabsComponent', () => {
  let component: AllCabsComponent;
  let fixture: ComponentFixture<AllCabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllCabsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllCabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
