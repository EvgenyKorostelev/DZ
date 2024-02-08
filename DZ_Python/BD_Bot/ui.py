from logger import input_data, print_data, transform_data, copy_data, delete_data

def interface():
    print('Добрый день! Это бот помощник. \n'
          'Что Вы хотите сделать? \n'
          '1 - Записать данные \n'
          '2 - Вывести данные \n'
          '3 - Изменить данные \n'
          '4 - Перенести данные \n'
          '5 - Удалить данные')
    command = int(input('Ваш выбор: '))

    while command < 1 or command > 5:
        command = int(input('Ошибка! Ваш выбор: '))

    if command == 1:
        input_data()
    elif command == 2:
        print_data()
    elif command == 3:
        transform_data()
    elif command == 4:
        copy_data()    
    elif command == 5:
        delete_data()

interface()