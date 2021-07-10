# Help Window
### Gabriel Fernandez COP3330
#### For Rey, who just wanted to do a better job at destroying  
#### our sanity by suggesting that we include this
### Using the Add Button
In order to use the Add button, the user must have selected a date
that is not before the current date. Additionally, the user must have
written a brief description between 1 and 256 characters. If any of these
conditions are not met, the program will display an error message and prevent
the data the user has inputted from being inputted into the list.

If the data inputted is valid, the data will then be displayed inside the To-Do
tab.

### Using the Delete Button
The Delete button is only able to be used when the user highlights with their mouse an item from either
the To-Do table or the Completed Table. Obviously, if there is no data inside of either
table, nothing can be highlighted, and thus nothing can be deleted.

Once the user has highlighted the desired item they wish to delete, they can press the Delete button to remove
it from the table.

_Note: Due to the fact that there are two tables, and both tables can have one item highlighted at any
given time, it is possible to delete an item in the To-Do table and Completed table simultaneously_

### The Mark (In)Complete Button
As the name implies, this button is capable of transferring the selected data
to either the To-Do table, or the Completed table. To use, the user must have
already inputted data into the table. Then, once the user selects the item
they wish to move with their mouse, they can press the Mark (In)Complete button
to move it to the other table.

_Note: As with the delete button, it is possible to have two items selected, one in each table, the way
the program handles this issue is by prioritizing marking an item as complete (rather than incomplete)
so the item that is currently inside the To-Do table will be moved to the Completed table_
### Using the Clear button
Pressing this button clears all data inside of both the To-Do and Completed tables.

### Editing the Tables
The user can edit a task via selecting a task from the To-Do table and pressing the edit
button. Tasks selected from the completed table can not be edited due to the fact they are
already complete.

Upon selecting a task and pressing the Edit button, the contents of the task that was
selected will appear in the DatePicker and the TextField, where the user can then update them
as they wish. Once content with their changes. The user can press the Add Task button,
and see the edited task be added to the bottom of the To-Do table.

### Using the Display Menu
#### Display All
The Display All menu item allows the user to view both the Completed and To-Do tables
simultaneously. Upon being pressed, both tables will appear side by side.
#### Display Complete
The Display Complete menu item, as it's name implies, displays only the Completed items
of the current list. Once selected, only the completed list items will be displayed.
#### Display Incomplete
The Display Incomplete menu item, upon being selected, only displays the current list's
incomplete items, which are represented by the To-Do table.

### Using the File Menu
**SAVING (and therefore loading) IS NOT POSSIBLE**

In the file menu, the user can choose to save the contents of the list they have created
as an executable .jar file in their computer using the File Explorer.
#### Save
Upon pressing this button, the file explorer on the user's computer will be opened, allowing
the user to choose where they want to save their To-Do list. The list will be an executable
.jar file, which the user can then access any time and open as they wish.
#### Open
This button simply opens the file explorer, allowing the user to go to the directory where
they saved the file, and open it via selecting the file and pressing open.
