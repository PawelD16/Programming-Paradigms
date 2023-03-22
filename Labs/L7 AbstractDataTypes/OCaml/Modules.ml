type order = LT|EQ|GT;;


module type COMPARATOR=
sig
	type t
	val compare: t -> t -> order
end;;


module StringLengthComparator:COMPARATOR with type t = string =
struct
	type t = string
	let compare s1 s2 = 
	let sl1 = String.length s1 in
	let sl2 = String.length s2 in
						
		if sl1< sl2 then LT
			else if sl1>sl2 then GT
				else EQ
end;;


module IntComparator:COMPARATOR with type t = int =
struct
	type t = int
	let compare s1 s2 =
	if s1<s2 then LT
		else if s1>s2 then GT
			else EQ
end;;


module PriorityQueueImpl (Comparator: COMPARATOR) =
struct

	type t = Comparator.t
	
	type heap = {mutable arr: t option array; mutable size:int; mutable max_size: int}
	
	let create n =
		let temp = if n <= 0 then Int.abs(n)+1 else n in
		{arr = Array.make temp None; size = 0; max_size = temp}
	
	let resize queue = 
		let new_size = 2 * queue.max_size in
		let i = ref (queue.max_size - 1) in
		let temp_arr = Array.make new_size None in
		
		while !i>=0 do
			temp_arr.(!i) <- queue.arr.(!i);
			i:=!i-1
		done;
		
		queue.arr <- temp_arr;
		queue.max_size <- new_size
		
		
	let swap (arr, l, r) =
		let temp = arr.(l) in
		arr.(l) <- arr.(r);
		arr.(r) <- temp
		
		
	let parent pos = (pos - 1) / 2
	
	
	let left_child pos = (2 * pos) + 1
	
	
	let right_child pos = (2 * pos) + 2
	
	
	let is_leaf (pos, size) = (pos >= (size / 2) && pos < size)
	
	
	let rec remake_heap_at (pos, queue) = match (queue.arr.(pos), queue.arr.(left_child pos), queue.arr.(right_child pos)) with
	
		|(Some current, Some left, Some right) when not(is_leaf(pos, queue.size)) ->(
			if Comparator.compare current left != GT && Comparator.compare current right != GT then () else
			
			if Comparator.compare left right == LT then
			(
				swap(queue.arr, pos, left_child pos);
				remake_heap_at (left_child pos, queue)
			)
			else
			(	
				swap(queue.arr, pos, right_child pos);
				remake_heap_at (right_child pos, queue)
			)
		)
		|_->()
				
		
	let insert (new_elem, queue) = 
	
		if queue.max_size <= queue.size then resize queue;
		
		queue.arr.(queue.size) <- Some new_elem;
		
		let temp = ref queue.size in
		queue.size <- queue.size + 1;
		
		while(Comparator.compare (Option.get queue.arr.(!temp)) (Option.get queue.arr.(parent (!temp))) == LT) do 
			swap(queue.arr, !temp, parent(!temp));
			temp := parent(!temp);
		done
		
		
	let retrieve queue = 
		if queue.size <= 0 then None else
		let temp = queue.arr.(0) in
		queue.size <- queue.size - 1;
		queue.arr.(0) <- queue.arr.(queue.size);
		if queue.size > 0 then remake_heap_at(0, queue);
		queue.arr.(queue.size) <- None;
		
		temp
		
end;;	


module type PRIORITY_QUEUE =
sig
	type t
	type heap
	val create: int -> heap
	val insert: t * heap -> unit
	val retrieve: heap -> t option
end;;


module PriorityQueue(Comparator: COMPARATOR): PRIORITY_QUEUE with type t = Comparator.t = PriorityQueueImpl(Comparator);;

module PriorityQueueInt = PriorityQueue(IntComparator);;

let q0 = PriorityQueueInt.create 10;;

PriorityQueueInt.insert (2, q0);;
			 
PriorityQueueInt.insert (10, q0);;
			 
PriorityQueueInt.insert (1, q0);;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.insert (130, q0);;
			 
PriorityQueueInt.insert (0, q0);;
			 
PriorityQueueInt.insert (9, q0);;
			 
PriorityQueueInt.insert (7, q0);;
			 
PriorityQueueInt.insert (130, q0);;
			 
PriorityQueueInt.insert (20, q0);;
			 
PriorityQueueInt.insert (13, q0);;
			 
PriorityQueueInt.insert (13, q0);;
			 
PriorityQueueInt.insert (-2, q0);;
			 
PriorityQueueInt.insert (-4, q0);;
			 
PriorityQueueInt.insert (-94, q0);;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;
			 
PriorityQueueInt.retrieve q0;;


	
(*

let dec_to_bin x =
	let rec d2b y lst = match y with 
		|0 -> lst
		|_ -> d2b (y/2) ((y mod 2)::lst)
in
	d2b x []
;;


module PrioirtyQueueImpl =
struct
	type 'a node = {mutable value: 'a option; mutable parent: 'a node option; mutable left_child: 'a node option; mutable right_child: 'a node option}
	type 'a queue_type = {mutable root: 'a node; mutable size: int}
	
	let create = let root = {value = None; parent = None; left_child = None; right_child = None} in
					{root; size = 0}
	
	
	let insert (new_value, queue) = 
		let rec insert_inner (curr_node, directions_list) = match directions_list with
			|0::[] ->  curr_node.left_child <- Some ({value = new_value; parent = curr_node; left_child = None; right_child = None})
			|1::[] -> curr_node.right_child <- Some ({value = new_value; parent = curr_node; left_child = None; right_child = None})
			|0::t -> insert_inner (Some (curr_node.left_child), t)
			|1::t -> insert_inner (Some (curr_node.right_child), t)
		
					
	in				
		match queue.size with
			|0 -> queue.root.value <-new_value
			|_ -> insert_inner(queue.root, List.tl (dec_to_bin queue.size+1))
			(*size++*)
		
		

end;;
*)