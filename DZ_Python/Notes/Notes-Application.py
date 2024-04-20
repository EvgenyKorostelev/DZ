def start_application():
    print(
        'Что Вы хотите сделать? \n'
        '1 - Создать заметку \n'
        '2 - Вывести список всех заметок \n'
        '3 - Показать заметку \n'
        '4 - Редактировать заметку \n'
        '5 - Удалить заметку'
        'q - Завершить программу')
    
    command = str(input('Ваш выбор: '))

    while command < 1 or command > 5 or command != "q":
        command = str(input('Ошибка! Ваш выбор: '))
        if command == "1":
            pass
        elif command == "2":
            pass
        elif command == "3":
            pass
        elif command == "4":
            pass
        elif command == "5":
            pass
        elif command == "q":
            print("Завершение работы программы . . .")
            break


start_application()
