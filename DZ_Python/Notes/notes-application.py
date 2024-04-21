import sys

import Controller.Controller


while True:
    Controller.Controller.start_application()
    value = input("Введите любой символ для продолжения "
                  "или 'q' для выхода из приложения: ")
    if value == 'q':
        sys.exit()
