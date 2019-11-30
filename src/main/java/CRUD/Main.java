package CRUD;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.Spark;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args){

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            port(Integer.parseInt(processBuilder.environment().get("PORT")));
        }else{
            port(8080);
        }

        staticFiles.location("/Templates");

        final Configuration config = new Configuration(new Version(2, 3, 0));
        config.setClassForTemplateLoading(Main.class, "/");

        ArrayList<Estudiante> listEstudiantes = new ArrayList<Estudiante>();
        Spark.get("/", (request, response) -> {
            Template plantillaInicio = config.getTemplate("Templates/Inicio.ftl");
            StringWriter writer = new StringWriter();

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listEstudiantes", listEstudiantes);
            attributes.put("tamanoLista", listEstudiantes.size() > 0);
            plantillaInicio.process(attributes, writer);
            return writer;

        });

        Spark.get("/Agregar", ((request, response) -> {
            Template plantillaInicio = config.getTemplate("Templates/agregarEstudiante.ftl");
            return plantillaInicio;
        }));

        Spark.post("/agregaralaListaEstudiantes", ((request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                listEstudiantes.add(new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono));
                response.redirect("/");

            }catch (Exception e){
                System.out.println(e);
                response.redirect("/Agregar");

            }
            return writer;

        }));

        Spark.get("/EliminarenListEstudiantes/:id", (request, response) -> {
            StringWriter writer = new StringWriter();
            int id = Integer.parseInt(request.params("id"));

            listEstudiantes.remove(id);
            response.redirect("/");
            return writer;

        });

        Spark.get("/Modificar/:id", (request, response) -> {
            Template resultTemplate = config.getTemplate("Templates/modificarEstudiante.ftl");
            StringWriter writer = new StringWriter();

            int id = Integer.parseInt(request.params("id"));

            Map<String, Object> attributos = new HashMap<>();
            attributos.put("Estudiante", listEstudiantes.get(id));

            resultTemplate.process(attributos, writer);
            return writer;

        });

        Spark.post("/ModificarenListEstudiantes", (request, response) -> {
            StringWriter writer = new StringWriter();

            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                Estudiante estudiante = new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono);
                for(Estudiante estud: listEstudiantes){
                    if(estud.getMatricula() == estudiante.getMatricula()) {
                        estud.setNombre(estudiante.getNombre());
                        estud.setApellido(estudiante.getApellido());
                        estud.setTelefono(estudiante.getTelefono());
                        estud.setMatricula(estudiante.getMatricula());
                        break;
                    }

                }
                response.redirect("/");

            }catch (Exception e){
                System.out.println("Error al modificar el estudiante: "+ e.toString());
                response.redirect("/");
            }
            return writer;


        });

        Spark.get("/VisualizarEstudiante/:id", ((request, response) -> {
            Template resultTemplate = config.getTemplate("Templates/verEstudiante.ftl");
            StringWriter writer = new StringWriter();

            int id = Integer.parseInt(request.params("id"));

            Map<String, Object> attributos = new HashMap<>();
            attributos.put("Estudiante", listEstudiantes.get(id));

            resultTemplate.process(attributos, writer);
            return writer;

        }));



    }


}

