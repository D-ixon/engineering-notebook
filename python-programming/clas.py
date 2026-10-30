class MyClass:
    variable = "Hey"
    def func(self):
        print("This cool!")

firstobject = MyClass()
secondobject = MyClass()

print(firstobject.variable)

secondobject.variable = "Nose"

print(secondobject.variable)
firstobject.func()

