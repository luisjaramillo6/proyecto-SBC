from flask import Flask
from flask_debugtoolbar import DebugToolbarExtension
from flask_graphql import GraphQLView

def query_graphql_1(self,nombre):
		resource = "<http://localhost:8080/publicaciones/" + nombre + ">"
		self.wrapper.setQuery("""
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
        PREFIX foaf: <http://xmlns.com/foaf/0.1/>
        PREFIX dbo: <http://dbpedia.org/ontology/>
        select DISTINCT * WHERE{
        ?autor rdf:type foaf:Person ;
        foaf:name ?nombreAutor ;
        dbo:email ?correo .
        } ORDER BY ?autor
		""")
		self.wrapper.setReturnFormat(JSON)
		results = self.wrapper.query().convert()
		return results

def query_graphql_2(self,nombre):
		resource = "<http://localhost:8080/publicaciones/" + nombre + ">"
		self.wrapper.setQuery("""
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
        PREFIX dcterms: <http://purl.org/dc/terms/>
        select DISTINCT ?uriArticulo ?titulo WHERE{
        VALUES ?palabra {"COVID-19"} .
        ?uriArticulo rdf:type [] ;
        dcterms:title ?titulo .
        FILTER CONTAINS(?titulo, ?palabra)
        } ORDER BY ?titulo
		""")
		self.wrapper.setReturnFormat(JSON)
		results = self.wrapper.query().convert()
		return results

def query_graphql_3(self,nombre):
		resource = "<http://localhost:8080/publicaciones/" + nombre + ">"
		self.wrapper.setQuery("""
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
        PREFIX foaf: <http://xmlns.com/foaf/0.1/>
        PREFIX dbo: <http://dbpedia.org/ontology/>
        PREFIX owl: <http://www.w3.org/2002/07/owl#>
        PREFIX myOnto: <http://utpl.edu.ec/lod/publishingCOVID/ontology/>
        SELECT ?nombreTipoAfiliacion (Count(*) AS ?cantidad) WHERE{
	    ?uriAutor myOnto:belongTo ?afiliacion .
        ?afiliacion myOnto:isA ?tipoAfiliacion .
        ?tipoAfiliacion rdf:type owl:Thing ;
        foaf:name ?nombreTipoAfiliacion .
        } GROUP BY  ?nombreTipoAfiliacion ORDER BY ?nombreTipoAfiliacion
        """)
		self.wrapper.setReturnFormat(JSON)
		results = self.wrapper.query().convert()
		return results

def query_graphql_4(self,nombre):
		resource = "<http://localhost:8080/publicaciones/" + nombre + ">"
		self.wrapper.setQuery("""
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
		PREFIX myOnto: <http://utpl.edu.ec/lod/publishingCOVID/ontology/>
		PREFIX schema: <http://schema.org/>
		PREFIX foaf: <http://xmlns.com/foaf/0.1/>
		PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
		SELECT ?nombrePais (COUNT(?nombreAutor) AS ?Autores) WHERE{
    	?uriAutor rdf:type foaf:Person ;
    	foaf:name ?nombreAutor ;
    	myOnto:belongTo ?afiliacion .
    	?afiliacion schema:adressCountry ?pais .
    	?pais foaf:name ?nombrePais .
		} 
		GROUP BY ?nombrePais ORDER BY ?Autores
        """)
		self.wrapper.setReturnFormat(JSON)
		results = self.wrapper.query().convert()
		return results
