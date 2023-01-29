package com.grpc.test.clientserver;


import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ArticlesController {

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/test")
    public String[] test(
      //@RegisteredOAuth2AuthorizedClient("articles-client") OAuth2AuthorizedClient authorizedClient
    ) {
        return this.webClient
          .get()
          .uri("http://127.0.0.1:9091/articles")
          //.attributes(oauth2AuthorizedClient(authorizedClient))
          .attributes(clientRegistrationId("articles-client"))
          .retrieve()
          .bodyToMono(String[].class)
          .block();
    }
}
