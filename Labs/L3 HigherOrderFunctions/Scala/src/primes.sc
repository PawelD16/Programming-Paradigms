def primes(n: Int) = for (x <- List.range(2, n + 1)
                          if (for (y <- List.range(2, Math.sqrt(x).toInt + 1); if x % y == 0) yield y) == Nil) yield x

print(primes(29000))
primes(8)
primes(7)
primes(2)
primes(1)
primes(0)
primes(-10)

/*
def primes(n: Int) = {
  if n < 2 then Nil
  //else List.range(2, n + 1) diff (for (x <- List.range(2, n + 1); y <- List.range(x + 1, n + 1); if y % x == 0) yield y) //złożoność diff to O(n+m)
  //else List.range(2, n + 1) diff (for (x <- List.range(2, n + 1); y <- List.range(2, x); if x%y == 0) yield x)
  //else for(a<-List.range(1,n+1);b<- for (x <- List.range(2, n + 1); y <- List.range(2, x); if x%y == 0) yield x;if a==b) yield a
  else {
    val xss = for (x <- List.range(2, n + 1); y <- List.range(2, x); if x % y == 0) yield x
    for(a<- List.range(2,n+1); if !xss.contains(a)) yield a
  }
}
//print(primes(29000))
primes(20)
primes(7)
primes(2)
primes(1)
primes(0)
primes(-1)
*/