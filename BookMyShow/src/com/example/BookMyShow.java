package com.example;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;
import com.example.controller.*;
import com.example.model.*;
import com.example.service.*;

public class BookMyShow {
    public static final int NOOFUSERS = 10;
    private static final Object printLock = new Object();
    static Booking bookTicket(User user, MovieController movieController, TheaterController theaterController) throws InterruptedException{

        Random random = new Random();
        
        for(int i=0; i<5; i++) {

            synchronized(printLock) {
                System.out.println("User-"+user.getId()+" trying to book seat for "+i+"th time");
                System.out.flush();
            }
        
            List<Theater> theaters = theaterController.getAllTheaters(user.getCity());
            int noOfTheaters = theaters.size();
            int choosenTheater = random.nextInt(noOfTheaters);
            
            List<Show> allShows = theaters.get(choosenTheater).getAllShows();
            int noOfShows = allShows.size();
            int choosenShow = random.nextInt(noOfShows);

            List<Seat> seats = allShows.get(choosenShow).getAllSeats();
            int noOfSeats = seats.size();

            int choosenSeat = random.nextInt(noOfSeats);
            for(int j=0; j<3; j++) {
                if(seats.get(choosenSeat).isSeatBooked()==true) {
                    Thread.sleep(3000);
                    choosenSeat = random.nextInt(noOfSeats);
                }
            } 
            boolean isbooked = seats.get(choosenSeat).bookSeat();

            if(isbooked) {
                Booking bookingObj = new Booking(user, allShows.get(choosenShow), seats.get(choosenSeat), user.getCity(), theaters.get(choosenTheater));
                return bookingObj;
            }
            Thread.sleep(5000);
        }
        return null;
    }
    public static void main(String[] args) {
        AtomicInteger successfullBooking = new AtomicInteger(0);
        AtomicInteger failedBooking = new AtomicInteger(0);

        City kol_city = new City("Kolkata", "WB", "City1");
        City ben_city = new City("Bengaluru", "KA", "City2");
        City mum_city = new City("Mumbai", "MH", "City3");

        Movie mv1 = new Movie("Bahubali", "mv1");
        Movie mv2 = new Movie("HasiToFasi", "mv2");
        Movie mv3 = new Movie("Avatar", "mv3");
        Movie mv4 = new Movie("Titanic", "mv4");
        Movie mv5 = new Movie("Puratawn", "mv5");
        Movie mv6 = new Movie("Oporichito", "mv6");
        Movie mv7 = new Movie("Feluda", "mv7");
        Movie mv8 = new Movie("Bomkesh", "mv8");
        Movie mv9 = new Movie("Nana", "mv9");
        Movie mv10 = new Movie("Kantara", "mv10");
        Movie mv11 = new Movie("KGF", "mv11");

        // List<User> users[] = new ArrayList<>();
        User[] users = new User[NOOFUSERS]; 
        for(int i=0; i<NOOFUSERS; i++) {
            users[i] = new User("User-"+i, "MyNameUser"+i);
            if(i%3==0) users[i].updateCity(kol_city);
            else if(i%3==1) users[i].updateCity(mum_city);
            else users[i].updateCity(ben_city);
        }

        MovieController movieController = new MovieController();
        movieController.addNewCity(kol_city);
        movieController.addNewCity(mum_city);
        movieController.addNewCity(ben_city);
        movieController.addMovie(mum_city, mv1);
        movieController.addMovie(mum_city, mv2);
        movieController.addMovie(mum_city, mv3);
        movieController.addMovie(mum_city, mv4);

        movieController.addMovie(kol_city, mv5);
        movieController.addMovie(kol_city, mv6);
        movieController.addMovie(kol_city, mv7);
        movieController.addMovie(kol_city, mv8);

        movieController.addMovie(ben_city, mv9);
        movieController.addMovie(ben_city, mv10);
        movieController.addMovie(ben_city, mv11);

        Theater Mum_TH1 = new Theater("Mum_TH1", "Prithvi Theatre", mum_city);
        Screen mum_scr11 = Mum_TH1.addScreen();
        mum_scr11.addSeats(SeatCategory.SILVER, 2);
        Mum_TH1.addShow(mum_scr11, mv1, LocalDateTime.of(2026, 10, 12, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        Mum_TH1.addShow(mum_scr11, mv2, LocalDateTime.of(2026, 10, 13, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        
        Theater Mum_TH2 = new Theater("Mum_TH2", "PVR Icon", mum_city);
        Screen mum_scr21 = Mum_TH2.addScreen();
        mum_scr21.addSeats(SeatCategory.PLATINUM, 3);
        Mum_TH2.addShow(mum_scr21, mv3, LocalDateTime.of(2026, 10, 12, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        Mum_TH2.addShow(mum_scr21, mv4, LocalDateTime.of(2026, 10, 13, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));

        Theater Kol_TH1 = new Theater("Kol_TH1", "Star Theater", kol_city);
        Screen kol_scr11 = Kol_TH1.addScreen();
        kol_scr11.addSeats(SeatCategory.SILVER, 1);
        Kol_TH1.addShow(kol_scr11, mv5, LocalDateTime.of(2026, 10, 12, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        Kol_TH1.addShow(kol_scr11, mv6, LocalDateTime.of(2026, 10, 13, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));

        Theater Kol_TH2 = new Theater("Kol_TH2", "Nandan", kol_city);
        Screen kol_scr21 = Kol_TH2.addScreen();
        kol_scr21.addSeats(SeatCategory.SILVER, 4);
        Kol_TH2.addShow(kol_scr21, mv7, LocalDateTime.of(2026, 10, 12, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        Kol_TH2.addShow(kol_scr21, mv8, LocalDateTime.of(2026, 10, 13, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));


        Theater Ben_TH1 = new Theater("Ben_TH1", "Star Theater", ben_city);
        Screen ben_scr11 = Ben_TH1.addScreen();
        ben_scr11.addSeats(SeatCategory.GOLD, 3);
        Ben_TH1.addShow(ben_scr11, mv9, LocalDateTime.of(2026, 10, 12, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        Ben_TH1.addShow(ben_scr11, mv10, LocalDateTime.of(2026, 10, 13, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));


        Theater Ben_TH2 = new Theater("Ben_TH2", "Nandan", ben_city);
        Screen ben_scr21 = Ben_TH2.addScreen();
        ben_scr21.addSeats(SeatCategory.GOLD, 2);
        Ben_TH2.addShow(ben_scr21, mv9, LocalDateTime.of(2026, 10, 12, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));
        Ben_TH2.addShow(ben_scr21, mv11, LocalDateTime.of(2026, 10, 13, 12, 15, 0), LocalDateTime.of(2026, 10, 12, 14, 15, 0));


        TheaterController theaterController = new TheaterController();
        theaterController.addCity(mum_city);
        theaterController.addCity(kol_city);
        theaterController.addCity(ben_city);

        theaterController.addTheater(mum_city, Mum_TH1);
        theaterController.addTheater(mum_city, Mum_TH1);

        theaterController.addTheater(kol_city, Kol_TH1);
        theaterController.addTheater(kol_city, Kol_TH2);

        theaterController.addTheater(ben_city, Ben_TH1);
        theaterController.addTheater(ben_city, Ben_TH2);

        ExecutorService executor = Executors.newFixedThreadPool(NOOFUSERS); // or 100 if needed
        Future<Booking>[] futures = new Future[NOOFUSERS];

        for (int i = 0; i < NOOFUSERS; i++) {
            final int index = i; // effectively final for lambda
            futures[i] = executor.submit(() -> {
                return bookTicket(users[index], movieController, theaterController);
            });
        }

        // Retrieve and print results
        for (int i = 0; i < NOOFUSERS; i++) {
            final int index = i;
            futures[i] = executor.submit(() -> bookTicket(users[index], movieController, theaterController));
        }

        for (int i = 0; i < NOOFUSERS; i++) {
            try {
                Booking booking = futures[i].get();  // Waits until done
                synchronized (printLock) {
                    System.out.println("========");
                    if (booking != null) {
                        System.out.println("Booking confirmed: " + booking);
                        successfullBooking.incrementAndGet();  // thread-safe
                    } else {
                        System.out.println("Booking failed for user: " + users[i].getId() + " from city "+ users[i].getCity());
                        failedBooking.incrementAndGet();  // thread-safe
                    }
                    System.out.println("========");
                    System.out.flush();
                }
            } catch (Exception e) {
                synchronized (printLock) {
                    System.out.println("Error during booking for user: " + users[i].getId());
                    e.printStackTrace();
                }
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        System.out.println("Successful Booking: "+successfullBooking);
        System.out.println("Failed Booking: "+failedBooking);

    }
}
