import Entity.Note



def create_note():
    note_title = input("Введите заголовок заметки:\n")
    note_description = input("Введите описание заметки:\n")
    note = Entity.Note.Note(title=note_title, description=note_description)
    return note

    pass
def find_all_notes():
    pass
def find_note():
    pass
def edit_note():
    pass
def delete_note():
    pass
