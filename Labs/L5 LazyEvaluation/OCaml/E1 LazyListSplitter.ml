type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons (k, function () -> lfrom (k+1));;

let rec ltake (n, lxs) = match (n, lxs) with
	|(0, _) -> []
	|(_, LNil) -> []
	|(n, LCons(x,xf)) -> x::ltake(n-1, xf())
;;

let rec to_lazy_list llist = match llist with
	|[] -> LNil
	|h::t -> LCons(h, function () -> to_lazy_list t)
;;

let rec lsplit llist  = match llist with
	|LNil -> LNil,LNil
	|LCons(h1, t1) -> match t1() with
		|LNil -> LCons(h1, function()->LNil), LNil
		|LCons(h2, t2) -> 
			let f = function()->lsplit(t2()) in
			LCons(h1, fun () -> fst(f())), LCons(h2, fun () -> snd(f()))
;;

let repeat_outer n ll =
	let rec repeat (n, node) = match ll with
		LNil -> node
		|LCons(v, _) when n >0-> LCons(v, function() -> repeat(n-1, node))
		|LCons(v, next) -> next()
in
	repeat (n, ll);;

let (t01,t02) = (lsplit (lfrom 0));;
ltake(45,t01);;
ltake(45,t02);;

let (t11, t12) = lsplit (to_lazy_list ['a';'b';'c']);;

ltake(4,t11);;
ltake(4,t12);;

let (t21,t22) = lsplit (LNil);;

ltake(4,t21);;
ltake(4,t22);;