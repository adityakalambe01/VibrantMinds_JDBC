package com;

import com.jap67.student_management_system.Configuration;
import com.jap67.student_management_system.CreateDatabase;
import com.jap67.student_management_system.CreateTables;
import com.jap67.student_management_system.Subjects;


public class App 
{
    public static void main( String[] args )
    {
        String newDatabaseName = "jap67_student_management_system";
        Configuration cfg = new Configuration(3306, "vmt", "root", "root");
        if (CreateDatabase.createNewDatabase(newDatabaseName, cfg)){
            System.out.println("Created database");
        }else {
            System.out.println("Database not created!!!");
        }

        cfg.setDatabaseName(newDatabaseName);

        if (CreateTables.createNewTables(cfg)){
            System.out.println("All Tables created successfully");
        }else {
            System.out.println("Tables not created!!!");
        }

//        Subjects.addSubjects(5,cfg);
    }
}
