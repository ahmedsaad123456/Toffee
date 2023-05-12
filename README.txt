------- sure that the app see the files in DataBase foldar
 if you have an error , go to DataFiles package and in each class change the file path according to your PC -------

==========================================================================================================================================

Folders:
	docs: containes the java documentation.
	src:  containes the App.java that the main of the project
	      containes pakages as:
					DataFiles          : containes the all classes that manages the files 
						               that containes the all information needed in the project
					payment            : containes classes that manages the payment process 
					ShoppingCart       : containes classes that manages the making order process 
					user_info_manamnet : containes classes that manages the Authountcation process

==========================================================================================================================================
Some notes for dealing with the program:
    - make the terminal bigger to see the whole output
    - the registration and login menu will appear every action until enter 4 to exit 
    - first you must register for new account and the program will display the menu for the shopping
    - you can see the catalog without login or registration
    - if you exit the program after the registration you can run again and just log in
    - the shopping the main menu will appear every action until enter 6 to log out
    - in the shopping you can see the catalog and its items
    - you can see your shopping cart if it exists
    - to add items to the shopping cart , you must enter the item id and the quantity
    - if the item is already in the shopping cart , you can increment the quantity only
    - to make order you must have shopping cart 
    - to pay for order you must have order