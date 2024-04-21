import sys


from Repository.saveToFile import save_to_file
from Services.CreateNoteService import create_note
from Services.DeleteNote import delete_note
from Services.EditNoteService import edit_note
from Services.FindAllNotesService import find_all_notes
from Services.FindNoteByDateService import find_note_by_date
from Services.FindNoteByIdService import find_note_by_id


def start_application():
    print(
        'Что Вы хотите сделать? \n'
        '1 - Создать заметку \n'
        '2 - Вывести список всех заметок \n'
        '3 - Найти заметку \n'
        '4 - Редактировать заметку \n'
        '5 - Удалить заметку\n'
        'q - Завершить программу')

    command = str(input('Ваш выбор: '))

    while (command != "1" and command != "2" and command != "3" and
           command != "4" and command != "5" and command != "q"):
        command = str(input('Нет такой команды, повторите ввод: '))
    if command == "1":
        save_to_file(create_note())
    elif command == "2":
        find_all_notes()
    elif command == "3":
        print(
            ' \nВыберите фильтр: \n'
            '1 - уникальный номер записи \n'
            '2 - дата записи\n'
            'q - Завершить программу')
        filter = str(input('Ваш выбор: '))
        while filter != "1" and filter != "2" and filter != "q":
            filter = str(input('Нет такого фильтра, повторите ввод: '))
        if filter == "1":
            find_note_by_id()
        elif filter == "2":
            find_note_by_date()
        elif command == "q":
            print("Завершение работы программы . . .")
            sys.exit()
    elif command == "4":
        save_to_file(edit_note())
    elif command == "5":
        save_to_file(delete_note())
    elif command == "q":
        print("Завершение работы программы . . .")
        sys.exit()
