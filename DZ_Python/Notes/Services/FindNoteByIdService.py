import Entity.Note

import Repository.findInFile


def find_note_by_id():
    data = Repository.findInFile.find_in_file()
    id = input("Введите id заметки: ")
    value = ""
    for note in data:
        if id == note.get_id():
            value = Entity.Note.Note.scheme_note(note)
            print(value)
    if value == "":
        print("\nНет заметки с таким id")