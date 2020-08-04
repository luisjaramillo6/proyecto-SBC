package principal;

import bl.BLAdministración;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.jena.dboe.transaction.txn.PrepareState;
import org.apache.jena.graph.Graph;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
        BLAdministración objetoBL = new BLAdministración();

        ArrayList<Publicacion> lstpublicacion = new ArrayList();

        lstpublicacion = objetoBL.consultarPublicacion();

        // MODELO RDF
        Model model = ModelFactory.createDefaultModel();

        File f = new File("/Users/Febre/Documents/Programación/JAVA_NETBEANS/publicaciones.rdf");  //Fijar ruta donde se creará el archivo RDF
        FileOutputStream os = new FileOutputStream(f);

        //Fijar Prefijo para URI base - data
        String dataPrefix = "http://utpl.edu.ec/lod/publishingCOVID/";
        model.setNsPrefix("data", dataPrefix);

        //Fijar prefijos de vocabularios incorporados en Jena
        String foaf = "http://xmlns.com/foaf/0.1/";
        model.setNsPrefix("foaf", foaf);

        //Fijar Prefijo para otros vocabularios como DBPedia que no están directamente incorporados en Jena
        String dbo = "http://dbpedia.org/ontology/";
        model.setNsPrefix("dbo", dbo);
        Model dboModel = ModelFactory.createDefaultModel();

        //Fijar Prefijo para otros vocabularios como DBPedia que no están directamente incorporados en Jena
        String dbr = "http://dbpedia.org/ontology/";
        model.setNsPrefix("dbr", dbr);

        //Fijar prefijos de vocabularios incorporados en Jena
        String fabio = "http://purl.org/spar/fabio/";
        model.setNsPrefix("fabio", fabio);
        Model fabioModel = ModelFactory.createDefaultModel();

        //Fijar prefijos de vocabularios incorporados en Jena
        String dct = "http://purl.org/dc/terms/";
        model.setNsPrefix("dcterms", dct);
        Model dctermsModel = ModelFactory.createDefaultModel();

        //Fijar prefijos de vocabularios incorporados en Jena
        String dc = "http://purl.org/dc/elements/1.1/";
        model.setNsPrefix("dc", dc);
        Model dcModel = ModelFactory.createDefaultModel();

        //Fijar prefijos de vocabularios incorporados en Jena
        String dcat = "http://www.w3.org/ns/dcat#";
        model.setNsPrefix("dcat", dcat);
        Model dcatModel = ModelFactory.createDefaultModel();

        //Fijar prefijos de vocabularios incorporados en Jena
        String schema = "http://schema.org/";
        model.setNsPrefix("schema", schema);
        Model schemaModel = ModelFactory.createDefaultModel();
        
        //Fijar prefijos de vocabularios incorporados en Jena
        String owl = "http://www.w3.org/2002/07/owl#";
        model.setNsPrefix("owl", owl);
        Model owlModel = ModelFactory.createDefaultModel();

        String myOnto = "http://utpl.edu.ec/lod/publishingCOVID/ontology/";
        model.setNsPrefix("myOnto", myOnto);
        Model myOntoModel = ModelFactory.createDefaultModel();

        //  Clases
        String countryClassURI = dbo + "Country";
        Resource countryClass = ResourceFactory.createProperty(countryClassURI);

        String cityClassURI = dbo + "City";
        Resource cityClass = ResourceFactory.createProperty(cityClassURI);

        String articleClassURI = fabio + "Article";
        Resource articleClass = ResourceFactory.createProperty(articleClassURI);

        // Recorre lo guardado
        for (Publicacion publicacion : lstpublicacion) {

            Resource autorArticulo = model.createResource(myOnto + "Author/author-" + publicacion.getId_publicacion());
            if (publicacion.getCorreo().isEmpty()) {
                autorArticulo.addProperty(RDF.type, FOAF.Person)
                        //.addProperty(RDF.type, FOAF.Person)
                        .addProperty(FOAF.name, publicacion.getNombreAutor());
            } else {
                autorArticulo.addProperty(RDF.type, FOAF.Person)
                        //.addProperty(RDF.type, FOAF.Person)
                        .addProperty(FOAF.name, publicacion.getNombreAutor())
                        .addProperty(dctermsModel.getProperty(dbo, "email"), publicacion.getCorreo());
            }
            //.addProperty(RDF.type, myOntoModel.getProperty(dataPrefix + "Author"))

            Resource articulo = model.createResource(myOnto + "BibliographicResource/Article-" + publicacion.getId_autor())
                    .addProperty(RDF.type, dctermsModel.getProperty(fabio, "Article"))
                    .addProperty(RDFS.label, "Artículo @es")
                    .addProperty(RDFS.comment, "Permite mostrar a la Sociedad Científica los resultados de una "
                            + "investigación para que el mismo pueda ser consultado, revisado y debatido.")
                    .addProperty(dctermsModel.getProperty(dct, "title"), publicacion.getTitulo())
                    .addProperty(fabioModel.getProperty(fabio, "doi"), publicacion.getDoi())
                    .addProperty(dctermsModel.getProperty(dct, "date"), String.valueOf(publicacion.getAnio()))
                    .addProperty(dctermsModel.getProperty(dct, "abstract"), publicacion.getResumen())
                    .addProperty(fabioModel.getProperty(fabio, "hasURL"), publicacion.getUrl())
                    .addProperty(dcatModel.getProperty(dcat, "keywords"), publicacion.getPalabras_clave());

            Resource afiliacionAutor = model.createResource(myOnto + "Organization/Organization-" + publicacion.getId_afiliacion())
                    .addProperty(RDF.type, dboModel.getProperty(dbo, "Organisation"))//prueba
                    .addProperty(FOAF.name, publicacion.getNombre_afiliacion())
                    .addProperty(RDFS.label, "Autor @es")
                    .addProperty(RDFS.comment, "Una organización es un grupo social formado por personas, tareas y administración, "
                            + "que interactúan en el marco de una estructura sistemática para cumplir con sus objetivos");

            Resource ciudadAfiliacion = model.createResource(myOnto + "City/" + publicacion.getCiudad_afiliacion())
                    .addProperty(RDFS.subClassOf, dboModel.getProperty(dbo, "Place"))
                    .addProperty(RDF.type, dboModel.getProperty(dbo, "City"))//prueba
                    .addProperty(FOAF.name, publicacion.getCiudad_afiliacion())
                    .addProperty(RDFS.label, "Ciudad @es")
                    .addProperty(RDFS.comment, "Una ciudad es un espacio urbano con alta densidad de población, en la que predomina el "
                            + "comercio, la industria y los servicios.");

            Resource paisAfiliacion = model.createResource(myOnto + "Country/" + publicacion.getNombre_pais())
                    .addProperty(RDFS.subClassOf, dboModel.getProperty(dbo, "Place"))
                    .addProperty(RDF.type, dboModel.getProperty(dbo, "Country"))
                    .addProperty(FOAF.name, publicacion.getNombre_pais())
                    .addProperty(RDFS.label, "Pais @es")
                    .addProperty(RDFS.comment, "Un país es aquel territorio o nación políticamente independiente que posee un gobierno propio junto "
                            + "con un conjunto de leyes, administración, población y fuerzas de seguridad");

            Resource tipoAfiliacion = model.createResource(myOnto + publicacion.getNombre_tipoafiliacion())
                    .addProperty(RDFS.subClassOf, dboModel.getProperty(dbo, "Organisation"))
                    .addProperty(RDF.type, owlModel.getProperty(owl, "Thing"))//prueba
                    .addProperty(FOAF.name, publicacion.getNombre_tipoafiliacion());

            // Agregar propiedad que vincule los recursos
            model.add(articulo, dcModel.getProperty(dc, "create"), autorArticulo);   // forma 1 - REVIZAR PREDICADO
            model.add(autorArticulo, myOntoModel.getProperty(myOnto, "belongTo"), afiliacionAutor);  // forma 1 - REVIZAR PREDICADO
            model.add(afiliacionAutor, myOntoModel.getProperty(myOnto, "isLocated"), ciudadAfiliacion);
            model.add(afiliacionAutor, schemaModel.getProperty(schema, "adressCountry"), paisAfiliacion);   // forma 1 - REVIZAR PREDICADO
            model.add(afiliacionAutor, myOntoModel.getProperty(myOnto, "isA"), tipoAfiliacion);   // forma 1 - REVIZAR PREDICADO
            //person02.addProperty(FOAF.member, utpl);  // forma 2

        }

        // list the statements in the Model
        StmtIterator iter = model.listStatements();
        // print out the predicate, subject and object of each statement

        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();  // get next statement
            Resource subject = stmt.getSubject();     // get the subject
            Property predicate = stmt.getPredicate();   // get the predicate
            RDFNode object = stmt.getObject();      // get the object

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }

            System.out.println(" .");
        }

        // now write the model in XML form to a file
        System.out.println("MODELO RDF------");
        model.write(System.out, "RDF/XML-ABBREV");

        // Save to a file
        RDFWriter writer = model.getWriter("RDF/XML");
        writer.write(model, os, "");

        //Close models
        model.close();

    }

}
