type 'a lBT = LEmpty | LNode of 'a * 'a lBT Lazy.t * 'a lBT Lazy.t;;

let rec lmap (f, lBT) = match lBT with
	|LEmpty->LEmpty
	|LNode(v, lazy l, lazy r)->LNode(f v, lazy(lmap (f, l)), lazy(lmap (f, r)))
;;

let lprint_tree_int (lBT, max_level)= 
	let rec lprint_inner(lBT, curr_level, indent)= match lBT with
		|LNode(v,  lazy l, lazy r) when curr_level<max_level -> 
			print_string("\n"^indent);
			print_int(v);
			lprint_inner (l, curr_level+1, indent^"   ");
			lprint_inner (r, curr_level+1, indent^"   ");
		|_->LEmpty
in
	lprint_inner(lBT, 0, "")
;; 

let rec ltake (lBT, number_of_elems) = match lBT with
	|LNode(v, lazy l, lazy r) when number_of_elems>=0 -> v::ltake(l, number_of_elems-1)@ltake(r,number_of_elems-1)
	|_->[]
;;

let inf_tree =
	let rec inf_tree_builder n =
		let subtree = lazy(inf_tree_builder(n+1)) in
		LNode(n,subtree, subtree)
in
	inf_tree_builder 1
;;

let tt = LNode(1,
			lazy(LNode(3,
				lazy(LNode(7,
					lazy(LEmpty),
					lazy(LEmpty)
					)),
				lazy(LEmpty)
				)),
			lazy(LNode(0,
				lazy(LNode(1,
					lazy(LEmpty),
					lazy(LNode(8,
						lazy(LEmpty),
						lazy(LEmpty)
						))
					)),
				lazy(LEmpty)
				))	
		);;
		
let assymetrical_lazy_tree = LNode(0,lazy(LEmpty),lazy(LNode(1,lazy(LNode(2,lazy(LEmpty), lazy(LEmpty))),lazy(LEmpty))));;

lprint_tree_int(lmap((function x-> x*x), tt), 3);;
lprint_tree_int(lmap((function x-> x*x), inf_tree), 5);;
lprint_tree_int(lmap((function x->x*x), LEmpty),3);;
lprint_tree_int(lmap((function x->x*x), assymetrical_lazy_tree),3);;