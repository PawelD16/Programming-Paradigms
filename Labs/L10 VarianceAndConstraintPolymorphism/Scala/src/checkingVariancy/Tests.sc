//listy są kowariantne, wnioskujemy to z poniższego przykładu
//dzięki temu, że listy są niemodyfikowalne to taka operacja nie jest niebezpieczna
//gdyż pomimo współdzielenia pamięci nie będziemy mogli przypisać np.
//stringa do listy z intami w czasie działania programu
//poprzez zmianę wartości w liście która współdzielimy.
//Oznacza to, że kompilator jest w stanie zagrawarantować nam poprawność typu
val listOfInts = List(1, 2, 3)
val listOfAny: List[Any] = listOfInts //kowariantny!
val listOfAny2 = 2.3 :: listOfAny
val listOfInts2: List[Int] = listOfAny2 //NIE KONTRAWARIANTNY!

//przeciwnie działają struktury modyfikowalne jak tablice
val arrayOfInts = Array(1, 2, 3)
val arrayOfAny: Array[Any] = arrayOfInts //widać, że tablica nie jest kowariantna
val arrayOfAny2: Array[Any] = Array(1, 2.4)
val arrayOfInts2: Array[Int] = arrayOfAny2 //ani kontrawariantna, więc inwariantna