let rec remove(givenList, elementIndex)=
  if elementIndex < 0 then givenList
  else if givenList == [] then givenList
  else if elementIndex >0 then List.hd givenList::remove(List.tl givenList, elementIndex-1)
  else List.tl givenList;;
  
  remove(0::1::2::3::4::5::[],3);;
  
  remove(0::1::2::3::4::5::[],0);;
  
  remove(0::1::2::3::4::5::[],5);;
  
  remove(0::1::2::3::4::5::[],10);;
  
  remove(0::1::2::3::4::5::[],-2);;
  
  remove([],0);;

  
