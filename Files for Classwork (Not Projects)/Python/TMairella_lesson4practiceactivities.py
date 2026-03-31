# Practice Activity 1
def square_number():
    userNum = int(input("Enter number: "))
    return userNum * userNum
print(square_number())

# Practice Activity 2
def sepchar():
    name = input("Enter your name: ")
    for char in name:
        print(char)
sepchar()

# Practice Activity 3
def gen_random_numbers():
    answer = input("Do you want to generate 5 random numbers? (yes/no): ").lower()
    if answer == "yes":
        import random
        for i in range(5):
            print(random.randint(1, 100))
gen_random_numbers()