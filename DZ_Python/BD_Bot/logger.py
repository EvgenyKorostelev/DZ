from data_create import input_user_data
from data_transform import transform_user_data



#запись
def input_data():
    userId, name, surname, phone, adress = input_user_data()
    var = int(input(f'\nВ каком формате записать данные? \n'
                    f'1 Вариант:\n'
                    f'{userId}\n'
                    f'{name}\n'
                    f'{surname}\n'
                    f'{phone}\n'
                    f'{adress}\n\n'
                    f'2 Вариант:\n'
                    f'{userId};{name};{surname};{phone};{adress}\n\n'
                    f'Ваш выбор: '))
    if var == 1:
        with open('data_first_variant.csv', 'a', encoding='utf-8') as file:
            file.write( f'{userId}\n' 
                        f'{name}\n'
                        f'{surname}\n'
                        f'{phone}\n'
                        f'{adress}\n\n')
    else:
        with open('data_second_variant.csv', 'a', encoding='utf-8') as file:
            file.write(f'{userId};{name};{surname};{phone};{adress}\n\n')

#вывод
def print_data():
    print('1 файл:')
    with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
        data = file.readlines()
        print(''.join(data))
        
    print('2 файл:')
    with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
        data = file.readlines()
        print(''.join(data))

#изменение
def transform_data():
    varC = int(input(f'\nВ каком файле ИЗМЕНИТЬ информацию? \n'
                     f'1 файл\n'
                     f'2 файл\n'
                     f'Ваш выбор: '))
    varId = input(  f'\nДанные какого пользователя ИЩМЕНИТЬ? \n'
                     f'Введите id пользователя: ')
    if varC == 1:
        with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
            userId = list()
            for line in file:
                if line.split() == list(varId):
                    userId.append(line.strip())
        with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
            temp = list()
            for i in file:
                temp.append(i)
            for i in range(len(temp)):
                if temp[i].strip() == userId[0]:
                    userId, name, surname, phone, adress = transform_user_data()
                    temp[i] = userId + '\n'
                    temp[i+1] = name + '\n'
                    temp[i+2] = surname + '\n'
                    temp[i+3] = phone + '\n'
                    temp[i+4] = adress + '\n'

        with open('data_first_variant.csv', 'w', encoding='utf-8') as file:
            file.writelines(temp)   

    elif varC == 2:
        with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
                userId = list()
                for line in file:
                    if line.split(';')[0] == varId:
                        userId.append(line.split(';')[0])
        with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
            temp = list()
            for i in file:
                temp.append(i)
            for i in range (len(temp)):
                    for j in temp[i]:
                        if j == userId[0]:
                            userId, name, surname, phone, adress = transform_user_data()
                            temp[i] = (f'{userId};{name};{surname};{phone};{adress}\n')
                            break

        with open('data_second_variant.csv', 'w', encoding='utf-8') as file:
            file.writelines(temp)   

#копирование
def copy_data():
    varC = int(input(f'\nИЗ какого файла скопировать информацию? \n'
                     f'1 файл\n'
                     f'2 файл\n'
                     f'Ваш выбор: '))
    varId = input(  f'\nДанные какого пользователя скопировать? \n'
                     f'Введите id пользователя: ')
    varP = int(input(f'\nВ какой файл скопировать информацию? \n'
                     f'1 файл\n'
                     f'2 файл\n'
                     f'Ваш выбор: '))
    
    if varC == 1 and varP == 2:
        with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
            count = 0
            for line in file:
                if line.split() == list(varId):
                    userId = (line.strip())
                    count =+ 1
                if count == 1:
                    name = (line.strip())
                    count+=1
                elif count == 2:
                    surname = (line.strip())
                    count+=1
                elif count == 3:
                    phone = (line.strip())
                    count+=1
                elif count == 4:
                    adress = (line.strip())
                    count = 0              
                    
        with open('data_second_variant.csv', 'a', encoding='utf-8') as file:
            file.write(f'{userId};{name};{surname};{phone};{adress}\n\n')

    elif  varC == 2 and varP == 1:
        with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
                for line in file:
                    if line.split(';')[0] == varId:
                        userId = line.split(';')[0]
                        name =  line.split(';')[1]
                        surname = line.split(';')[2]
                        phone = line.split(';')[3]
                        adress = line.split(';')[4]
        with open('data_first_variant.csv', 'a', encoding='utf-8') as file:
            file.write( f'{userId}\n' 
                        f'{name}\n'
                        f'{surname}\n'
                        f'{phone}\n'
                        f'{adress}\n\n')

#удаление
def delete_data():
    varC = int(input(f'\nИз какого файла удалить информацию? \n'
                     f'1 файл\n'
                     f'2 файл\n'
                     f'Ваш выбор: '))
    varId = input(  f'\nДанные какого пользователя УДАЛИТЬ? \n'
                     f'Введите Id пользователя: ')
    if varC == 1:
        with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
            userId = list()
            for line in file:
                if line.split() == list(varId):
                    userId.append(line.strip())
        with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
            temp = list()
            for i in file:
                temp.append(i)
            count = 0                       
            for i in range(len(temp)):
                if temp[i].strip() == userId[0]:
                    count = i
            temp.pop(count)
            temp.pop(count) 
            temp.pop(count) 
            temp.pop(count) 
            temp.pop(count)
            temp.pop(count)

        with open('data_first_variant.csv', 'w', encoding='utf-8') as file:
            file.writelines(temp)   

    elif varC == 2:
        with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
                userId = list()
                for line in file:
                    if line.split(';')[0] == varId:
                        userId.append(line.split(';')[0])
        with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
            temp = list()
            for i in file:
                temp.append(i)
            count = 0                       
            for i in range (len(temp)):
                    for j in temp[i]:
                        if j == userId[0]:
                            count = i
            temp.pop(count)
            temp.pop(count) 

        with open('data_second_variant.csv', 'w', encoding='utf-8') as file:
            file.writelines(temp)   