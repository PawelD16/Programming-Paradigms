let plus x y = x+y;;
let multfloat x y = x*.y;;

let l = [1;2;3;4];;
let lfloat = [1.0;2.0;3.0];;
let l_two_elems = [1;2];;

(*________________________________________________________________________*)
let rec (>=>) l f = match l with
	|h1::h2::t -> let n = f h1 h2 in
		n::((>=>) (n::t) f)
	|_ -> []
;;

let rec collapse l f = match l with
	|[] |[_]-> l
	|_->collapse (l>=>f) f
;;
(*________________________________________________________________________*)

(*pomaga zrozumieć działanie operatora*)
print_endline "\ndługa lista:";;
["t";"e";"s";"t";" ";"n";"o";"r";"m";"a";"l";"n";"i";"e"] >=> (^);;

(*parzyste*)
print_endline "\nparzyste:";;
let l2 = l>=>(+);;
let l3 = l2>=>(+);;
l3>=>(+);;

l>=>(+)>=>plus>=>(fun x y -> x+y);;

collapse l (+);;

(*nieparzyste*)
print_endline "\nnieparzyste:";;
let l2float = lfloat>=>( *. );;
l2float>=>( *. );;

lfloat>=>multfloat >=> (fun x y -> x*.y);;

collapse lfloat ( *. );;

(*przypadki skrajne*)
print_endline "\nskrajne:";;
l_two_elems>=>(+);;
[1]>=>(+);; (*nie ma pary, zwracamy listę pustą*)
[]>=>(+);;

collapse l_two_elems (+);;
collapse [1] (+);; (*lista jest od razu jednoelementowa, więc nie wykonujemy ani razu >=>*)
collapse [] (+);;