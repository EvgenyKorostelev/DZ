from datetime import datetime

import Entity.Note
from Entity import idFactory


def create_note():
    note_id = str(idFactory.create_id())
    note_title = input("Введите заголовок заметки:\n")
    note_description = input("Введите описание заметки:\n")
    note_date = str(datetime.now().strftime("%d.%m.%Y %H:%M"))
    notes = [Entity.Note.Note(id=note_id, title=note_title,
                              description=note_description, date=note_date)]
    return notes
