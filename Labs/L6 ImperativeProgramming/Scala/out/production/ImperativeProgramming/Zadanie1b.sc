def pascalTrapezoidL(n: Int) = {
  if n < 1 then Array[Int]() else {
    val arr = Array.fill(2 * n + 1)(1)

    def pascalTrapezoidLInner(numOfRow: Int): Unit = {
      var i = numOfRow
      while i > 0 do
        arr(n - i) = arr(n + i - 1) + arr(n + i) + arr(n + i + 1)
        i -= 1
      end while

      arr(n) = arr(n) + 2 * arr(n + 1)

      i = numOfRow
      while i > 0 do
        arr(n + i) = arr(n - i)
        i -= 1
      end while
    }

    var x = 1
    while x < n do
      pascalTrapezoidLInner(x - 1)
      x += 1
    end while

    arr
  }
}


pascalTrapezoidL(-1)

pascalTrapezoidL(0)

pascalTrapezoidL(1)

pascalTrapezoidL(5)