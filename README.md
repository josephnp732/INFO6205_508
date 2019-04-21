# Team 508 - Using Genetic Algorithm Technique to solve 0/1 Knapsack algorithm 
PSA Project (INFO 6205) - Team 508 - Knapsack Problem

## Knapsack Algorithm:
The knapsack problem or rucksack problem is a problem in combinatorial optimization: Given a set of items, each with a weight and a value, determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible. It derives its name from the problem faced by someone who is constrained by a fixed-size knapsack and must fill it with the most valuable items.

## Project Application:
One example where Knapsack algorithm is used is the preparation for exam paper just a night before exam. Indian students are mastered in applying the Knapsack solution while exam preparation. Let me explain how.

What is our thinking just a night before exams? Get more marks by less study in the remaining amount of hours. Right? So, here we are trying to optimize our efforts for getting more marks. Now, we analyze our previous question papers and decide that which chapters have more value and which chapters have less. We also have a sense that how much time it will take to complete the chapter by checking the number of pages of the chapter in the book.

Here we are trying to maximize the marks by selecting the chapters whose questions have a high probability of asking in the exams. And also we have to consider the hours required to complete these chapters. Now we check all the combinations of chapters and their values to find the list of chapters that needs to be studied and also, add the hours required to study these chapters so the added hours should not exceed the hours we have for the exam.

This approach of solving the problem for exam preparation is analogous to the 0/1 Knapsack algorithm in which the student either skips the whole chapter and studies the whole chapter.

But wait! The story is not over yet. There are some daredevils among us who further want to reduce their efforts for getting more marks. They still ponder over the previous question papers and realize that some parts of the chapter have more value but not the whole chapter. So they try to fragment chapter into sections and chose only those sections who have high probability of asking in the exams.

Here they find the highly expected questions in the exams and also find the time required for them. Now, they find the ratio of marks for the question and the time required for it.

* *marksForQuestiontime/RequiredForQuestion* *

They arrange the ratios into their descending order. Now they select the first question in the order because they know that it is highly expected and it gives them more marks and also it requires less time. And they prepare for the questions one by one in the given order until the hours they have until the exam are completely utilized.

This approach is much more efficient in time and efforts. It is again analogous to the Greedy Knapsack algorithm in which student breaks the chapters into sections to maximize the marks in the given amount of hours.

#### Resources:
1. https://qr.ae/TWTujY 
2. https://en.wikipedia.org/wiki/Knapsack_problem 
