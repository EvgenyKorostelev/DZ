import sys

import Application.NotesApplication


while True:
    Application.NotesApplication.start_application()
    value = input("Введите любой символ для продолжения "
                  "или 'q' для выхода из приложения: ")
    if value == 'q':
        sys.exit()

