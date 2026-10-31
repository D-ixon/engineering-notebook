class MyClass:

    def __init__(self, number):
        self.number = number

    def returnNumber(self):
        return self.number


cons = MyClass(8)
print(cons.returnNumber())


phoneBook = {
    "John": "555-1234",
    "Jane": "555-5678",
    "Bob": "555-8765"
}
print(phoneBook.pop("Jane"))

