import cv2
import pytesseract
import sys


image = cv2.imread(sys.argv[1])

string = pytesseract.image_to_string(image)
print(string)
