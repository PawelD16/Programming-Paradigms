let rec find (givenList, elementToFind) = match givenList with
	|[]->false
	|head::_ when head = elementToFind ->true
	|_->find (List.tl givenList, elementToFind);;
	
let find123 element = find ([1;2;3, element)

find([]::[]::[], []);;

find([1; 2; 3], 1);;

find([1; 2; 3], 0);;

find([[1;2;3]; []], [1;2;3]);;

find123(3);;

find([], []);;

find([], 7);;
	
	