import org.json4s._
import org.json4s.native.Serialization._
import org.json4s.native.Serialization
implicit val formats = Serialization.formats(NoTypeHints)

val m = Map(
  "name" -> "john doe",
  "age" -> 18,
  "hasChild" -> true,
  "childs" -> List(
    Map("name" -> "dorothy", "age" -> 5, "hasChild" -> false),
    Map("name" -> "bill", "age" -> 8, "hasChild" -> false)))

var a = write(m)
println(a)