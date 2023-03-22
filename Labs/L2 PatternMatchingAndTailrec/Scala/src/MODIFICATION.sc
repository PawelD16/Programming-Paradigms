def remove[A](listToReplace: List[A])(index: Int): List[A] =
  listToReplace match {
  case Nil => Nil
  case _ :: t if index == 0 => t
  case h :: t => h :: (remove (t) (index - 1))
}

remove(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))( 4)
remove(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))( -4)
remove(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))( 9)
remove(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))( -4)

remove (Nil) (4)
remove(List())(-4)
remove(List())(0)