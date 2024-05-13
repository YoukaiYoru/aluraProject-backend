import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda cambioDeMoneda(String primeraMoneda,String segundaMoneda,double monto) {
        String pMonedaMayuscula = primeraMoneda.toUpperCase();
        String sMonedaMayuscula = segundaMoneda.toUpperCase();
        String montoString = String.valueOf(monto);
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/94efd0181ce2582b8e97eee3/pair/"+pMonedaMayuscula+"/"+sMonedaMayuscula + "/"+montoString);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda.");
        }
    };
}
