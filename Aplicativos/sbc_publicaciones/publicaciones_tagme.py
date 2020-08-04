import requests
import pymysql
import pandas as pd
import xlsxwriter


class DataBase:
    def __init__(self):
        self.connection = pymysql.connect(
            host = "localhost",
            user = "root",
            password ="",
            db = "publicaciones"
        )
        self.cursor = self.connection.cursor()
        print("Conexion correcta\n")

    def concultarTitulo(self):
        lista = []
        #sql = "SELECT resumen FROM articulo"
        sql = "SELECT titulo FROM articulo"

        try:
            self.cursor.execute(sql)
            users = self.cursor.fetchall()

            for user in users:
                #print("resumen: ", user[0])
                lista.append(user[0])

        except Exception as e:
            raise
        return lista

# Instaciamos un Objeto
database = DataBase()

abstract_artiulos = database.concultarTitulo()
print(abstract_artiulos[0])

# Recorremos todos los apartados de la lista, que tiene el titulo del articulo
contador = 1
matriz = []
matriz2 = []
art = []
for articulo in range(360,len(abstract_artiulos)):

    token  = '2cc1ef94-a22a-4642-ac62-2e158304ad8b-843339462'

    url = 'https://tagme.d4science.org/tagme/tag?lang=en&include_abstract=true&include_categories=true&gcube-token='+token+'&text='+ abstract_artiulos[articulo]

    headers = {'user-agent':'Morzilla/5.0','accep':'application/json'}
    resp = requests.get(url, headers=headers).json()
    resp.keys()

    resultado_dbpedia = []
    resultado_dbpedia2 = []

    annotations = resp['annotations']

    #print("Interación ", contador ," tamaño de dbpedia", len(annotations))

    try:
        for j in range(len(annotations)):
            #print((annotations[j]['spot']))
            #print((annotations[j]['dbpedia_categories']))
            if annotations[j]["rho"] > 0.2:
                resultado_dbpedia.append(annotations[j]["spot"])
                #resultado_dbpedia2.append(annotations[j]["dbpedia_categories"])
            else:
                continue
            #resultado_dbpedia.append(annotations[j]['dbpedia_categories'])

        matriz.append(resultado_dbpedia)
        matriz2.append(resultado_dbpedia2)
        art.append("http://utpl.edu.ec/lod/publishingCOVID/ontology/BibliographicResource/Article-"+ str(contador))

        print(120*"#")
        print("El articulo",contador,"spot:",resultado_dbpedia)
    except Exception as e:
        print(e)
    contador +=1

print(100*"#")

# Cambia a diccionario
diccionario = dict(zip(art, matriz))
diccionario2 = dict(zip(art, matriz2))

log = open('log.txt',"w")

# Funciones para almacenar en un archivo
def archivo1(diccionario):
    # Guarda en un archivo txt
    for key, value in diccionario.items():
    #print(key, str(value).strip("[]'"))
        log.write(key+" "+(str(value).strip("[ ]"))+"\n")


def archivo2(diccionario):
    # Guarda en un archivo txt

    for key, value in diccionario.items():
    #print(key, str(value).strip("[]'"))
        log.write(key+" "+(str(value).strip("[ ]"))+"\n")


archivo1(diccionario)
#archivo2(diccionario2)
log.flush()
log.close()



#df = pd.DataFrame((diccionario), columns = ['first_name'])
#df.to_excel('example.xlsx', sheet_name='example')
