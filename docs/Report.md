# Final Report

Group 1  
**Group Members**: Spencer Peck, Dallin Yauney, Ben Shaw, Cory Neilsen.  
CS 2430 Semester 2  
Knapsack Problem & Optimal Selection

## Introduction
In this project we were tasked with implementing ways of solving a rendition of the knapsack problem. The knapsack problem involves finding the best combination of items to include given capacity restrictions of some kind. This can be anything from what is the most important items to store in a hiking bag, to what tasks should be worked on given a limited amount of time. In this project we were faced with the question of what scientific experiments should be included in the payload of a rocket headed to space.

## Methods
We implemented several different methods of filling the payload, these methods ranged from selecting experiments based on single parameters to testing every single possible combination in a brute force method.
Each experiment had an identifier and two parameters; how much it weighed and the rating of how valuable that experiment was considered to be.

### Rating-first
This method looked at the list of experiments and selected which ones would be included in the payload based on which remaining experiments had the highest rating. This strategy reflects someone trying to pack the most valuable items first regardless of any other factors.

This was accomplished by looping through the list to find the highest rated experiment that would not pass the weight limit and adding it to the payload.

### Weight-first
This strategy involved selecting the experiments based on which one weighed the least. This strategy reflects the mindset that regardless of importance filling the space with the highest number of items will end in a better result.
This was also accomplished by looping through the list of experiments to find the lightest item, which was then added to the payload, without breaking the weight constraints of the rocket payload.

### Rating-Weight Ratio-first
Ratio first combines the two approaches and selects what experiments will be entered into the payload based on the ratio of the importance of the item and the weight of the item. 
As with the other two greedy strategies this method involved looping through the experiments and finding the item who had the best weight / rating ratio.


### Brute-force

The brute-force strategy generates every possible payload configuration and keeps track of the three highest-rated configurations. Each unique payload is a subset of the set of 12 experiments, so there are $2^{12}=4096$ possible payloads. This is represented in the first for loop of the bruteForce method with parameters (i = 0; i < (1 << n). The (1 << n) operation takes the bit representation of 1 and moves it to the left by n places, filling the empty spaces created to the right with 0s. This is equivalent to $1*{2^n}$. Because we have 12 experiments, n=12, so the operation is (1 << 12), meaning that the bit representation of 1 is shifted 12 spaces to the left, so it becomes 1 followed by 12 0s or $1*{2^{12}}=4096$. This means that i iterates from 0 to 4095 or through all possible permutations for 12 bits. The second for loop iterates over each position in the array of experiments (0-11), then the if statement uses the same << operation to convert the position to a bit representation and uses the bitwise & operator to confirm whether or not the bit is set in the current iteration of i. If it is, then it is added to the payload. Once a payload is constructed, a check happens on the payload to make sure it is less than or equal to 700kg, then it is compared to the top three recorded so far.

Bit manipulation method to generate all subsets adapted from:
https://www.geeksforgeeks.org/dsa/backtracking-to-find-all-subsets/

### Dynamic Programming

This approach calculates the optimal rating for each possible weight (0, 1, 2, ..., 700). It starts with only one experiment, then adds in the rest one by one. Each new experiment, instead of starting the calculations from scratch, calculates based on the previous accumulation of experiments. This is what theoretically makes it so efficient - you don't have to compare every possible combination, which is exponential time, you just have to try adding in each experiment once at every weight.  
Why do we do the calculations for every possible weight? Suppose a heavy but valuable experiment gets added late in the process. The total experiment weight exceeds the maximum, but it would be worth it to replace some of the other experiments with this one. We can calculate the total payload value by adding this heavy, valuable experiment to the value of the previous experiments, *at a much lower weight* so the resulting payload would be possible.

The way I checked that it was working correctly as I was developing it was to have a separate, much simpler test case with only a couple of experiments and a much smaller weight limit so I could examine the DP table itself. Once I felt right about the test case, and the results for the real experiments were not only correct but better than I could do by hand, I decided that was good enough. Later I found out that the brute-force solution matched the DP solution, which confirmed that my algorithm was correct.

## Results

## Discussion
### Greedy vs Brute-force Results
Some of the greedy strategies got close to the optimal (brute-force) solution - the Lightest-first approach got a rating of 52. Very close to the brute-force 53, and it did it much faster! I guess you could say that in the knapsack problem, getting the last 5% of the rating requires 95% of the work. Some of the greedy methods didn't perform nearly as well, but it's faster to run them all and find the best result than to do any of the other methods, so they definitely have their place.

### Flaws in Greedy Strategies
The greedy strategies optimize for only one thing, and that makes them dumb. If I tried packing up to move houses by picking up an object and putting it in the moving van, then going back inside and trying again, I'd be packing for days! The issue with the greedy strategies is the same: there's no organization, compartmentalization, or coordination of effort. The greedy strategies don't understand how to swap out one medium-weight object for two lighter objects with worse ratios to fill the slight gap in available weight. One could try to find better heuristics to use for the greedy strategies, but their lack of context-awareness means they'll never match up with the more comprehensive approaches.

### Scalability of Brute-force vs Dynamic Programming
The current brute-force approach, by my calculations, is actually faster than the dynamic programming algorithm for the given experiments. The brute force, while exponential, only performs $2^{12}=4096$ operations, while the DP algorithm takes $12 \cdot 700 = 8400$ operations, more than double! The scalability of the DP algorithm, on the other hand, is much more favorable, increasing only linearly with new experiments, rather than exponentially. It would only take 2 more experiments for the tables to flip completely, and any real knapsack calculation would have hundreds or thousands of options to weigh. With 350 experiments and 700 kg, for example, the DP solution would be roughly a googol times more efficient. If the options are brute-force or DP, the scalable solution is going to be DP every time.

### Challenger: A New Plausible Approach
Our worst-performing algorithm was the rating-first approach, in large part because there are several experiments with the same rating, but vastly different weights. By default, the algorithm has no way to sort between these, choosing more or less randomly. Letting this algorithm break the tie between different 8-rated experiments, choosing the one with the least weight, ended up performing nearly 75% better: it went from 26 points with no extra logic to 45 points choosing the lightest of the best-rated experiments. Not nearly as well as the lightest-first solution, but a big improvement, and I theorize that on sets with a greater difference in score (rather than being 4-9) this improvement would only grow.

## Conclusion

## Summary of Work Done / Lessons Learned

## Sources
