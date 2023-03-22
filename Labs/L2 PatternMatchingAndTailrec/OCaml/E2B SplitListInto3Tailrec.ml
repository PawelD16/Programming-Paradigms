let split3Tail listToSplit = 
	let rec split3InnerTail (listToSplit, listA, listB, listC) = match listToSplit with
		|[]->(listA,listB,listC)
		|head::tail->split3InnerTail(tail, head::listB, listC, listA)
in
	split3InnerTail(listToSplit, [], [], []);;
	
split3Tail([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20]);;

split3Tail([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19]);;

split3Tail([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18]);;

split3Tail([1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11]);;

split3Tail([1; 2; 3; 4; 5; 6; 7; 8; 9; 10]);;

split3Tail([1; 2; 3; 4; 5; 6; 7; 8; 9]);;

split3Tail([1;2;3]);;

split3Tail([1;2]);;

split3Tail([1]);;

split3Tail([]);;