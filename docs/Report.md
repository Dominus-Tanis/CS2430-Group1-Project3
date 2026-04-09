# Final Report

Group 1  
**Group Members**: Spencer Peck, Dallin Yauney, Ben Shaw, Cory Neilsen.  
CS 2430 Semester 2  
Knapsack Problem & Optimal Selection

## Introduction

## Methods

### Rating-first

### Weight-first

### Ratio-first

### Brute-force

This method involved nested loops to check all permutations of the possible experiment. For each experiment, a subset of the experiment was created that did not include the previous selected experiment, for each of those in the subset another subset is created that does not include that selected experiment, and from that subset for each element an experiment is added alongside the previously selected experiments. This results in every possible combination of the experiments, from which the top three are selected.
In order to dynamically determine the possible number of permutations, which is relevant to how many times the first and second loop operate, a left bit shift operation is used. The first instance of this is "1<< n" where n is equal to the amount of experiments that available to be compared. Translating this to more common math we get the following equation: $1*2^n$ 
Bit manipulation method to generate all subsets adapted from:
https://www.geeksforgeeks.org/dsa/backtracking-to-find-all-subsets/

### Dynamic Programming

This approach calculates the optimal rating for each possible weight (0, 1, 2, ..., 700). It starts with only one experiment, then adds in the rest one by one. Each new experiment, instead of starting the calculations from scratch, calculates based on the previous accumulation of experiments. This is what theoretically makes it so efficient - you don't have to compare every possible combination, which is exponential time, you just have to try adding in each experiment once at every weight.  
Why do we do the calculations for every possible weight? Suppose a heavy but valuable experiment gets added late in the process. The total experiment weight exceeds the maximum, but it would be worth it to replace some of the other experiments with this one. We can calculate the total payload value by adding this heavy, valuable experiment to the value of the previous experiments, *at a much lower weight* so the resulting payload would be possible.

The way I checked that it was working correctly as I was developing it was to have a separate, much simpler test case with only a couple of experiments and a much smaller weight limit so I could examine the DP table itself. Once I felt right about the test case, and the results for the real experiments were not only correct but better than I could do by hand, I decided that was good enough. Later I found out that the brute-force solution matched the DP solution, which confirmed that my algorithm was correct.

## Results
### Greedy vs Brute-force Results
Some of the greedy strategies got close to the optimal (brute-force) solution - the Lightest-first approach got a rating of 52. Very close to the brute-force 53, and it did it much faster! I guess you could say that in the knapsack problem, getting the last 5% of the rating requires 95% of the work. Some of the greedy methods didn't perform nearly as well, but it's faster to run them all and find the best result than to do any of the other methods, so they definitely have their place.

### Flaws in Greedy Strategies
The greedy strategies optimize for only one thing, and that makes them dumb. If I tried packing up to move houses by picking up an object and putting it in the moving van, then going back inside and trying again, I'd be packing for days! The issue with the greedy strategies is the same: there's no organization, compartmentalization, or coordination of effort. The greedy strategies don't understand how to swap out one medium-weight object for two lighter objects with worse ratios to fill the slight gap in available weight. One could try to find better heuristics to use for the greedy strategies, but their lack of context-awareness means they'll never match up with the more comprehensive approaches.

### Scalability of Brute-force vs Dynamic Programming
The current brute-force approach, by my calculations, is actually faster than the dynamic programming algorithm for the given experiments. The brute force, while exponential, only performs $2^{12}=4096$ operations, while the DP algorithm takes $12 \cdot 700 = 8400$ operations, more than double! The scalability of the DP algorithm, on the other hand, is much more favorable, increasing only linearly with new experiments, rather than exponentially. It would only take 2 more experiments for the tables to flip completely, and any real knapsack calculation would have hundreds or thousands of options to weigh. With 350 experiments and 700 kg, for example, the DP solution would be roughly a googol times more efficient. If the options are brute-force or DP, the scalable solution is going to be DP every time.

### Challenger: A New Plausible Approach
Our worst-performing algorithm was the rating-first approach, in large part because there are several experiments with the same rating, but vastly different weights. By default, the algorithm has no way to sort between these, choosing more or less randomly. Letting this algorithm break the tie between different 8-rated experiments, choosing the one with the least weight, ended up performing nearly 30% better: it went from 35 points with no extra logic to 45 points choosing the lightest of the best-rated experiments. Not nearly as well as the lightest-first solution, but a big improvement, and I theorize that on sets with a greater difference in score (rather than being 4-9) this improvement would only grow.

## Discussion

## Conclusion

## Summary of Work Done / Lessons Learned

## Sources
