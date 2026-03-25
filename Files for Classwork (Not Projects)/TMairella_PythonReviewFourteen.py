# Practice Activities for Lesson 14 Notes
import random
n = random.randint(1, 50)

# 1. Write a recursive function that counts up to a random number (MAX 50).
def countup(n):
    if n == (50):
        print("Done!")
    else:
        print(n)
        countup(n + 1)

# 2. Write an iterative version of factorial for a random number (MAX 50).
def factorial_iterative(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

# 3. Question: What is the Big-O of a simple loop?
# Answer: O(n)

# 4. Question: What is the Big-O of a nested loop?
# Answer: O(n^2)