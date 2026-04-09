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

The brute-force strategy generates every possible payload configuration and keeps track of the three highest-rated configurations. Each unique payload is a subset of the set of 12 experiments, so there are $2^{12}=4096$ possible payloads. This is represented in the first for loop of the bruteForce method with parameters (i = 0; i < (1 << n). The (1 << n) operation takes the bit representation of 1 and moves it to the left by n places, filling the empty spaces created to the right with 0s. This is equivalent to $1*{2^n}$. Because we have 12 experiments, n=12, so the operation is (1 << 12), meaning that the bit representation of 1 is shifted 12 spaces to the left, so it becomes 1 followed by 12 0s or $1*{2^{12}}=4096$. This means that i iterates from 0 to 4095 or through all possible permutations for 12 bits. The second for loop iterates over each position in the array of experiments (0-11), then the if statement uses the same << operation to convert the position to a bit representation and uses the bitwise & operator to confirm whether or not the bit is set in the current iteration of i. If it is, then it is added to the payload. Once a payload is constructed, a check happens on the payload to make sure it is less than or equal to 700kg, then it is compared to the top three recorded so far.

Bit manipulation method to generate all subsets adapted from:
https://www.geeksforgeeks.org/dsa/backtracking-to-find-all-subsets/

### Dynamic Programming

This approach calculates the optimal rating for each possible weight (0, 1, 2, ..., 700). It starts with only one experiment, then adds in the rest one by one. Each new experiment, instead of starting the calculations from scratch, calculates based on the previous accumulation of experiments. This is what theoretically makes it so efficient - you don't have to compare every possible combination, which is exponential time, you just have to try adding in each experiment once at every weight.  
Why do we do the calculations for every possible weight? Suppose a heavy but valuable experiment gets added late in the process. The total experiment weight exceeds the maximum, but it would be worth it to replace some of the other experiments with this one. We can calculate the total payload value by adding this heavy, valuable experiment to the value of the previous experiments, *at a much lower weight* so the resulting payload would be possible.

The way I checked that it was working correctly as I was developing it was to have a separate, much simpler test case with only a couple of experiments and a much smaller weight limit so I could examine the DP table itself. Once I felt right about the test case, and the results for the real experiments were not only correct but better than I could do by hand, I decided that was good enough. Later I found out that the brute-force solution matched the DP solution, which confirmed that my algorithm was correct.

## Results

## Discussion

## Conclusion

## Summary of Work Done / Lessons Learned

## Sources
