package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.get;
import static spark.Spark.port;

public class SparkWebServer {

    public static void main(String... args) {
        port(getPort());
        get("/formulario", (req, res) -> {
            String htmlForm = "<form action='/calcular' method='get'>" +
                    "<label for='operacion'>Seleccione la operación:</label>" +
                    "<select name='operacion'>" +
                    "<option value='cos'>Coseno</option>" +
                    "<option value='sin'>Seno</option>" +
                    "<option value='palindrom'>Palíndromo</option>" +
                    "<option value='magnitude'>Magnitud</option>" +
                    "</select><br>" +
                    "Número (o Palíndromo), X (si es magnitud): <input type='text' name='valor'><br>" +
                    "Y (si es magnitud): <input type='text' name='valorY'><br>" +
                    "<input type='submit' value='Calcular'>" +
                    "</form>";
            return htmlForm;
        });
        get("/calcular", (req, res) -> {
            String operacion = req.queryParams("operacion");
            String valor = req.queryParams("valor");

            switch (operacion) {
                case "cos":
                    return ApplicationUtilService.getCos(valor);
                case "sin":
                    return ApplicationUtilService.getSin(valor);
                case "palindrom":
                    return ApplicationUtilService.isPalindrome(valor);
                case "magnitude":
                    String valorX = req.queryParams("valor");
                    String valorY = req.queryParams("valorY");
                    return ApplicationUtilService.getMagnitude(valorX, valorY);
                default:
                    return "Operación no válida";
            }
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
