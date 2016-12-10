package Test;

import DataBase.Database;

/**
 * Created by Titan on 10/12/2016.
 */
public class DbTest {

    public static void main(String[] args){
        System.out.print("Welcome to the DataBase of BAM\n");
        new DbTest();
    }
    private DbTest(){
        Database dbTest = new Database();
    }
}
