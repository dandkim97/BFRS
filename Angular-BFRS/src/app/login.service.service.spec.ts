import { TestBed } from '@angular/core/testing';

import { Login.ServiceService } from './login.service.service';

describe('Login.ServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Login.ServiceService = TestBed.get(Login.ServiceService);
    expect(service).toBeTruthy();
  });
});
