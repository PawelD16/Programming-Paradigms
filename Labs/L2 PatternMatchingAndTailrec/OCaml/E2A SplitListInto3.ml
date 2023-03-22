let k_3 (a,b,c) = c;;
let k_1 (a,b,c) = a;;
let k_2 (a,b,c) = b;;
let rec split3Rec listToSplit = match listToSplit with
	|[]->([],[],[])
	|head::tail->
		let tuple = split3Rec(tail) in
		(head :: k_2 tuple, k_3 tuple, k_1 tuple)
;;
split3Rec([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20]);;
	  
split3Rec([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19]);;
	  
split3Rec([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18]);;
	  
split3Rec([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11]);;
	  
split3Rec([1; 2; 3; 4; 5; 6; 7; 8; 9; 10]);;
	  
split3Rec([1; 2; 3; 4; 5; 6; 7; 8; 9]);;
	 
split3Rec([1;2;3]);;
	 
split3Rec([1;2]);;
	  
split3Rec([1]);;
	  
split3Rec([]);;