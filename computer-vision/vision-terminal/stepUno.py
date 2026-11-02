class Image: 

    def __init__(self, image_id, filename, width, height, channels, file_size):
        self.image_id = image_id
        self.filename = filename
        self.width = width
        self.height = height
        self.channels = channels
        self.file_size = file_size

    def totalPixel(self):
        return self.width * self.height

    def imageColor(self):

        return image

    def displayImageInfo(self):

        return self
