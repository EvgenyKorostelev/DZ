from datetime import datetime

import Entity.Note

import Repository.findInFile
from Entity import idFactory


def create_note():
    note_id = str(idFactory.create_id())
    note_title = input("Введите заголовок заметки:\n")
    note_description = input("Введите описание заметки:\n")
    note_date = str(datetime.now().strftime("%d.%m.%Y %H:%M"))
    notes = [Entity.Note.Note(id=note_id, title=note_title,
                              description=note_description, date=note_date)]
    return notes


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
            print("\nНет заметок с такой датой")


def edit_note():
    data = Repository.findInFile.find_in_file()
    id = input("Введите id заметки, для редактирования: ")
    value = []
    for note in data:
        if id == note.get_id():
            note.set_title()
            note.set_description()
            note.set_date()
        value.append(note)
    return value


def delete_note():
    data = Repository.findInFile.find_in_file()
    id = input("Введите id заметки, для УДАЛЕНИЯ: ")
    value = []
    for note in data:
        if id != note.get_id():
            value.append(note)
    if len(value) < len(data):
        print("Запись удалена.")
        return value
    else:
        print("\nНет заметки с таким id")
