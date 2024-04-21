import Entity.Note


def find_in_file():
    data = []
    with open(f'My_Notes.csv', 'r', encoding='utf-8') as file:
        notes = file.readlines()
        for note in notes:
            note = note.strip()
            split_note = note.split(';')
            note = Entity.Note.Note(
                id=split_note[0], title=split_note[1], description=split_note[2], date=split_note[3])
            data.append(note)
        if len(data) != 0:
            return data
        else:
            print("\nСписок заметок пуст.")
