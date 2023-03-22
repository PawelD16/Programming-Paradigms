def pascalTrapezoidF(n: Int) = {
  def pascalTrapezoidFOuter(n: Int)(acc: List[Int]): List[Int] = {
    def pascalTrapezoidFInner(currList: List[Int]): List[Int] = currList match {
      case h1 :: h2 :: h3 :: t => (h1 + h2 + h3) :: pascalTrapezoidFInner(h2 :: h3 :: t)
      case _ => currList
    }

    if n > 0 then pascalTrapezoidFOuter(n - 1)(1 :: 1 :: pascalTrapezoidFInner(acc)) else acc
  }

  if n > 0 then pascalTrapezoidFOuter(n - 1)(List(1, 1, 1)) else Nil
}

pascalTrapezoidF(-1)

pascalTrapezoidF(0)

pascalTrapezoidF(1)

pascalTrapezoidF(5)