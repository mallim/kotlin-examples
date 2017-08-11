package tutorial

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.Instant
import tutorial.model.RestaurantRepository

/**
 * Our very first controller
 */
@RestController
class FirstController( val restaurantRepository: RestaurantRepository ) {

    /** The ultimate answer to life, the universe and everything */
    @GetMapping("/answer")
    fun answer() = 42

    /** Get the details of a user */
    @GetMapping("/user")
    fun getUser() : User {
        val user = User(
                username = "grahamcox",
                screenName = "Graham",
                email = "grahamcox@example.com",
                registered = Instant.now()
        )
        return user
    }

    /**
     * Perform some string manipulation on the given value
     * @param value The value to manipulate
     * @param operation The operation to perform
     */
    @GetMapping("/string/{value}")
    fun manipulateString(@PathVariable("value") value: String,
                         @RequestParam(name = "operation", defaultValue = "none") operation: String) : String {
        return when (operation.toUpperCase()) {
            "REVERSE" -> value.reversed()
            "UPPER" -> value.toUpperCase()
            "LOWER" -> value.toLowerCase()
            else -> value
        }
    }

    /**
     * Pretend to create a new user
     * @param user The details of the user to create
     */
    @PostMapping(value = "/user")
    fun createUser(@RequestBody user: NewUser): User {
        return User(
                username = user.username,
                screenName = user.screenName,
                email = user.email,
                registered = Instant.now()
        )
    }

    @GetMapping("/count")
    fun count() = restaurantRepository.count()

    /** Handle the error */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleError(e: IllegalArgumentException) = e.message
}
