package com.dineshb.ms.controller;

import com.dineshb.ms.service.DomainFetcherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/domain")
@RequiredArgsConstructor
public class DomainFetcherController {

    private final DomainFetcherService domainFetcherService;

    @GetMapping("/fetch/{domainName}")
    public String fetchDomainsByName(@PathVariable final String domainName) {
        log.info("Fetching domains for -> " + domainName);
        domainFetcherService.fetchDomainFor(domainName);
        return "Domains Fetched for -> " + domainName;
    }
}
