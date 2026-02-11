import math

# Ask for name
name = input("Enter name: ")
print(f"Hello {name} :D")

# Get numbers
num1 = int(input("Enter first number: "))
num2 = int(input("Enter second number (Put 0 if √): "))

# Get operation
operation = input("Enter Operation (+,-,*,/,^,(√)): ")

# Perform calculation
if operation == "+":
    print("Your answer is:", num1 + num2)
elif operation == "-":
    print("Your answer is:", num1 - num2)
elif operation == "*":
    print("Your answer is:", num1 * num2)
elif operation == "/":
    if num2 == 0:
        print("Error: Division by zero")
    else:
        print("Your answer is:", num1 / num2)
elif operation == "^":
    print("Your answer is:", math.pow(num1, num2))
elif operation == "√":
    print("Your answer is:", math.sqrt(num1))
else:
    print("Invalid operation")
