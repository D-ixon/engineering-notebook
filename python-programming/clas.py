class MyClass:

    def __init__(self, number):
        self.number = number

    def returnNumber(self):
        return self.number


cons = MyClass(8)
print(cons.returnNumber())


