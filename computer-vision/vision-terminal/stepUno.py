from math import gcd

# fault: consider input validation for width, height, and channels to ensure they are positive integers. Also, consider adding error handling for file size input.
class Image: 

    def __init__(self, image_id, filename, width, height, channels, file_size):
        self.image_id = image_id
        self.filename = filename
        self.width = width
        self.height = height
        self.channels = channels
        self.file_size = file_size

    def total_pixel(self):
        if self.width <= 0 or self.height <= 0:
            raise ValueError("Width and Height must be positive integers.")
        return self.width * self.height

    def image_color(self):
        if self.channels == 1:
            return "Grayscale Image"
        elif self.channels == 3:
            return "Color RGB"
        return "Unknown"

    def image_aspect_ratio(self):
        divisor = gcd(self.width, self.height)

        if divisor == 0:
            raise ValueError("Width and Height must be positive integers.")
        ratio_width = self.width // divisor
        ratio_height = self.height // divisor

        return ratio_width, ratio_height  

    def display_image_info(self):

        ratio_width, ratio_height = self.image_aspect_ratio()

        print(f"\nImage ID: {self.image_id}")
        print(f"Filename: {self.filename}")
        print(f"Resolution: {self.width} x {self.height}")
        print(f"Width: {self.width} pixels")
        print(f"Height: {self.height} pixels")
        print(f"Total Pixels: {self.total_pixel()} pixels")
        print(f"Channels: {self.image_color()}")
        print(f"File size: {self.file_size} KB")
        print(f"Image Aspect Ratio: {ratio_width} : {ratio_height}\n")

class ImageManager:

    def __init__(self):
        self.images = []

    def register_image(self):
        image_id = input("Enter image ID: ")
        filename = input("Enter image type: ")
        width = int(input("Enter pixel heigth: "))
        height = int(input("Enter pixel width"))
        channels = int(input("Enter channel: "))
        file_size = float(input("Enter file size: "))

        new_image = Image(
            image_id,
            filename,
            width,
            height,
            channels,
            file_size
        )

        self.images.append(new_image)

        print("Image successfully registered!")

    def search_image(self, target_id):
        for image in self.images:
            if image.image_id.lower() == target_id.lower():
                return image     
        return None 

    manager = ImageManager()

    user_id = input("Enter the Image ID to search for: ")
    result = manager.search_image(user_id)

    if result is not None:
        print(f"Match found: {result.file_name} ({result.resolution})")
    else:
        print("Image not found.")

image1 = Image("aaa", "image1.jpg", 1920, 1080, 3, 38)
image1.display_image_info()