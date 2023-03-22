type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec ltake = function
 (0, _) -> []
 | (_, LNil) -> []
 | (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs)
;; 

let rec to_lazy_list = function
 [] -> LNil
 | x :: xs -> LCons(x, lazy (to_lazy_list xs))
;;

let rec lcombine (lxs, rxs, f) = match (lxs, rxs) with
	|(LCons(h1, lazy t1),LCons(h2,lazy t2)) -> LCons(f h1 h2, lazy(lcombine(t1, t2, f)))
	|(LCons(h, lazy t),_) -> LCons(h, lazy(t))
	|(_, LCons(h, lazy t)) -> LCons(h, lazy(t))
	|_-> LNil
;;

let rep = 45;;

ltake(rep,lcombine(lfrom 3, lfrom 7, (+)));;

ltake(rep, lcombine(lfrom 3, to_lazy_list[1;2;3;4], (-)));;

ltake(rep, lcombine(to_lazy_list[0;0;0;0], lfrom 3, ( * )));;

ltake(rep, lcombine(to_lazy_list["a";"b";"c";"d"], to_lazy_list["e";"f";"g";"h"], (^)));;

ltake(rep, lcombine(to_lazy_list[0;0;0;0], LNil, (+)));;

ltake(rep, lcombine(LNil, LNil, (+)));;


