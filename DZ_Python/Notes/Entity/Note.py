from datetime import datetime


class Note:
    def __init__(self, id="id", title="title", description="description",
                 date="date"):
        self.id = id
        self.title = title
        self.description = description
        self.date = date

    def get_id(self):
        return self.id

    def get_title(self):
        return self.title

    def get_date(self):
        return self.date

    def set_title(self):
        self.title = input("Введите новый заголовок:\n")

    def set_description(self):
        self.description = input("Введите новое описание:\n")

    def set_date(self):
        self.date = str(datetime.now().strftime("%d.%m.%Y %H:%M"))

    def to_string(self):
        return self.id + ';' + self.title + ';' + self.description + ';' + self.date

    def scheme_note(self):
        return ('\nID: ' + self.id + '\n' + 'Название: ' + self.title + '\n'
                + 'Описание: ' + self.description + '\n' + 'Дата записи: ' + self.date)
