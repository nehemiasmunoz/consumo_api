package com.marvic;

import com.marvic.models.Book;
import com.marvic.models.Response;
import com.marvic.services.ConsumoApi;
import com.marvic.services.conversor.DataConversor;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "https://gutendex.com/books/";
        ConsumoApi apiConsumer = ConsumoApi.getInstance();
        String json = apiConsumer.getData(url);

        DataConversor dataConversor = new DataConversor();

        Response response = dataConversor.getData(json, Response.class);
        List<Book> books = response.books();

        while (true){
            showMenu();
            var option = getUserInput(null);
            switch (option){
                case "1":
                    String titulo = getUserInput("Ingrese el titulo:");
                    var result = books.stream()
                            .filter((book) -> book.title().toLowerCase().contains(titulo.toLowerCase()))
                            .findFirst();
                    if(result.isPresent()){
                        System.out.println("result = " + result.get());
                    }else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case "2":
                    int largo = Integer.parseInt( getUserInput("Ingrese el largo del top: "));
                    books.stream()
                            .sorted(Comparator.comparingInt(Book::downloadCount).reversed()) // ordenamos por cantidad de descargas
                            .limit(largo)
                            .forEach(System.out::println);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    return;
            }
        }

    }
    public static String getUserInput(String message){
        String option;
        Scanner scanner = new Scanner(System.in);
        if (message != null){
            System.out.println(message);
        }
        option = scanner.nextLine();
        return option;

    }

    public static void showMenu(){
        String menu = """
                1. Buscar libro por titulo.
                2. Ver top libros mas descargados.
                
                Ingresa una opcion:
                """;
        System.out.println(menu);
    }
}