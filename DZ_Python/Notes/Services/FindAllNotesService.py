import Entity.Note

import Repository.findInFile


def find_all_notes():
    data = Repository.findInFile.find_in_file()
    if data is not None:
        print("\nСписок всех заметок:")
        for note in data:
            print(Entity.Note.Note.scheme_note(note))