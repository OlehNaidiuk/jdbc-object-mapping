package com.naidiuk.util;

public final class SqlQueries {
    public static final String FIND_ALL_YOUNGER_EIGHTEEN = "SELECT * FROM user WHERE age<18;";
    public static final String FIND_ALL_WHOSE_NAME_END_WITH_O = "SELECT * FROM user WHERE first_name LIKE '%o';";
    public static final String FIND_ALL_WHOSE_AGE_BETWEEN_EIGHTEEN_AND_SIXTY = "SELECT * FROM user WHERE age BETWEEN 18 AND 60;";
    public static final String FIND_ALL_WHOSE_NAME_CONTAINS_A = "SELECT * FROM user WHERE LOWER(first_name) LIKE '%a%';";
    public static final String FIND_ALL_ADULT = "SELECT * FROM user WHERE age>=18;";

    private SqlQueries() {
    }
}
