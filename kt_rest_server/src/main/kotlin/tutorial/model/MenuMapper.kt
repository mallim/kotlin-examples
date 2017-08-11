package tutorial.model;

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface MenuMapper {

    @Select("SELECT COUNT(*) FROM menus")
    fun count(): Long

    @Select("""
    SELECT
       restaurant_id as id,
       title,
       menu_date as date,
       menu_text as text
    FROM menus
    WHERE id = #{id}
    """)
    fun getOne( @Param("id") id: Long ): Menu
}
