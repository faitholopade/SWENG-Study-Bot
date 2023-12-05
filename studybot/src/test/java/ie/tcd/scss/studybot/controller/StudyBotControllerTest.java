package ie.tcd.scss.studybot.controller;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * This test tests the NamelistController class.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudyBotControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void studyNetworksShouldReturnAString() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/networks", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

        @Test
    public void studyFunctionalShouldReturnAString() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/functional", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

        @Test
    public void studyArchitectureShouldReturnAString() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/architecture", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

        @Test
    public void studySwengShouldReturnAString() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/sweng", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
   
    @Test
    public void studyInvalidShouldReturnYourURLMessage() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/anything", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("Your url must match an existing module (networks, functional, architecture, sweng)");
    }
}

