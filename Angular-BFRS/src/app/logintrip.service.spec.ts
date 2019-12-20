import { TestBed } from '@angular/core/testing';

import { LogintripService } from './logintrip.service';

describe('LogintripService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LogintripService = TestBed.get(LogintripService);
    expect(service).toBeTruthy();
  });
});
