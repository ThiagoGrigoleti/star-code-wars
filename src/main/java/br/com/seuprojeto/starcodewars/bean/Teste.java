package br.com.seuprojeto.starcodewars.bean;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Teste {
    public static void main(String[] args){
        String url = "https://swapi.dev/api/planets/1/";
        try {
            //criar http client
            HttpClient client = HttpClient.newHttpClient();
            //criar http request
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            //enviar a req e esperar a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString())

            //ler o status da req pra saber se deu erro

            int statusCode = response.statusCode();
            System.out.println("Status: " + statusCode);

            //tratamento de erros
            if (statusCode == 200) {
                String body = response.body();
                System.out.println("Body: " + response.body());
            }
            if (statusCode != 200) {
                System.out.println("Erro na req");
            }

        } catch (Exception e){
            System.err.println();



        }
    }
}
