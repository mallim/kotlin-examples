package tutorial.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity @Table(name = "restaurants")
data class Restaurant(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    var name: String? = null,

    var location: String? = null,

    var lat: Double? = null,

    var lng: Double? = null,

    @OneToMany(mappedBy = "restaurant")
    var menus: List<Menu>? = null
)

@RepositoryRestResource
interface RestaurantRepository : JpaRepository<Restaurant, Long>
