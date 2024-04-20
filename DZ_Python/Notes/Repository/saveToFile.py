<<<<<<< HEAD
=======
import Entity.Note


>>>>>>> 50fc5ccdbb762f8d6d8dc2ec2200ed9002cbdae1
def save_to_file(note):
    with open(f'My_Notes.csv', 'a', encoding='utf-8') as file:
        file.writelines(f"{note.to_string()}\n")
