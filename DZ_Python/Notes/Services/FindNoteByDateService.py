import Entity.Note

import Repository.findInFile


def find_note_by_date():
    data = Repository.findInFile.find_in_file()
    date = input("Введите дату в формате: dd.mm.yyyy: ")
    value = ""
    for note in data:
        note_date = str(note.get_date())
        if date == note_date[:10]:
            value = Entity.Note.Note.scheme_note(note)
            print(value)
    if value == "":
        print("\nНет заметок с такой датой")