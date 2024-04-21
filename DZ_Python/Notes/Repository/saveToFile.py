def save_to_file(notes):
    if len(notes) == 1:
        param = 'a'
    else:
        param = 'w'
    with open('My_Notes.csv', f'{param}', encoding='utf-8') as file:
        for note in notes:
            file.writelines(f"{note.to_string()}\n")
