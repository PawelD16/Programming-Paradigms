let plus x y = x+y;;
let multfloat x y = x*.y;;

let l = [1;2;3;4];;
let lfloat = [1.0;2.0;3.0];;
let l_two_elems = [1;2];;

(*________________________________________________________________________*)
let (>=>) l f = match l with 
	|h1::h2::t -> List.rev (List.fold_left (fun acc x -> (f (List.hd acc) x)::acc) [f h1 h2] t)
	|_ -> []
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

(*nieparzyste*)
print_endline "\nnieparzyste:";;
let l2float = lfloat>=>( *. );;
l2float>=>( *. );;

lfloat>=>multfloat >=> (fun x y -> x*.y);;

(*przypadki skrajne*)
print_endline "\nskrajne:";;
l_two_elems>=>(+);;
[1]>=>(+);; (*nie ma pary, zwracamy listę pustą*)
[]>=>(+);;