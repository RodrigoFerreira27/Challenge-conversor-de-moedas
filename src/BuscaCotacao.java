import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCotacao {

    public Cotacao buscaValor(double valor) {
        URI cotacaoUri = URI.create("https://v6.exchangerate-api.com/v6/c0f127e01ce7e5c42ae012be/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(cotacaoUri)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui localizar a cotação.", e);
        }

        return new Gson().fromJson(response.body(), Cotacao.class);
    }
}