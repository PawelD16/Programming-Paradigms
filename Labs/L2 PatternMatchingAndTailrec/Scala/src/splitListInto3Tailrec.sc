import scala.annotation.tailrec
/*
def split3Tail[A](listToSplit: List[A]): (List[A], List[A], List[A]) = {

  @tailrec
  def reverseArray(list: List[A], resultList: List[A]): List[A] = {
    if list == Nil then resultList
    else reverseArray(list.tail, list.head :: resultList)
  }

  @tailrec
  def lengthCounter(list: List[A], length: Int): Int = {
    if list == Nil then length
    else lengthCounter(list.tail, length + 1)
  }

  val x = lengthCounter(listToSplit, 0)

  @tailrec
  def split3InnerTail(elementCounter: Int, listToSplit: List[A], listA: List[A], listB: List[A], listC: List[A]): (List[A], List[A], List[A]) = listToSplit match {
    case Nil => (listA, listC, listB)
    case head :: tail => {
      //print(elementCounter)
      //print(listA)
      //println(elementCounter < Math.ceil(x / 3.0).toInt)
      if elementCounter < Math.ceil(x / 3.0) then split3InnerTail(elementCounter + 1, tail, head :: listA, listB, listC)
      else split3InnerTail(0, listToSplit, listB, listC, listA)
    }
  }

  split3InnerTail(0, reverseArray(listToSplit, Nil), Nil, Nil, Nil)
}
*/

def split3Tail[A](listToSplit: List[A]): (List[A], List[A], List[A]) = {

  @tailrec
  def split3InnerTail(listToSplit: List[A], listA: List[A], listB: List[A], listC: List[A]): (List[A], List[A], List[A]) = listToSplit match {
    case Nil => (listA, listB, listC)
    case head :: tail => split3InnerTail(tail, head::listB, listC, listA)
  }

  split3InnerTail(listToSplit, Nil, Nil, Nil)
}

split3Tail(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))

split3Tail(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19))

split3Tail(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18))

split3Tail(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))

split3Tail(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

split3Tail(List(1, 2, 3, 4, 5, 6, 7, 8, 9))

split3Tail(List(1, 2, 3))

split3Tail(List(1, 2))

split3Tail(List(1))

split3Tail(List())

