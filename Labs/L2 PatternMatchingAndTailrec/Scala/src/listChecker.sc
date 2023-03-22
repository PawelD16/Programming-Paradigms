def find[A](list: List[A])(element: A): Boolean =
  list match {
  case Nil => false
  case head :: _ if head == element => true
  case _ => find(list.tail)( element)
}

val find123 = find(List(1, 2, 3))


find(List(List(), List(), List()), List())

find(List(1, 2, 3), 1)

find(List(1, 2, 3), 0)

find(List(1, 2, 3), Nil)

find(List(List(1, 2, 3), Nil), List(1, 2, 3))

find123(3)

find(List(1, 2, 3), Nil)

find(List(), List())

find(Nil, 7)