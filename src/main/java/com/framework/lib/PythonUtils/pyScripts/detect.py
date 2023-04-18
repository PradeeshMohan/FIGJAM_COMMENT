import cv2
import sys

image = cv2.imread(sys.argv[1])

image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

gray = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)

_, binary = cv2.threshold(gray, 225, 255, cv2.THRESH_BINARY_INV)

contours, hierarchy = cv2.findContours(binary, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
for i in contours:
    print(cv2.contourArea(i))
    # print(i) #for all points of individual cnt

# image = cv2.drawContours(image, contours, -1, (0, 255, 0), 2)
# plt.imshow(image)
# plt.show()
