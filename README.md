# 4448 Project 2 (based on Project 1)
### Contact information
 - Name: Leyen Qian (108384916)</br>
 - Email: jiqi2811@colorado.edu</br>
 - Team Members: Ziyue Guo (107037369), Puyuan Zhang (107207898)

### Files Description
1. Main.java  ( ./Main.java )</br>
the entry point of the program.</br>

2. dayatthezoo.out ( ./dayatthezoo.out )</br>
sample output (number of days: 7)</br>

3. Animal.java ( ./Animals/Animal.java )</br>
the abstract class inherited by all beast divisions (Canine, Feline, Pachyderm and Ursidae).

4. Canine, Feline, Pachyderm and Ursidae classes are inherited by animal speces under the breed directory respectively.</br>
( ./Animals/Canine/Breed.* )</br>
( ./Animals/Feline/Breed/* )</br>
( ./Animals/Pachyderm.Breed/* )</br>
( ./Animals/Ursidae/Breed/* )

5. Zoo.java ( ./Zoo/Zoo.java )</br>
zoo class can store all employee and animal instances.

6. ZooKeeper.java ( ./Zoo/Employee/Zookeeper.java )</br>
It inherites the ZooEmployee class from the partent dictory, and provides additional function that specific to zoo keeper, such as feed animals and roll call animals.

### Issue
It would be better to implement the random animal behavoirs by using the weighted random selection algorithm. But I found Java's design priciple on dictionary or key value pair are different than that in Python or C. Therefore, I choose to implement it with the random number function.