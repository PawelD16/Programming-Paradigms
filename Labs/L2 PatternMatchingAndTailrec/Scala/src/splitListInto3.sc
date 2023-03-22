/*
def split3Rec[A](listToSplit: List[A]): (List[A], List[A], List[A]) = {

  @tailrec
  def lengthCounter(list: List[A], length: Int): Int = {
    if list == Nil then length
    else lengthCounter(list.tail, length + 1)
  }

  val x = lengthCounter(listToSplit, 0)


  def split3InnerRec(elementCounter: Int, listToSplit: List[A]): (List[A], List[A], List[A]) =
    listToSplit match {
      case Nil => (Nil, Nil, Nil)
      case head :: tail =>
        val tuple = split3InnerRec(elementCounter + 1, tail)
        if elementCounter < Math.ceil(x / 3.0) then (head :: tuple._1, tuple._2, tuple._3)
        else if elementCounter < 2.0 * Math.ceil(x / 3.0) then (tuple._1, head :: tuple._2, tuple._3)
        else (tuple._1, tuple._2, head::tuple._3)
    }

  split3InnerRec(0, listToSplit)
}
*/

def split3Rec[A](listToSplit: List[A]): (List[A], List[A], List[A]) = listToSplit match {
  case Nil => (Nil, Nil, Nil)
  case head :: tail =>
    val (t1, t2, t3) = split3Rec(tail)
    (head :: t2, t3, t1)
}

split3Rec(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))

split3Rec(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19))

split3Rec(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18))

split3Rec(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))

split3Rec(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

split3Rec(List(1, 2, 3, 4, 5, 6, 7, 8, 9))

split3Rec(List(1, 2, 3))

split3Rec(List(1, 2))

split3Rec(List(1))

split3Rec(List())