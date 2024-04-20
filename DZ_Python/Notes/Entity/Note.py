from datetime import datetime

from Entity import idFactory


class Note:
    def __init__(self, id=str(idFactory.create_id()), title="title", description="description",
                 date=str(datetime.now().strftime("%d.%m.%Y %H:%M"))):
        self.id = id
        self.title = title
        self.description = description
        self.date = date

<<<<<<< HEAD
    def get_id(self):
        return self.id

    def get_title(self):
        return self.title

    def get_date(self):
        return self.date

    def to_string(self):
        return self.id + ';' + self.title + ';' + self.description + ';' + self.date

    def scheme_note(self):
        return ('\nID: ' + self.id + '\n' + 'Название: ' + self.title + '\n'
                + 'Описание: ' + self.description + '\n' + 'Дата записи: ' + self.date)
=======
    def get_title(self):
        return self.title

    def to_string(self):
        return self.id + ';' + self.title + ';' + self.description + ';' + self.date
>>>>>>> 50fc5ccdbb762f8d6d8dc2ec2200ed9002cbdae1
