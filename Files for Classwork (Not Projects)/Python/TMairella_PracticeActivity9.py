import numpy as np

# Practice Activity 1: Create an array of test scores
test_scores = np.array([85, 90, 78, 92, 88])
print("Test Scores:", test_scores)

# Practice Activity 2: Find the average score
total_scores = sum(test_scores)
average_score = total_scores / len(test_scores)
print("Average Score:", average_score)

# Practice Activity 3: Double each value in the array
test_scores_doubled = test_scores * 2
print("Doubled Test Scores:", test_scores_doubled)

# Practice Activity 4: Create a 2D array and access values
matrix = [
    [1, 2, 3],
    [4, 5, 6]
]
print("Matrix:", matrix)
print("Value at row 0, column 1:", matrix[0][1])