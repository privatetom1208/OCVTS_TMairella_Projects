# Challenge 2 Starter Code
user_input = input("Enter a word: ").lower()

length = len(user_input)
print(length)

if length > 5:
    print("Too long!")
else:
    print("Short word!")

print(user_input.upper())

# 1. What does len() return?
# len() returns the number of characters within the string, including spaces and punctuation.

# 2. Why must input be cast before math operations?
# It has to be cast because input() returns a string, and math operations require numbers. So if you do math on a string you'll get an error. By casting it to a number (like int or float), you can perform math operations on it.

# 3. What operator checks equality?
# The operator that checks equality is ==.