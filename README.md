# DatabaseTableGUI
A Database table using javax.swing and java.awt where you can Add,Remove,Search for Available data based on ID and Sort 

# Table of Contents

* [App class ](https://github.com/Cavani99/DatabaseTableGUI/tree/main#app-class)
* [Entity class](https://github.com/Cavani99/DatabaseTableGUI/tree/main#entity-class)
* [Table Model class](https://github.com/Cavani99/DatabaseTableGUI/tree/main#tablemodel)
* [Frame class](https://github.com/Cavani99/DatabaseTableGUI/tree/main#frame)
    - [The Frame](https://github.com/Cavani99/DatabaseTableGUI/tree/main#the-frame)
    - [Init Pagination method](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#initpagination)
    - [Last,Next,Previous,First buttons](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#lastnextpreviousfirst-buttons)
    - [Add Student button](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#add-student-button)
    - [Search by ID button](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#search-by-id-button)
    - [Remove button](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#remove-button)
    - [Refresh button](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#refresh-button)
    - [autoResizeColumn method](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#autoresizecolumn-method)
* [Service class](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#service)
    - [insert command](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#insert-command)
    - [find commands](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#find-commands)
    - [count commands](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#count-commands)
    - [order commands](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#order-commands)
    - [remove commands](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#remove-command)
* [How to use for you database table](https://github.com/Cavani99/DatabaseTableGUI?tab=readme-ov-file#how-to-use-for-your-database-table-)
    - [Changes in App class](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#changes-in-app-class)
    - [Changes in Entity/Student class](https://github.com/Cavani99/DatabaseTableGUI?tab=readme-ov-file#changes-in-entitystudent-class)
    - [Changes in Frame class](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#changes-in-frame-class)
    - [Changes in Service class](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#changes-in-service-class)
    - [Changes in TableModel class ](https://github.com/Cavani99/DatabaseTableGUI/tree/main?tab=readme-ov-file#changes-in-tablemodel-class)

---
## App class
Here is where we use the information for the database to connect to the Service,
and also initialize  a new Frame with a TableModel.

![img.png](img.png)

---
## Entity class

We hold the information about the rows of an individual database
entry.Currently, it's a student data,and every student has an id,
first name,last name and department.

![img_1.png](img_1.png)

---

## TableModel 

This is where the **Table** with the students is made.
Every student is saved in a List of Students.There are methods
for adding a student("save" method),editing,deleting,finding based on 
id and getting the number of students.

---
## Frame

The information for the JFrame.We use the TableModel,the DataService,
and some buttons,labels,comboBox. 

## The Frame

![img_5.png](img_5.png)

In initComponents() we add the components and make the layout.In
initPagination(),we decide which elements are printed to the 
table and how they are sorted.

### initPagination()
![img_2.png](img_2.png)
![img_3.png](img_3.png)

### Last,Next,Previous,First buttons

We get the entries depending on the button,if possible
![img_4.png](img_4.png)

### Add Student button

This happens in the **jButtonAddActionPerformed()** method.You have to write
the ID first,then first name,last name,and finally the department the student is
studying in.This is done using an InputDialog.

![img_6.png](img_6.png)

You have to write a valid ID,to continue to the next information.
A **valid ID** needs to consist only of numbers,be exactly 6 symbols long and not 
to be used already. First we search if the ID has any character,not being a number.
If it does,we get this message!

![img_7.png](img_7.png)

If the **ID** is not exactly 6 symbols:
![img_8.png](img_8.png)

If the **ID** is 6 symbols consisting only by numbers,we then 
look if it already exists in the database,If it does:
![img_9.png](img_9.png)

Else it's considered valid, and you can continue to write the First Name and then Last Name.
They are valid if they are not empty(there are more than 0 characters).Same can
be said for the department.

![img_10.png](img_10.png)
![img_11.png](img_11.png)
![img_12.png](img_12.png)

If everything is valid the new student is added to the database and to
the table, and you get this message:
![img_13.png](img_13.png)

![img_14.png](img_14.png)

You can also cancel adding a new entry whenever you want.
![img_15.png](img_15.png)

### Search by ID button

**jButtonSearchActionPerformed()** is used for that.I use the boolean
variable **refresh** to get only the student with this ID.

When the ID is present:
![img_16.png](img_16.png)

If the ID doesn't exist:

![img_17.png](img_17.png)

### Sort button

![img_18.png](img_18.png)

In **jButtonSortActionPerformed()**.You get the options to sort by ID,First Name,Last Name or Department.It depends on the value 
of the input and if the value is not equal to either **0,1,2 or 3** ,nothing happens.The ordering
happens in initPagination() (or the call for the order), in this method only the boolean variables are changed.

Ordered by Department:
![img_19.png](img_19.png)

### Remove button

Using the **jButtonRemoveActionPerformed()** method.The students
are removed by given ID value,because it's unique.

![img_20.png](img_20.png)

If the ID doesn't exist:

![img_21.png](img_21.png)

If the student is removed successfully:
![img_22.png](img_22.png)


### Refresh button
It simply makes the boolean variable **refresh** to **false** which 
allows to show all the entries.
![img_23.png](img_23.png)

### autoResizeColumn method

Used for more dynamic resizing of the different columns.

---
## Service

This is where we make connection with the database if possible and use it.
In every method,first we try to make a connection and when successful ,the
intended operation is done,otherwise we get an information about the error.
SQL queries are used to manipulate the Database.

### insert command:
In the **save(Student student)** method we add a new entry to the database,which is executed 
after we use valid characters for the ID,Names and Department in the **Add button**.

![img_24.png](img_24.png)

### find commands:

**findall(page,pageSize)** is used to get all the students from the database.
![img_25.png](img_25.png)

**find(id)** is almost the same,but 
It's used to get only the student with the given ID. **Exists(id)** is also simular,
but it returns a boolean value(if a student with this ID exists,it returns true ,otherwise
its false).

### count commands:
Returns the number of entries in the database.

![img_26.png](img_26.png)

**countOne(id)** returns only 1 or 0(if a student with **id** exists ,its **1** otherwise it returns **0**).

### order commands:
Used to order the data based on either ID,First or Last Name ,or Department.

Order by ID:

![img_27.png](img_27.png)

### remove command:
Delete a student with this **ID** from the Database - **remove(id)**) .

![img_28.png](img_28.png)

---

## How to use for your database table :

### Changes in App class
* Use your data source information

  ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/fc160b3b-9171-4cf6-acdd-60148979f6c5)

### Changes in Entity/Student class

* Change the variables based on your columns in your database table, with the right data types.Also you can modify the getter/setter methods.

  ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/08770d80-9e35-41b5-8405-8996779210e4)
  
* Change the information in **toString()** method

### Changes in Frame class

* in [jButtonAddActionPerformed()](https://github.com/Cavani99/DatabaseTableGUI/blob/main/DatabaseTableGUI/src/Frame.java#L321) you can keep the ID validator, if you want, but it only accepts exactly 6 digits ,if you want to fix that modify the **len** variable
    - for validating a varchar non-nullable column you can just use the Names or Department validator ,but just change the variable and the text.
    - I also added a date validator(for a date like yyyy-mm-dd),if you need to use it :
      ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/4d173007-6751-4384-9c78-e65440d69943)
* In [jButtonSortActionPerformed()](https://github.com/Cavani99/DatabaseTableGUI/blob/main/DatabaseTableGUI/src/Frame.java#L519) :
    - change the text here ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/c80c1d87-75f0-4837-8254-817653a6ad7e)
    - add boolean values, based with which column you want to sort:
      
       ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/9a425edb-7226-46e5-a5ce-7cd6efcd9844)

    Then set them to true, and all other values to false, based on the sort text you wrote from one picture above.You may need to add more boolean variables or cases in the switch ,if you have more sort options. 

    ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/f7ff40a9-75d5-4b51-bb6f-d5e7081e91a4)

* In [initPagination()](https://github.com/Cavani99/DatabaseTableGUI/blob/main/DatabaseTableGUI/src/Frame.java#L49) you need to add your sort variables, and also your OrderByColumn() method  located in the Service class like this(see the OrderByColumn  explanation in **In Service class** header).

    ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/48176b12-eba9-4363-b2ec-86ed9821e83d)

### Changes in Service class

* In the queries use your **Table name** and the **name of the columns** you use. If your table is cars, change students to cars , or if the id is car_id, change the Student_ID to car_id.

    ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/7a0a1027-56ad-4582-8cbe-ab9544c6785e)

* Also in the ResultSet use your column names and the right types.
  ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/74b05ab3-f00d-41fa-9c76-dd309438f262)

* In the **OrderByColumn** (where **Column** is the column you want to order by) just change the table to your table and the column you want to use to order
  ![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/694e372f-58ba-4b69-994a-206b182ee93f)

### Changes in TableModel class 

* In the HEADER variable, add the column names you want.

![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/22437a48-16f8-4a03-81a3-9c224b01e551)

* In the [getValueAt()](https://github.com/Cavani99/DatabaseTableGUI/blob/main/DatabaseTableGUI/src/TableModel.java#L57) add the getters of your columns, if you want. 

---
Using other database table:

![image](https://github.com/Cavani99/DatabaseTableGUI/assets/75423586/95735d3e-191f-47f6-a65a-0e90de1062a7)








  









