import Repository.findInFile


def edit_note():
    data = Repository.findInFile.find_in_file()
    id = input("Введите id заметки, для редактирования: ")
    value = []
    temp = 0
    for note in data:
        if id == note.get_id():
            note.set_title()
            note.set_description()
            note.set_date()
            temp += 1
        value.append(note)
    if temp == 1:
        print("\nЗапись изменена.")
        return value
