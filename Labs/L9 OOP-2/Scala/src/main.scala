@main
def main(): Unit = {
  val square = Square(5)
  println(square)
  println(square.side1)
  println(square.circumference)

  val rectangle = Rectangle(4, 3.75)
  println(rectangle)
  println(s"${rectangle.side1} ${rectangle.side2}")
  println(rectangle.circumference)

  val splitter = Splitter(12.0)
  splitter.figure = Square(5.0)

  val copyOfBigFiguresList = splitter.bigFiguresList

  splitter.figure = Square(3.0)

  println(splitter.smallFiguresList)
  println(splitter.bigFiguresList)
  println(copyOfBigFiguresList)

  println(splitter.figure)

  try
    Square(-5)
  catch
    case e: Throwable => e.printStackTrace()

  try
    Rectangle(-4, 3.75)
  catch
    case e: Throwable => e.printStackTrace()

  try
    Splitter(-2)
  catch
    case e: Throwable => e.printStackTrace()
}