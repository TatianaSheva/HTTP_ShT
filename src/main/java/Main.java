import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String SERVER = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        // Объект запроса
        HttpGet request = new HttpGet(SERVER);

        // Отправить запрос
        CloseableHttpResponse response = httpClient.execute(request);

        ObjectMapper mapper = new ObjectMapper();
        List<Cat> cats = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {
        });

        //Фильтруем список, возвращаем только те факты, у которых поле upvotes не равно null или нулю
        // Выводим результат на экран.
        cats.stream().filter(cat -> cat.getUpvotes() != null)
                .forEach(System.out::println);
    }
}
