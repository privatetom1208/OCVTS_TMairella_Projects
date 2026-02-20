# Challenge 3 Starter Code
numbers = []

# Loop asking user for 5 numbers and add them to the list
while True:
    if len(numbers) < 5:
        try:
            num = int(input("Enter a number: "))
            numbers.append(num)
        except ValueError:
            print("Please enter a valid number:")
    else:
        if len(numbers) == 5:
            total = sum(numbers)
            average = total / len(numbers)
            print(f"Sum: {total}, Average: {average}")
        break

# 1. What causes a ValueError? 
# A invalid input that cannot be converted to an integer causes a ValueError.

# 2. Difference between while and for loops?
# A while loop is always executed as long as the condition is true, while a for loop is executed a specific number of times based on the iterable.

# 3. Why is error handling important?
# Error handling is important because it allows the program to continue running even when an error occurs, preventing the program to crash. It also further helps in debugging and maintaining the code.