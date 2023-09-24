import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyprojectComponent } from './myproject.component';

describe('MyprojectComponent', () => {
  let component: MyprojectComponent;
  let fixture: ComponentFixture<MyprojectComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyprojectComponent]
    });
    fixture = TestBed.createComponent(MyprojectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
