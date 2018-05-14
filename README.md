# LIST-Implementation-Linked-Cells

Data Structures Assignment for LIST Abstract Data Type (Implemented with Linked Cells)

LIST ADT has an operation to put an element into the list, to take an element out, and to retrieve an element without altering data structure. It has an operation telling how many elements are stored in the list and a boolean to tell if it is empty or not. It has an operation to make an empty list.

This implementation is a doubly linked list.

In the Node class, there is a next and prev field. The next field points to the cell that follows the current cell in the list and the prev field points to the cell that came before the current one in the list. To go through the list item by item in the "forward" direction, start with the first cell and use the next field until you get to the end of the list. You can traverse the list "backwards" by going to the last cell and following the prev links until you get to the first cell, since it is doubly linked.

The sentinel does not contain any data value. This makes checking for end-of-list easier and assists in eliminating many null pointer errors.

The LIST will provide this collection of operations:

clear:

  ```
     in: nothing
     
     return: void
     
     effect: 
         - list is left with size 0, no elements in it,
         - contains just the original root Node
  ```            
size:
  ```
    in: nothing
    
    return: number of elements stored in the list
    
    effect: no change to list state
  ```
isEmpty:
  ```
    in: nothing
    
    return: boolean, true if the list has no elements in it, true is size is 0
    
    effect: no change to list state
  ```
insert:
  ```  
    in: a double (the data element), and an int (position index)
    
    return: boolean, return true if insert is successful, false otherwise
    
    effect: 
         - the list state will be altered so that the element is located at the
            specified index; 
         - the list's size increases by 1;
         - all elements that were at the specified index or after have been moved down one slot
            
    error: if index is beyond list size range then return false
           valid inserts take place either at a location where a list element
           already exists, or at the location that is one beyond the last element
  ```
remove:
  ```
    in: an int (the index of the element to take out of the list)
    
    return: boolean. If the remove is successful then return true, else return false
    
    effect: 
         - list state is altered in that the Node at the specified index is decoupled
         - list size decreases by one
            
    errors: If specified index is not in the list then return false
  ```
get:
  ```
    in: an int (the index of the element item to return)
    
    return: double, the element stored at index, or Double.NaN
    
    effect: no change in state of the list
    
    error: If index is not in the list then return Double.NaN
  ```
