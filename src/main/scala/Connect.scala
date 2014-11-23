import java.sql._

// Entity
class Book {
  var id: Long = _
  var isbn: Long = _
  var name: String = _
  var date: Date = _
  override def toString = {
    "id: " + id + "* name: " + name + " isbn: " + isbn + " date: " + date
  }
}

object Connect extends App{

  val url = "jdbc:mysql://localhost:3306/scala_test_db"
  val driver = "com.mysql.jdbc.Driver"
  val userName = "root"
  val userPassword = "root"

  var connection:Connection = _
  var listBook = scala.collection.mutable.ArrayBuffer[Book]()

  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, userName, userPassword)
    val statement = connection.createStatement
    val res = statement.executeQuery("SELECT * FROM books")
    while(res.next){
      //create book
      val book = new Book
      book.id = res.getInt("id")
      book.isbn = res.getInt("isbn")
      book.name = res.getString("name")
      book.date = res.getDate("date")
      //add book to list
      listBook += book
    }
  }catch {
    case e: Exception => e.getMessage
  } finally  {
    //print all book
    listBook.foreach{
      book => println(book.toString)
    }
    connection.close
  }
}


