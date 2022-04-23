package com.dineshb.ms.config;

import com.dineshb.ms.model.Domain;
import com.dineshb.ms.service.DomainPersistingService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class KafkaDomainConsumerConfig {

    private final DomainPersistingService domainPersistingService;

    @Bean
    public Consumer<KStream<String, Domain>> kafkaDomainInformationConsumer() {
        return kStream -> kStream.foreach((s, domain) -> {
            domainPersistingService.persistDomain(domain);
        });
    }
}
