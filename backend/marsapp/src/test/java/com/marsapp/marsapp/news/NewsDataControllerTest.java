package com.marsapp.marsapp.news;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import com.marsapp.marsapp.BaseIntegrationTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class NewsDataControllerTest {


    @ServiceConnection
    static PostgreSQLContainer postgres = BaseIntegrationTest.postgres;

    @Autowired
    private RestTestClient restTestClient;

    @Autowired
    private NewsDataRepository repository;

    @Autowired
    private AuthorTestRepository authorRepository;


    @BeforeEach
    void setUp() {
        repository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    void shouldFindNewsByDate() {
        Author author = authorRepository.save(new Author("John Doe"));
        
        LocalDate today = LocalDate.now();
        NewsData news = new NewsData();
        news.setPublishedAt(today);
        news.setNewsSite("Mars Daily");
        news.setAuthors(List.of(author));
        repository.save(news);

        restTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/news")
                        .queryParam("date", today.toString())
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<NewsData>>() {})
                .consumeWith(response -> {
                    List<NewsData> body = response.getResponseBody();
                    assertThat(body).isNotNull();
                    assertThat(body.get(0).getPublishedAt()).isEqualTo(today);
                });
    }

    @Test
    void shouldReturn404WhenNoNewsExists() {
        restTestClient.get()
            .uri("/api/news/latest")
            .exchange()
            .expectStatus().isNotFound();
    }
}
