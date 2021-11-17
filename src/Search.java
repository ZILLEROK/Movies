import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    static boolean exist = false;
    static int movieId = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Actor> actorsList = new ArrayList<>();
        List<Writers> writersList = new ArrayList<>();

        List<Actor> actorsList1 = new ArrayList<>();
        List<Writers> writersList1 = new ArrayList<>();

        List<Movie> moviesList = new ArrayList<>();
        List<Genre> genreList = new ArrayList<>();
        List<Genre> genreList1 = new ArrayList<>();

        fillUp(sc, actorsList, writersList);

        System.out.println("Введите название фильма");
        moviesList.add(new Movie(sc.next(), genreList, actorsList, writersList));
        System.out.println("Введите название жанра");
        genreList.add(new Genre(sc.next()));


        fillUp(sc, actorsList1, writersList1);
        System.out.println("Введите название фильма");
        moviesList.add(new Movie(sc.next(), genreList1, actorsList1, writersList1));
        System.out.println("Введите название жанра");
        genreList1.add(new Genre(sc.next()));

        System.out.println("Для поиска введите название фильма");
        String movie = sc.next();

        for (int i = 0; i < moviesList.size(); i++) {
            if(moviesList.get(i).getName().equals(movie)){
                movieId = i;
                exist = true;
                break;
            }
        }
        if(exist){
            System.out.println(moviesList.get(movieId).getMovieInfo());
        }
        else System.out.println("Такого фильма нет");

    }

    private static void fillUp(Scanner sc, List<Actor> actorsList, List<Writers> writersList) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Введите имя актера");
            actorsList.add(new Actor(sc.next()));
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("Введите имя режиссера");
            writersList.add(new Writers(sc.next()));
        }
    }
}
class Actor{
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
class Movie{
    private String name;
    List<Genre> genreList;
    List<Actor> actorList;
    List<Writers> writersLink;
    public Movie(String name, List<Genre> genres, List<Actor> actors, List<Writers> writers) {
        this.name = name;
        this.genreList = genres;
        this.actorList = actors;
        this.writersLink = writers;
    }


    public String getMovieInfo(){
        return "Название фильма: " + name + "\n" + " Жанр: " + genreList.toString() +
                " Актеры: " + actorList.toString() + "\nСценаристы : " + writersLink.toString();
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genreList=" + genreList +
                ", actorList=" + actorList +
                ", writersLink=" + writersLink +
                '}';
    }
}

class Writers{
    private String name;

    public Writers(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'';
    }
}
class Genre{
    private String genres;
    public Genre(String genres) {
        this.genres = genres;
    }

    public String getGenre() {
        return genres;
    }

    @Override
    public String toString() {
        return "genre='" + genres + '\'';
    }
}

