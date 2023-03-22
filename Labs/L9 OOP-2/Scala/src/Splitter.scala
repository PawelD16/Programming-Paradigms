class Splitter(private val thresholdFromSmallToBig: Double):
  require(thresholdFromSmallToBig >= 0, "The threshold cannot be a negative number")

  private var smallFigures: List[Figure] = Nil
  private var bigFigures: List[Figure] = Nil

  def smallFiguresList: List[Figure] = smallFigures
  def bigFiguresList: List[Figure] = bigFigures

  def figure = ()

  def figure_=(figure: Figure) =
    if (figure.circumference >= thresholdFromSmallToBig) bigFigures ::= figure
    else smallFigures ::= figure