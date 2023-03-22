let pascal_trapezoid_f n = 
	let rec pascal_trapezoid_f_outer n acc = 
		let rec pascal_trapezoid_f_inner curr_list = match curr_list with
			|h1::h2::h3::t -> (h1 + h2 + h3) :: pascal_trapezoid_f_inner (h2::h3::t)
			|_ -> curr_list
	in
		if n>0 then pascal_trapezoid_f_outer (n-1) (1::1::pascal_trapezoid_f_inner acc) else acc
in
	if n>0 then pascal_trapezoid_f_outer (n-1) [1; 1; 1] else []
;;	

pascal_trapezoid_f (-1);;

pascal_trapezoid_f 0;;

pascal_trapezoid_f 1;;

pascal_trapezoid_f 2;;

pascal_trapezoid_f 3;;

pascal_trapezoid_f 4;;

pascal_trapezoid_f 5;;



let pascal_trapezoid_f_2 n = 
	let rec pascal_trapezoid_f_outer n acc = 
		let rec pascal_trapezoid_f_inner curr_list is_middle = match curr_list with
			|h1::h2::h3::t -> if is_middle then  (h1 + 2*h2) :: pascal_trapezoid_f_inner (curr_list) (false) 
								else (h1 + h2 + h3) :: pascal_trapezoid_f_inner (h2::h3::t) (false)
			|_ -> if is_middle then 3::curr_list else curr_list
	in
		if n>0 then pascal_trapezoid_f_outer (n-1) (pascal_trapezoid_f_inner acc true) 
			else List.rev(List.tl acc)@acc
in
	if n>0 then pascal_trapezoid_f_outer (n-1) [1; 1] else []
;;	

pascal_trapezoid_f_2 (-1);;
				  
pascal_trapezoid_f_2 0;;
				  
pascal_trapezoid_f_2 1;;

pascal_trapezoid_f_2 2;;

pascal_trapezoid_f_2 3;;

pascal_trapezoid_f_2 4;;
				  
pascal_trapezoid_f_2 5;;