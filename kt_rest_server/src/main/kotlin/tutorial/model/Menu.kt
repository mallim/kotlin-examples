package tutorial.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity @Table(name = "menus")
data class Menu(

   @Id @GeneratedValue(strategy = IDENTITY)
   var id: Long? = null,

   @ManyToOne
   @JoinColumn(name = "restaurant_id")
   var restaurant: Restaurant? = null,

   @Column(name = "menu_date", columnDefinition = "DATE")
   var date: LocalDate? = null,

   var title: String? = null,

   @Column(name = "menu_text")
   var text: String? = null
)

@RepositoryRestResource
interface MenuRepository : JpaRepository<Menu, Long>
