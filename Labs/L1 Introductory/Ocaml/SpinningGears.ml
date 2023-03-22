let rotations givenList =
  let rec rotationsRec givenList = 
    let x = List.hd (List.tl givenList) in
    if (List.tl (List.tl givenList)) == [] then (-1.0) *. (float_of_int (List.hd givenList))/.(float_of_int x)
    else if x == 0 then 0.
    else if x>0 then (-1.0)*.rotations(List.hd givenList::(List.tl (List.tl givenList)))
    else rotations(List.hd givenList::(List.tl (List.tl givenList)))
in
  if givenList == [] then 0.
  else rotationsRec(givenList);;

  
rotations([10; 20; 30; 12]);;
rotations([10; 20; -30; 12]);;
rotations([10; 20; 30; 12; 15]);;
rotations([10; 0; 30; 12]);;
rotations([5; 7; 3; 2; 10]);;
rotations([-5; -7; -3; -2; -10]);;
rotations [10];;
rotations([]);