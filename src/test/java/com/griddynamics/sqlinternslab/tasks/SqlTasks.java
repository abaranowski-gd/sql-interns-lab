package com.griddynamics.sqlinternslab.tasks;

import com.griddynamics.sqlinternslab.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTasks {
    /* Here is the Java Internship SQL Lab

       For each task type you query into the correct String variable like in the example;
       Then run corresponding test
       (just click on the green arrow on the left side, near "check method")
       to check you answer.

     */

    /*
    Example.

    Find the oldest movie title in the dataBase.
     */
    @Test
    void checkExample() {example();}
    private static final String E1 =
            "SELECT m.title FROM MOVIE m WHERE m.year = (SELECT MIN(year) FROM MOVIE);";



    /*
    Task 1.

    Find the titles of all movies directed by Steven Spielberg.
    */
    @Test
    void checkTask1() {task1();}
    private static final String T1 =
            "place you query here";

    /*
    Task 2.

    Find all years that have a movie
    that received a rating of 4 or 5, and sort them in increasing order.
    */
    @Test
    void checkTask2() {task2();}
    private static final String T2 =
            "place you query here";


    /*
    Task 3.

    Find the titles of all movies that have no ratings.
    */
    @Test
    void checkTask3() {task3();}
    private static final String T3 =
            "place you query here";

    /*
    Task 4.

    Some reviewers didn't provide a date with their rating.
    Find the names of all reviewers who have ratings with a NULL value for the date.
    */
    @Test
    void checkTask4() {task4();}
    private static final String T4 =
            "place you query here";

    /*
    Task 5.

    Write a query to return the ratings data in a more readable format:
    reviewer name, movie title, stars, and ratingDate.
    Also, sort the data, first by reviewer name, then by movie title,
    and lastly by number of stars.
    */
    @Test
    void checkTask5() {task5();}
    private static final String T5 =
            "place your query here";

    /*
    Task 6.

    For all cases where the same reviewer rated the same movie twice
    and gave it a higher rating the second time,
    return the reviewer's name and the title of the movie.
     */
    @Test
    void checkTask6() {task6();}
    private static final String T6 =
            "place you query here";


    /*
    Task 7.

    For each movie that has at least one rating,
    find the highest number of stars that movie received.
    Return the movie title and number of stars. Sort by movie title.
     */
    @Test
    void checkTask7() {task7();}
    private static final String T7 =
            "place your query here";


    /*
    Task 8.

    For each movie, return the title and the 'rating spread',
    that is, the difference between highest and lowest ratings given to that movie.
    Sort by rating spread from highest to lowest, then by movie title.
     */
    @Test
    void checkTask8() {task8();}
    private static final String T8 =
            "place your query here";

    /*
    Task 9.

    Some directors directed more than one movie.
    For all such directors, return the titles of all movies directed
    by them, along with the director name. Sort by director name, then movie title.
    (As an extra challenge, try writing the query both with and without COUNT.)
     */
    @Test
    void checkTask9() {task9();}
    private static final String T9 =
            "place you query here";

    /*
    Task 10.

    Find the titles of all movies not reviewed by Chris Jackson.
     */
    @Test
    void checkTask10(){task10();}
    private static final String T10 =
            "place your query here";




    private final JdbcTemplate template = new JdbcTemplate(new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:schema.sql")
            .addScript("classpath:data.sql")
            .build());

    private final BeanPropertyRowMapper<Movie> movieMapper = new BeanPropertyRowMapper<Movie>(Movie.class);


    void example() {

        SqlRowSet sqlRowSet = template.queryForRowSet(E1);

        List<String> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(sqlRowSet.getString(1));
        }

        List<String> expectedResult = Arrays.asList("Snow White");

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task1() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T1);

        List<String> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(sqlRowSet.getString(1));
        }

        List<String> expectedResult = Arrays.asList("E.T.", "Raiders of the Lost Ark");

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task2() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T2);

        List<Integer> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(sqlRowSet.getInt(1));
        }

        List<Integer> expectedResult = Arrays.asList(1937,
                1939,
                1981,
                2009);

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task3() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T3);

        List<String> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(sqlRowSet.getString(1));
        }

        List<String> expectedResult = Arrays.asList("Star Wars", "Titanic");

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task4() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T4);

        List<String> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(sqlRowSet.getString(1));
        }

        List<String> expectedResult = Arrays.asList("Daniel Lewis", "Chris Jackson");

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task5() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T5);

        List<List<Object>> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(Arrays.asList(
                    sqlRowSet.getString(1),
                    sqlRowSet.getString(2),
                    sqlRowSet.getString(3),
                    sqlRowSet.getString(4)
            ));
        }

        List<List<Object>> expectedResult = Arrays.asList(
                Arrays.asList("Ashley White", "E.T.", 3, "2011-01-02"),
                Arrays.asList("Brittany Harris", "Raiders of the Lost Ark", 2, "2011-01-30"),
                Arrays.asList("Brittany Harris", "Raiders of the Lost Ark", 4, "2011-01-12"),
                Arrays.asList("Brittany Harris", "The Sound of Music", 2, "2011-01-20"),
                Arrays.asList("Chris Jackson", "E.T.", 2, "2011-01-22"),
                Arrays.asList("Chris Jackson", "Raiders of the Lost Ark", 4, null),
                Arrays.asList("Chris Jackson", "The Sound of Music", 3, "2011-01-27"),
                Arrays.asList("Daniel Lewis", "Snow White", 4, null),
                Arrays.asList("Elizabeth Thomas", "Avatar", 3, "2011-01-15"),
                Arrays.asList("Elizabeth Thomas", "Snow White", 5, "2011-01-19"),
                Arrays.asList("James Cameron", "Avatar", 5, "2011-01-20"),
                Arrays.asList("Mike Anderson", "Gone with the Wind", 3, "2011-01-09"),
                Arrays.asList("Sarah Martinez", "Gone with the Wind", 2, "2011-01-22"),
                Arrays.asList("Sarah Martinez", "Gone with the Wind", 4, "2011-01-27")
        );

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult.toString(), result.toString());
    }

    void task6() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T6);

        List<List<Object>> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(Arrays.asList(
                    sqlRowSet.getString(1),
                    sqlRowSet.getString(2)
            ));
        }

        List<List<Object>> expectedResult = Arrays.asList(
                Arrays.asList("Sarah Martinez", "Gone with the Wind")
        );

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task7() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T7);

        List<List<Object>> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(Arrays.asList(
                    sqlRowSet.getString(1),
                    sqlRowSet.getString(2)
            ));
        }

        List<List<Object>> expectedResult = Arrays.asList(
                Arrays.asList("Avatar", 5),
                Arrays.asList("E.T.", 3),
                Arrays.asList("Gone with the Wind", 4),
                Arrays.asList("Raiders of the Lost Ark", 4),
                Arrays.asList("Snow White", 5),
                Arrays.asList("The Sound of Music", 3)
        );

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult.toString(), result.toString());
    }

    void task8() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T8);

        List<List<Object>> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(Arrays.asList(
                    sqlRowSet.getString(1),
                    sqlRowSet.getString(2)
            ));
        }

        List<List<Object>> expectedResult = Arrays.asList(
                Arrays.asList("Avatar", 2),
                Arrays.asList("Gone with the Wind", 2),
                Arrays.asList("Raiders of the Lost Ark", 2),
                Arrays.asList("E.T.", 1),
                Arrays.asList("Snow White", 1),
                Arrays.asList("The Sound of Music", 1)
        );

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult.toString(), result.toString());
    }

    void task9() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T9);

        List<List<Object>> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(Arrays.asList(
                    sqlRowSet.getString(1),
                    sqlRowSet.getString(2)
            ));
        }

        List<List<Object>> expectedResult = Arrays.asList(
                Arrays.asList("Avatar", "James Cameron"),
                Arrays.asList("Titanic", "James Cameron"),
                Arrays.asList("E.T.", "Steven Spielberg"),
                Arrays.asList("Raiders of the Lost Ark", "Steven Spielberg")
        );

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }

    void task10() {

        SqlRowSet sqlRowSet = template.queryForRowSet(T10);

        List<String> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(sqlRowSet.getString(1));
        }

        List<String> expectedResult = Arrays.asList(
                "Gone with the Wind",
                "Star Wars",
                "Titanic",
                "Snow White",
                "Avatar"
        );

        System.out.println("\nExpected Result:\n");
        expectedResult.forEach(System.out::println);
        System.out.println("\nYour Result:\n");
        result.forEach(System.out::println);

        assertEquals(expectedResult, result);
    }
}
