import math

try:
    numamount = int(input("How many numbers do you want to enter? "))
    numbers = []
    for i in range(numamount):
        num = int(input("Enter a number: "))
        numbers.append(num)
except ValueError:
    print("Please enter valid integers.")

def get_sum(numbers):
    return sum(numbers)

def get_average(numbers):
    return sum(numbers) / len(numbers)

def get_max(numbers):
    return max(numbers)
    
def get_min(numbers):
    return min(numbers)

def get_sqrt(get_average):
    return math.sqrt(get_average)

print("The sum of the numbers is:", get_sum(numbers))
print("The average of the numbers is:", get_average(numbers))
print("The maximum number is:", get_max(numbers))
print("The minimum number is:", get_min(numbers))
print("The square root of the average is:", get_sqrt(get_average(numbers)))