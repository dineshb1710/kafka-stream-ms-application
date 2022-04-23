package com.dineshb.ms.service.impl;

import com.dineshb.ms.model.Domain;
import com.dineshb.ms.repo.DomainRepository;
import com.dineshb.ms.service.DomainPersistingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainPersistingServiceImpl implements DomainPersistingService {

    private final DomainRepository domainRepository;

    @Override
    public void persistDomain(Domain domain) {
        domainRepository.save(domain);
    }
}
