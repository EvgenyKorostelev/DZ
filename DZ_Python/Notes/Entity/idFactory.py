def create_id():
    try:
        file = open('id_counter.csv', 'r+')
    except IOError:
        file = open('id_counter.csv', 'w+')
    id_group = file.readlines()
    if len(id_group) == 0:
        id = 1
        file.write(f"{id + 1}")
    else:
        id = int(id_group[-1])
        file.write(f"\n{id + 1}")
    file.close()
    return id
