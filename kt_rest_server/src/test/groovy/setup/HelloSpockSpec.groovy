package setup

/**
 * Created by ian.lim on 8/9/2017.
 */
class HelloSpockSpec extends spock.lang.Specification {

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }
}
