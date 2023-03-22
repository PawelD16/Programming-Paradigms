import scala.annotation.tailrec

def permutationsL[T](list: LazyList[T]): LazyList[LazyList[T]] = {
  @tailrec
  def permutationsL_inner(list: LazyList[T])(list_of_permutations: LazyList[LazyList[T]]): LazyList[LazyList[T]] = list match {
    case LazyList() => list_of_permutations
    case h #:: t => permutationsL_inner(t)(distribute(h)(list_of_permutations))
  }

  def distribute(elem: T)(list_of_permutations: LazyList[LazyList[T]]): LazyList[LazyList[T]] = {
    @tailrec
    def distribute_inner(beginList: LazyList[T])(list_to_add: LazyList[T])(acc: LazyList[LazyList[T]]): LazyList[LazyList[T]] = list_to_add match {
      case LazyList() => (elem #:: beginList) #:: acc
      case h #:: t => distribute_inner(h #:: beginList)(t)((list_to_add #::: (elem #:: beginList)) #:: acc)
    }

    list_of_permutations match
      case LazyList() => LazyList()
      case h #:: t => (for (x <- distribute_inner(LazyList())(h)(LazyList())) yield x) #::: distribute(elem)(t)
    }


  permutationsL_inner(list)(LazyList(LazyList()))
}

for (x <- permutationsL(LazyList.from(1).take(4)).toList) yield x.take(4).toList

for (x <- permutationsL(LazyList('a', 'b', 'c')).toList) yield x.take(25).toList

for (x <- permutationsL(LazyList()).toList) yield x.take(4).toList
