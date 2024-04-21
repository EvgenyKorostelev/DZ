id_count = 0


def create_id():
    global id_count
    try:
        file = open('id_counter.csv', 'r+')
    except IOError:
        file = open('id_counter.csv', 'w+')
    id_group = file.readlines()
    if id_count == 0 and len(id_group) == 0:
        id_count = 1
        file.write(f"{id_count}")
    elif id_count == 0 and len(id_group) != 0:
        id_count = len(id_group) + 1
        file.write(f"\n{id_count}")
    elif id_count != 0:
        id_count += 1
        file.write(f"\n{id_count}")
    file.close()
    return id_count
