import { TestBed } from '@angular/core/testing';

import { StefaniniApiService } from './StefaniniApiService';

describe('StefaniniApiService', () => {
  let service: StefaniniApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StefaniniApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
