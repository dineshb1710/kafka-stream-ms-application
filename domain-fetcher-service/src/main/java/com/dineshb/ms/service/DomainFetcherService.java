package com.dineshb.ms.service;

import com.dineshb.ms.model.Domain;
import com.dineshb.ms.model.DomainList;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Log4j2
@Service
@RequiredArgsConstructor
public class DomainFetcherService {

    private final KafkaTemplate<String, Domain> kafkaTemplate;

    @Value("${domain.api.base-url}")
    private String domainServiceBaseUrl;

    @Value("${domain.topic.name}")
    private String domainTopicName;

    public void fetchDomainFor(String domainName) {

        Mono<DomainList> domainListMono = WebClient.create()
                .get()
                .uri(domainServiceBaseUrl + "=" + domainName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DomainList.class);

        domainListMono.subscribe(domainList -> {
            domainList.getDomains().stream().forEach(domain -> {
                kafkaTemplate.send(domainTopicName, domain);
                log.info("Sent Message to Topic -> " + domain);
            });
        });
    }
}
