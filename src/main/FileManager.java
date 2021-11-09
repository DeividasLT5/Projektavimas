package main;

import java.io.*;
import java.util.StringTokenizer;

public class FileManager {
    public void AddUser(User user, String userID) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt",true));

        bw.write(userID+","+user.getFirst_name()+","+user.getLast_name()+"," +user.getNumber()+
                ","+user.getEmail()+","+user.getAddress()+","+user.getPassword());
        bw.flush();
        bw.newLine();
        bw.close();
    }
    public void DeleteUserByID(String userID) throws IOException {
        String textLine;
        File tempDB = new File("users_temp.txt");
        File db = new File("users.txt");
        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );

        while( ( textLine = br.readLine() ) != null ) {
            if( textLine.contains(userID) )
                continue;
            bw.write(textLine);
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
        db.delete();
        tempDB.renameTo(db);
    }
    public void updateUserByID(User user, String userID) throws IOException {
        File db = new File("users.txt");
        File tempDB = new File("users_temp.txt");
        BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );
        BufferedReader br = new BufferedReader( new FileReader(db) );
        String record2;

        while( (record2 = br.readLine() ) != null ) {
            if(record2.contains(userID)) {
                bw.write(userID+","+user.getFirst_name()+","+user.getLast_name()+"," +user.getNumber()+
                        ","+user.getEmail()+","+user.getAddress()+","+user.getPassword());
            } else {
                bw.write(record2);
            }
            bw.flush();
            bw.newLine();
        }
        bw.close();
        br.close();
        db.delete();
        tempDB.renameTo(db);
    }
    public User SearchUserByID(String userID) throws IOException {
        String record;
        boolean found = false;
        User foundUser = new User();
        BufferedReader br = new BufferedReader( new FileReader("users.txt") );

        while( ( record = br.readLine() ) != null ) {
            StringTokenizer st = new StringTokenizer(record,",");
            if( record.contains(userID) ) {
                found = true;
                foundUser.setFirst_name(st.nextToken());
                foundUser.setLast_name(st.nextToken());
                foundUser.setNumber(st.nextToken());
                foundUser.setEmail(st.nextToken());
                foundUser.setAddress(st.nextToken());
                foundUser.setPassword(st.nextToken());
            }
        }
        br.close();
        if(found){
            return foundUser;
        }
        else return new User();
    }
}
