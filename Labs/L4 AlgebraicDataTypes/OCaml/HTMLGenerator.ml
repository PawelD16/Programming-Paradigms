type htmlTag = AString of string
			|Paragraph of htmlTag list
			|OrderedList of htmlTag list
			|UnorderedList of htmlTag list
			|H1 of htmlTag list
			|H2 of htmlTag list
			|H3 of htmlTag list
			|H4 of htmlTag list
			|H5 of htmlTag list
			|H6 of htmlTag list
			|NewLine
;;

let rec indent_to_string indent = if indent  > 0 then "   " ^ indent_to_string (indent-1) else ""
;;

let rec html_tags_to_string indent tag =
	let next l = print_list (indent+1) l false ^ "\n" ^ indent_to_string indent in
	let nextList l = print_list (indent+1) l true ^ "\n" ^ indent_to_string indent in
	
	("\n" ^ indent_to_string indent) ^
	(match tag with
		|AString(text) -> text
		|Paragraph(l) -> "<p>" ^ next l ^ "</p>"
		|OrderedList(l) -> "<ol>" ^ nextList l ^"</ol>"
		|UnorderedList(l) -> "<ul>" ^ nextList l ^ "</ul>"
		|H1(l) -> "<h1>" ^ next l ^ "</h1>"
		|H2(l) -> "<h2>" ^ next l ^ "</h2>"
		|H3(l) -> "<h3>" ^ next l ^ "</h3>"
		|H4(l) -> "<h4>" ^ next l ^ "</h4>"
		|H5(l) -> "<h5>" ^ next l ^ "</h5>"
		|H6(l) -> "<h6>" ^ next l ^ "</h6>"
		|NewLine -> "<br>")
	
and print_list indent l is_in_list = match l with
	|[] -> ""
	|h::t -> (if is_in_list then "\n" ^ indent_to_string indent ^ "<li>"  ^ html_tags_to_string (indent+1) h ^ "\n" ^ indent_to_string indent ^ "</li>"
			else indent_to_string indent ^ html_tags_to_string indent h ^ indent_to_string indent) 
			^ print_list indent t is_in_list
;;

let build title tag_list = 
	let rec inner_build tag_list = match tag_list with
		|[] -> ""
		|h::t -> html_tags_to_string 2  h ^ inner_build t
in
	Printf.printf "%s%s%s%s%s%!" "<!DOCTYPE html>\n<html>\n   <head>\n      <title>" title "</title>\n   </head>\n   <body>" (inner_build tag_list) "\n   </body>\n</html>\n"
;;

build "tytul" 
[H1[AString "naglowek1"];
Paragraph[H2[AString "naglowek2"]; NewLine; H3[AString "naglowek3"]; AString "paragraf"];
OrderedList[
	UnorderedList[
		OrderedList[
		Paragraph[AString "test"; AString "test2" ]];
	AString "element1"; AString "element2"; AString "element3"];
	Paragraph[AString "paragraf2"]; AString "text"]]
