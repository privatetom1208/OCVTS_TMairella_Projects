# Practice activity 1 - create a program that continues to run until the user types "exit"
while True:
    user_input = input("Type 'exit' to stop the program: ")
    if user_input == "exit":
        break

# Practice activity 2 - create a program that prints the numbers from 1 to 10
for i in range(1, 11):
    print(i)