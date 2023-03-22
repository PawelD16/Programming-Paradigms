let pascal_trapezoid_l n =		(*n to srodek tablicy, korzystam z faktu, że tablica jest zawsze symetryczna (pomijając element środkowy, który nie ma swojego "lustrzanego odpowiednika" to dla każdego elementu tablicy nie wychodzącego poza zakres element n-x i n+x maja te sama wartość) i ma 2n+1 (czyli nieparzystą) ilość elementów*)
	if n<1 then [||] else
	let arr = Array.make (2*n+1) 1 in
	
	let pascal_trapezoid_l_inner num_of_row =
	
		let i = ref num_of_row in 
		while !i>0 do		(*ustawianie lewej części tablicy na prawidłowe wartości, wiedząc że jej prawa część będzie zawierała wartości z poprzedniej iteracji*)
			arr.(n-(!i)) <- arr.(n+(!i)-1) + arr.(n+(!i)) + arr.(n+(!i)+1);
			i:=!i-1
		done;
		
		arr.(n) <- arr.(n) + 2*arr.(n+1);		(*ustawianie środka na prawidłową wartość, korzystając z faktu symetryczności tablicy*)
			
		i:= num_of_row;
		while !i>0 do		(*ustawianie prawej części tablicy na prawidłowe wartości, kopiując lewą część*)
			arr.(n+(!i)) <- arr.(n-(!i));
			i:=!i-1
		done
in
	let x = ref 1 in 
	while !x<n do
		pascal_trapezoid_l_inner (!x-1);	(*zaczynamy z odpowiednio dużą tablicą wypełnioną jedynkami*)
		x:=!x+1
	done;
	
	arr
;;

pascal_trapezoid_l (-1);;

pascal_trapezoid_l 0;;

pascal_trapezoid_l 1;;

pascal_trapezoid_l 5;;

