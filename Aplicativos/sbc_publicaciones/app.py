from flask import Flask, render_template, request,redirect, url_for,flash
from flask_mysqldb import MySQL
from modelo import *

app = Flask(__name__)

# Conectarse a MySQL
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = ''
app.config['MYSQL_DB'] = 'publicaciones2'

# Session
app.secret_key = 'mysecretkey' # Como va ir protecgida

mysql = MySQL(app)

# Cada vez que nuestro usuario entre a una ruta principal uestre algo
@app.route('/')
def acciones_consultas():
    return render_template('index.html')


@app.route('/consulta_quer1')
def consulta_json_1():
    nombre = "publicaciones.rdf"
    query_graphql_1(nombre)
    flash('QUE ACTORES CUENTAN CON CORREO')
    return render_template('autores_correo.html', contactos = datos_cosultados) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce

@app.route('/consulta_quer2')
def consulta_json_2():
    nombre = "publicaciones.rdf"
    query_graphql_2(nombre)
    flash('ARTICULOS QUE HACEN REFERENCIA A LA PALABRA COVID-19')
    return render_template('consultas_titulo_palabraClave.html', contactos = datos_cosultados) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce

@app.route('/consulta_quer3')
def consulta_json_3():
    nombre = "publicaciones.rdf"
    query_graphql_3(nombre)
    flash('CANTIDAD DE TIPOS DE AFILIACIONES')
    return render_template('consultas_titulo_palabraClave.html', contactos = datos_cosultados) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce


@app.route('/consulta_quer4')
def consulta_json_4():
    nombre = "publicaciones.rdf"
    query_graphql_3(nombre)
    flash('CANTIDAD DE AUTORES AFILIADOS POR PAISES')
    return render_template('consultas_titulo_palabraClave.html', contactos = datos_cosultados) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce

@app.route('/consulta1')
def consulta_autores_correo():
    cur = mysql.connection.cursor()
    # Obtengo los datos de la tabla contactos
    cur.execute('SELECT * FROM consulta1')
    data = cur.fetchall() # Ejecuto el query, y almaceno e una variable
    #print(data)
    flash('QUE ACTORES CUENTAN CON CORREO')
    return render_template('autores_correo.html', contactos=data) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce

@app.route('/consulta2')
def consulta_titulo_palabraClave():
    cur = mysql.connection.cursor()
    # Obtengo los datos de la tabla contactos
    cur.execute('SELECT * FROM consulta2')
    data = cur.fetchall() # Ejecuto el query, y almaceno e una variable
    #print(data)
    flash('ARTICULOS QUE HACEN REFERENCIA A LA PALABRA COVID-19')
    return render_template('consultas_titulo_palabraClave.html', contactos=data) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce

@app.route('/consulta3')
def consulta_cantidad_afiliaciones():
    cur = mysql.connection.cursor()
    # Obtengo los datos de la tabla contactos
    cur.execute('SELECT * FROM consulta3')
    data = cur.fetchall() # Ejecuto el query, y almaceno e una variable
    #print(data)
    flash('CANTIDAD DE TIPOS DE AFILIACIONES')
    return render_template('cantidad_afiliaciones.html', contactos=data) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce

@app.route('/consulta4')
def consulta_cantidad_autores():
    cur = mysql.connection.cursor()
    # Obtengo los datos de la tabla contactos
    cur.execute('SELECT * FROM consulta4')
    data = cur.fetchall() # Ejecuto el query, y almaceno e una variable
    #print(data)
    flash('CANTIDAD DE AUTORES AFILIADOS POR PAISES')
    return render_template('cantidad_autores.html', contactos=data) #Te carga un template , No se le pone nombre de la carpeta por flask template ya conoce


if (__name__ == '__main__'):
    app.run(port=3000, debug=True) # Para que sepa el puerto y cada vez que haga cambio se reinicie
