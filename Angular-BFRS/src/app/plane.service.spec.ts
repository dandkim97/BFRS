import { TestBed } from '@angular/core/testing';

import { PlaneService } from './plane.service';

describe('PlaneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlaneService = TestBed.get(PlaneService);
    expect(service).toBeTruthy();
  });
});
