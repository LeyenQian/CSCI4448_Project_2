# 4448 Project 2 (based on Project 1)
### Contact information
 - Name: Leyen Qian (108384916)</br>
 - Email: jiqi2811@colorado.edu</br>
 - Team Members: Yi Hou (109288627), Ziyue Guo (107037369)

### Files Description
 - Main.java  ( ./Main.java )</br>
the entry point of the program.</br>

 - dayatthezoo.out ( ./dayatthezoo.out )</br>
sample output (number of days: 7)</br>

 - Animal.java ( ./Animals/Animal.java )</br>
the abstract class inherited by all beast divisions (Canine, Feline, Pachyderm and Ursidae).

 - Canine, Feline, Pachyderm and Ursidae classes are inherited by animal speces under the breed directory respectively.</br>
( ./Animals/Canine/Breed.* )</br>
( ./Animals/Feline/Breed/* )</br>
( ./Animals/Pachyderm.Breed/* )</br>
( ./Animals/Ursidae/Breed/* )

 - Panda.java (./Animals/Ursidae/Breed/Panda.java)
For the eat method, it uses the one provided by the UrsidaeDelegation, instead the one that inherited from Animal.

 - Observer and Subject (./Zoo/Observer/*)
Interface used for observer patten.

 - Constants.java (./Zoo/Employee/Constants.java)
It defines the flags used in observer patten and times for ZooClock.

 - Zoo.java ( ./Zoo/Zoo.java )</br>
zoo class can store all employee and animal instances.

 - ZooKeeper, ZooFoodServer and ZooAnnouncer ( ./Zoo/Employee/* )</br>
It inherites the ZooEmployee class from the partent dictory, and provides additional function that specific to zoo keeper, such as feed animals and roll call animals. Any of them can be subject or observer (need to implement the corresponding interface)

 - ZooClock.java (./Zoo/ZooClock.java)</br>
ZooClock is the main subject, ZooKeeper, ZooFoodServer are the direct observers of it. Their behaviors are decided by ZooClock.