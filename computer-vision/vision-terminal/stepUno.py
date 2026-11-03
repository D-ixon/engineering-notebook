class Image: 

    def __init__(self, image_id, filename, width, height, channels, file_size):
        self.image_id = image_id
        self.filename = filename
        self.width = width
        self.height = height
        self.channels = channels
        self.file_size = file_size

    def total_pixel(self):
        return self.width * self.height

    def image_color(self):
        if self.channels == 1:
            return "GrayScale Image"
        elif self.channels == 3:
            return "Color RGB"
        return "Unkown"

    def display_image_info(self):

        print(f"Image ID: {self.image_id}")
        print(f"Filename: {self.filename}")
        print(f"Resolution: {self.height} x {self.width}")
        print(f"Width: {self.width} pixels")
        print(f"Height: {self.height} pixels")
        print(f"Channels: {self.channels}")
        print(f"File size: {self.file_size}")

class ImageManager:

    def __init__(self, image_id, image_type, pixel_height, pixel_width, channel, file_size):
        self.image_id = image_id
        self.image_type = image_type
        self.pixel_height = pixel_height
        self.pixel_width = pixel_width
        self.channel = channel
        self.file_size = file_size

    def register_image(imgae):
        image_id = input("Enter image ID: ")
        image_type = input("Enter image type: ")
        pixel_height = int(input("Enter pixel heigth: "))
        pixel_width = int(input("Enter pixel width"))
        channel = int(input("Enter channel: "))
        file_size = float(input("Enter file size: "))