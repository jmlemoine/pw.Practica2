package CRUD;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.Spark;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args){

        staticFiles.location("/Templates");
        final Configuration config = new Configuration(new Version(2, 3, 0));
        config.setClassForTemplateLoading(Main.class, "/");

        ArrayList<Estudiante> listEstudiantes = new ArrayList<Estudiante>();
        Spark.get("/", ((request, response) -> {
            Template plantillaInicio = config.getTemplate("Templates/Inicio.ftl");
            StringWriter writer = new StringWriter();

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listEstudiantes", listEstudiantes);
            attributes.put("tamanoLista", listEstudiantes.size() > 0);
            plantillaInicio.process(attributes, writer);
            return writer;

        }));

        Spark.get("/Agregar", ((request, response) -> {
            Template plantillaInicio = config.getTemplate("Templates/agregarEstudiante.ftl");
            return plantillaInicio;
        }));

    }


}
