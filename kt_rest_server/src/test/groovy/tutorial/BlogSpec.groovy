package tutorial

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import tutorial.model.BlogDao

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

@SpringBootTest(classes = Application.class, webEnvironment = NONE )
class BlogSpec extends Specification{

    @Autowired
    BlogDao blogDao

    def "Test 001: Blog (all-in-one)"() {
        expect:
        blogDao.findAll().size() > 0
    }

    def "Test 002: Blog can findById"(){
        expect:
        blogDao.findById( 1 ) != null
    }

}
