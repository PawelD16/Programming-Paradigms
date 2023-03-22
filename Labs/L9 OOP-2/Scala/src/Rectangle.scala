class Rectangle(a: Double, private val b: Double) extends Square(a) :
  require(a > 0 && b > 0, "Rectangles cannot have negative sized sides")

  def side2: Double = b

  override def circumference: Double = 2 * a + 2 * b

  override def toString: String = s"${super.toString} kupa: $b"