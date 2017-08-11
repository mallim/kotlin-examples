package tutorial.model

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.*

@Entity @Table(name = "blog")
data class Blog(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title")
    var title: String? = null
)

@RepositoryRestResource
interface BlogRepository : JpaRepository<Blog, Long>

/**
 * Got this from https://github.com/tokuhirom/java-samples/tree/master/spring-boot-mybatis-kotlin
 */
@Mapper
interface BlogDao {
    @Select("""
        SELECT * FROM blog
    """)
    fun findAll(): List<Blog>

    @Select("""
        SELECT * FROM blog WHERE id=#{id}
    """)
    fun findById(@Param("id") id: Long): Blog
}
