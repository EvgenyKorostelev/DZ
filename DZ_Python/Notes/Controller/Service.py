import Entity.Note

import Repository.findInFile


def create_note():
    note_title = input("Введите заголовок заметки:\n")
    note_description = input("Введите описание заметки:\n")
    note = Entity.Note.Note(title=note_title, description=note_description)
    return note


def find_all_notes():
    print("\nСписок всех заметок:")
    for note in Repository.findInFile.find_in_file():
        print(Entity.Note.Note.scheme_note(note))


def find_note_by_id():
    data = Repository.findInFile.find_in_file()
    id = input("Введите id заметки: ")
    value = ""
    for note in data:
        if id == note.get_id():
            value = Entity.Note.Note.scheme_note(note)
    if value != "":
        print(value)
    else:
        print("\nНет заметки с таким id")


def find_note_by_date():
    data = Repository.findInFile.find_in_file()
    date = input("Введите дату в формате: dd.mm.yyyy: ")
    for note in data:
        date_note = str(note.get_date())
        if date == date_note[:10]:
            print(Entity.Note.Note.scheme_note(note))
        else:
            print("\nНет такой даты")


def edit_note():
    pass
