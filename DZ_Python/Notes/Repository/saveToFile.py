def save_to_file(notes):
    try:
        if len(notes) == 1:
            param = 'a'
        else:
            param = 'w'
        with open('My_Notes.csv', f'{param}', encoding='utf-8') as file:
            for note in notes:
                file.writelines(f"{note.to_string()}\n")
    except TypeError:
        print("\nНет заметки с таким id")
