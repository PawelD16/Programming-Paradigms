import scala.annotation.tailrec

def pascalTrapezoidF(n: Int) = {
  @tailrec
  def pascalTrapezoidFOuter(n: Int)(acc: List[Int]): List[Int] = {
    def pascalTrapezoidFInner(currList: List[Int])(is_middle: Boolean): List[Int] = currList match {
      case h1 :: h2 :: h3 :: t => if is_middle then (h1 + 2 * h2) :: pascalTrapezoidFInner(currList)(false)
                                  else (h1 + h2 + h3) :: pascalTrapezoidFInner(h2 :: h3 :: t)(false)
      case _ => if is_middle then 3 :: currList else currList
    }

    if n > 0 then pascalTrapezoidFOuter(n - 1)(pascalTrapezoidFInner(acc)(true))
    else acc.tail.reverse ::: acc
  }

  if n > 0 then pascalTrapezoidFOuter(n - 1)(List(1, 1)) else Nil
}

pascalTrapezoidF(-1)

pascalTrapezoidF(0)

pascalTrapezoidF(1)

pascalTrapezoidF(5)