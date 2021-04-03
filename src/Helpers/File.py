class File:
    mode = None
    fileName = None
    file = None

    def __init__(self, fileName):
        self.fileName = fileName

    def read(self, action):
        if self.file is None:
            self.open("r")

        action(self.file)

    def cursorTo(self):
        pass

    def readWrite(self, action):
        if self.file is None:
            self.open("w+")

        self.file.write(action)
        self.close()

    def open(self, mode="r"):
        if self.file is None:
            self.mode = mode
            self.file = open(self.fileName, mode)

    def append(self, txt):
        self.open("a+")
        for i in range(0, len(txt) - 1):
            self.file.write(txt[i])

    def close(self):
        self.file.close()
        self.mode = None
        self.file = None


