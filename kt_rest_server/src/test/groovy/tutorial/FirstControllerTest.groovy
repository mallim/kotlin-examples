package tutorial

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

import java.time.Instant

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class FirstControllerTest extends Specification{

    @Autowired
    TestRestTemplate restTemplate

    def 'Test 001 /answer should return 42'() {
        when:
        def entity = restTemplate.getForObject('/answer',String.class)

        then:
        entity == '42'
    }

    def 'Test 002 /user should return something'() {
        when:
        def entity = restTemplate.getForEntity('/user',User.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body.email == "grahamcox@example.com"
        entity.body.screenName == "Graham"
    }

}