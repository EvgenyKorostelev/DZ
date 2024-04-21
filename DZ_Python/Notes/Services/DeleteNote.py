import Repository.findInFile


def delete_note():
    data = Repository.findInFile.find_in_file()
    id = input("Введите id заметки, для УДАЛЕНИЯ: ")
    value = []
    for note in data:
        if id != note.get_id():
            value.append(note)
    if len(value) < len(data):
        print("\nЗапись удалена.")
        return value
