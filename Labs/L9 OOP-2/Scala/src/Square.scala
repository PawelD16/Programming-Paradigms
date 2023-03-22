class Square(private val a: Double) extends Figure :
  require(a > 0, "Squares cannot have negative sized sides")

  def side1: Double = a

  override def circumference: Double = 4 * a

  override def toString: String = s"Circumference: $circumference Side1: $a"