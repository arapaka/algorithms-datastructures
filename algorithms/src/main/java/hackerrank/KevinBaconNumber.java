package hackerrank;

import java.util.*;

/**
 * Created by archithrapaka on 4/9/17.
 */
public class KevinBaconNumber {

    public static void findDistance(String actor1, String actor2,
                                    Map<String, Set<String>> movies, Map<String, Set<String>> actors) {

        Queue<String> queueActors = new LinkedList<>(); // queue of actos
        queueActors.add(actor1);

        Set<String> visitedActors = new HashSet<>();
        visitedActors.add(actor1); // start node
        Set<String> visitedMovies = new HashSet<>();
        int distance = 0;
        while (!queueActors.isEmpty()) {

            String actor = queueActors.poll();

            if (actor.equals(actor2)) {
                System.out.println(distance);
                return;
            }
            if (actors.containsKey(actor)) {
                Set<String> actorToMovies = actors.get(actor);

                for (String movie : actorToMovies) {
                    if (!visitedMovies.contains(movie)) {
                        visitedMovies.add(movie);
                        Set<String> movieToActors = movies.get(movie);
                        if (movieToActors != null) {
                            for (String s : movieToActors) {
                                if (!visitedActors.contains(s)) {
                                    visitedActors.add(s);
                                    queueActors.add(s);
                                }
                            }
                        }
                    }

                }
            }
            distance++;
        }

    }

    public static void main(String[] args) {
        Set<String> pawanMovies = new HashSet<>();
        pawanMovies.add("Panja");
        pawanMovies.add("Thammudu");
        pawanMovies.add("Jalsa");
        pawanMovies.add("ShankarDada");
        pawanMovies.add("Khushi");
        pawanMovies.add("GabbarSingh");

        Set<String> khushi = new HashSet<>();
        khushi.add("Pawan");
        khushi.add("Bhoomika");

        Set<String> sd = new HashSet<>();
        sd.add("Chiru");
        sd.add("somehindiactress");

        Set<String> athadu = new HashSet<>();
        athadu.add("Bhoomika");
        athadu.add("Mahesh");

        Set<String> jalsa = new HashSet<>();
        jalsa.add("Pawan");
        jalsa.add("Ilyana");

        Set<String> khaidi = new HashSet<>();
        khaidi.add("Chiru");
        khaidi.add("Kajal");

        Set<String> GS = new HashSet<>();
        GS.add("Kajal");
        GS.add("Pawan");

        Set<String> CHIRU = new HashSet<>();
        CHIRU.add("Khaidi");
        CHIRU.add("ShankarDada");

        Set<String> kajal = new HashSet<>();
        kajal.add("GabbarSingh");

        Set<String> bhoomika = new HashSet<>();
        bhoomika.add("Athadu");
        bhoomika.add("English");
        bhoomika.add("Khushi");


        Set<String> actors = new HashSet<>();
        actors.add("Chiru");
        actors.add("Pawan");
        actors.add("Mahesh");
        actors.add("Bhoomika");
        actors.add("Kajal");

        Map<String, Set<String>> actorsToMovies = new HashMap<>();
        actorsToMovies.put("Chiru", CHIRU);
        actorsToMovies.put("Pawan", pawanMovies);
        actorsToMovies.put("Bhoomika", bhoomika);
        actorsToMovies.put("Kajal", kajal);

        Map<String, Set<String>> moviesToActors = new HashMap<>();
        moviesToActors.put("Khushi", khushi);
        moviesToActors.put("ShankarDada", sd);
        moviesToActors.put("Khaidi", khaidi);
        moviesToActors.put("Jalsa", jalsa);
        moviesToActors.put("Athadu", athadu);
        moviesToActors.put("GabbarSingh", GS);

        findDistance("Chiru", "Bhoomika", moviesToActors, actorsToMovies);
    }
}
