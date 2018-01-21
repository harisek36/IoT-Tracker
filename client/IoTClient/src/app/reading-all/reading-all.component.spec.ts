import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadingAllComponent } from './reading-all.component';

describe('ReadingAllComponent', () => {
  let component: ReadingAllComponent;
  let fixture: ComponentFixture<ReadingAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReadingAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReadingAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
