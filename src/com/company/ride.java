package com.company;
/*
ID: weissgu1
LANG: JAVA
PROG: ride

****Will rework to use classes and/or one big loop. A challenge I had was using "newline" with the tokenizer.
*   USACO said it would be best to use tokenizer and bufferedWriter/Reader - so trying to learn using those.
Description - USACO "ride" challenge.

It is a well-known fact that behind every good comet is a UFO. These UFOs often
come to collect loyal supporters from here on Earth. Unfortunately, they only have room to pick up one group of
followers on each trip. They do, however, let the groups know ahead of time which will be picked up for each comet by a
clever scheme: they pick a name for the comet which, along with the name of the group, can be used to determine if it is
a particular group's turn to go (who do you think names the comets?). The details of the matching scheme are given
below; your job is to write a program which takes the names of a group and a comet and then determines whether the
group should go with the UFO behind that comet.

Both the name of the group and the name of the comet are converted into a number in the following manner: the final
number is just the product of all the letters in the name, where "A" is 1 and "Z" is 26. For instance, the group "USACO"
would be 21 * 19 * 1 * 3 * 15 = 17955. If the group's number mod 47 is the same as the comet's number mod 47, then you
need to tell the group to get ready!
(Remember that "a mod b" is the remainder left over after dividing a by b; 34 mod 10 is 4.)

Write a program which reads in the name of the comet and the name of the group and figures out whether according to
the above scheme the names are a match, printing "GO" if they match and "STAY" if not. The names of the groups and the
comets will be a string of capital letters with no spaces or punctuation, up to 6 characters long.
 */

import java.io.*;
import java.util.StringTokenizer;

class ride {

    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("rideIn.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rideOut.txt")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        /*Variable Comet to convert first line (comet name) into a value. Will take string and turn it into an array
        of letters, then convert those letters to their number on the ABC scale. 1-26
        */
        String Comet = st.nextToken();

        /*Solution for conversion of chars to numeric value found at
        http://stackoverflow.com/questions/8879714/how-to-get-numeric-position-of-alphabets-in-java
        ----Starts with taking the first token and converting it to a char array. Then the for loop runs through
            each char and converts them to a value. Then using ASCII values, converts those uppercase values
            into their respective 1-26 numeric value.
        ----90 comes from ASCII. The is where capital Z is. 65 is where capital A begins.
        */
        char[] ch = Comet.toCharArray();

        int cometModValue = 0;
        int j,k = 1;
        for (char c : ch) {
            int temp = (int)c;
            int temp_int = 64;

            if (temp<=90 & temp>=65) {
                j = (temp - temp_int);
                k= j * k;
            }
        } //System.out.println(k);

        int modComet = k % 47;
        //System.out.println(modComet);

        //New tokenizer to accomodate csv file. Using delimter of comma "," will go to next line.
        StringTokenizer stCSV = new StringTokenizer(f.readLine(), ",");

        //Variable for the group (next line).
        String Group = stCSV.nextToken();

        //See Description for Comet.toCharArray();
        int j2,k2 = 1;
        char[] chg = Group.toCharArray();
        for (char c : chg) {
            int temp = (int)c;
            int temp_int = 64;

            if (temp<=90 & temp>=65) {
                j2 = (temp - temp_int);
                k2= j2 * k2;
            }

        }

        int modGroup = k2 % 47;
        //System.out.println(modGroup);


        if (modComet == modGroup) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }



}


