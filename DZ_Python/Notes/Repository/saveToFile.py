import Entity.Note


def save_to_file(note):
    with open(f'My_Notes.csv', 'a', encoding='utf-8') as file:
        file.writelines(f"{note.to_string()}\n")
