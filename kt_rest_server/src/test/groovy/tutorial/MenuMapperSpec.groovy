package tutorial

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import tutorial.Application
import tutorial.model.MenuMapper

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

@SpringBootTest(classes = Application.class, webEnvironment = NONE )
class MenuMapperSpec extends Specification {

    @Autowired
    MenuMapper menuMapper

    def "Test 001: Kotlin can work with mybatis"() {
        expect:
        menuMapper.count() > 0
    }

    def "Test 002: Kotlin data class can map with mybatis"(){
        when:
        def menu = menuMapper.getOne( 1 )
        then:
        assert menu != null
    }
}
