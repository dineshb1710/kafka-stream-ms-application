package com.dineshb.ms.processor;

import com.dineshb.ms.model.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class DomainProcessor {

    @Bean
    public Function<KStream<String, Domain>, KStream<String, Domain>> kafkaDomainProcessor() {
        return kStream -> kStream.filter((key, domain) -> !domain.isDead());
    }
}
