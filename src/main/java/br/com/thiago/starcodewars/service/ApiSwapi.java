package br.com.thiago.starcodewars.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class ApiSwapi {

    private static final String URL_BASE = "https://swapi.dev/api/planets/";

    public int buscarAparicoes(String nome) {
        try {
            String nomeEncoded = URLEncoder.encode(nome, StandardCharsets.UTF_8.toString());
            String urlString = URL_BASE + "?search=" + nomeEncoded;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder resposta = new StringBuilder();
                String linha;

                while ((linha = in.readLine()) != null) {
                    resposta.append(linha);
                }
                in.close();

                JsonObject obj = JsonParser.parseString(resposta.toString()).getAsJsonObject();
                JsonArray resultados = obj.getAsJsonArray("results");

                if (resultados != null && resultados.size() > 0) {
                    JsonObject planeta = resultados.get(0).getAsJsonObject();
                    JsonArray filmes = planeta.getAsJsonArray("films");
                    return filmes != null ? filmes.size() : 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro SWAPI: " + e.getMessage());
        }
        return 0;
    }
}