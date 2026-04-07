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

### Dynamic Programming

This approach calculates the optimal rating for each possible weight (0, 1, 2, ..., 700). It starts with only one experiment, then adds in the rest one by one. Each new experiment, instead of starting the calculations from scratch, calculates based on the previous accumulation of experiments. This is what theoretically makes it so efficient - you don't have to compare every possible combination, which is exponential time, you just have to try adding in each experiment once at every weight.  
Why do we do the calculations for every possible weight? Suppose a heavy but valuable experiment gets added late in the process. The total experiment weight exceeds the maximum, but it would be worth it to replace some of the other experiments with this one. We can calculate the total payload value by adding this heavy, valuable experiment to the value of the previous experiments, *at a much lower weight* so the resulting payload would be possible.

The way I checked that it was working correctly as I was developing it was to have a separate, much simpler test case with only a couple of experiments and a much smaller weight limit so I could examine the DP table itself. Once I felt right about the test case, and the results for the real experiments were not only correct but better than I could do by hand, I decided that was good enough. Later I found out that the brute-force solution matched the DP solution, which confirmed that my algorithm was correct.

## Results

## Discussion

## Conclusion

## Summary of Work Done / Lessons Learned

## Sources
