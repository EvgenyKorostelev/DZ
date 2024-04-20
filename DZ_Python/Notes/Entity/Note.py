from datetime import datetime

from Entity import idFactory


class Note:
    def __init__(self, id=str(idFactory.create_id()), title="title", description="description",
                 date=str(datetime.now().strftime("%d.%m.%Y %H:%M"))):
        self.id = id
        self.title = title
        self.description = description
        self.date = date

    def get_title(self):
        return self.title

    def to_string(self):
        return self.id + ';' + self.title + ';' + self.description + ';' + self.date
