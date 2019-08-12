import { TestBed } from '@angular/core/testing';

import { PortfolioApiService } from './portfolio-api.service';

describe('PortfolioApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PortfolioApiService = TestBed.get(PortfolioApiService);
    expect(service).toBeTruthy();
  });
});
