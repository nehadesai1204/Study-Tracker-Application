////////////////////////////////////////////////////////////////////////
//
// Built-in Packages included in the project
//
////////////////////////////////////////////////////////////////////////

import java.time.LocalDate;
import java.util.*;
import java.io.*;

////////////////////////////////////////////////////////////////////////
//
//  class   :       StudyLog
//  Description :   This class is used to set the getter methods
//  Author  :       Sakshi Pankaj Borhade
//
////////////////////////////////////////////////////////////////////////

class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;
    
    // Constructor to initialize the private members of the class
    public StudyLog(LocalDate A, String B, double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }

    // Getter method
    public LocalDate getDate()
    {
        return Date;
    }

    // Getter method
    public String getSubject()
    {
        return Subject;
    }

    // Getter method
    public double getDuration()
    {
        return Duration;
    }

    // Getter method
    public String getDescription()
    {
        return Description;
    }
}

////////////////////////////////////////////////////////////////////////
//
//  class   :       StudyTracker
//  Description :   This class is used to insert,Display,Get Summary and export CSV file.
//  Author  :       Sakshi Pankaj Borhade
//
////////////////////////////////////////////////////////////////////////

class StudyTracker
{
    // Data structure to hold the data about study
    private ArrayList <StudyLog> Database = new ArrayList <StudyLog> ();

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     InsertLog
    //  Description :       It is used to insert one record of the study details
    //  Input :             It accepts nothing
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              28/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void InsertLog()
    {
        Scanner Scannerobj = new Scanner(System.in);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("----------Please enter the valid details of your study-------------");
        System.out.println("-------------------------------------------------------------------");

        LocalDate Dateobj = LocalDate.now();

        System.out.println("Please provide the name of subject like C/C++/Java/OS/DS");
        String sub = Scannerobj.nextLine();

        System.out.println("Enter the time period of your study in hours");
        double dur = Scannerobj.nextDouble();
        Scannerobj.nextLine();

        System.out.println("Please provide the description about the study for future reference");
        String desc = Scannerobj.nextLine();

        StudyLog Studyobj = new StudyLog(Dateobj, sub, dur, desc);

        Database.add(Studyobj);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("----------------Study log gets stored successfully-----------------");
        System.out.println("-------------------------------------------------------------------");
    }

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     DisplayLog
    //  Description :       It is used to display the records inserted
    //  Input :             It accepts nothing
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              28/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void DisplayLog()
    {
        System.out.println("-------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("-------------------------------------------------------------------");
            return;
        }
        
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------Log report from Study Tracker------------------------");
        System.out.println("-------------------------------------------------------------------");

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }

        System.out.println("-------------------------------------------------------------------");
    }

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     ExportCSV
    //  Description :       It is used to export the CSV file of the study details
    //  Input :             It accepts nothing
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              28/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void ExportCSV()
    {
        System.out.println("-------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to Export as database is empty");
            System.out.println("-------------------------------------------------------------------");
            return;
        }

        String FileName = "Study.csv";

        try(FileWriter fwobj = new FileWriter(FileName))
        {
            // Write CSV header
            fwobj.write("Date,Subject,Duration,Description\n");

            // Travel database
            for(StudyLog sobj : Database)
            {
                // Write each record in CSV
                fwobj.write(sobj.getDate() + ","+
                            sobj.getSubject().replace(","," ") + ","+
                            sobj.getDuration() + ","+
                            sobj.getDescription().replace(","," ") + "\n"
                );
            }

            System.out.println("-------------------------------------------------------------------");
            System.out.println("-------------------Log created successfully------------------------");
            System.out.println("-------------------------------------------------------------------");
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured while creating the CSV.");
            System.out.println("Report this issue to Study Tracker");
        }
    }

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     SummaryByDate
    //  Description :       It is used to get the Summary of study details by date
    //  Input :             It accepts nothing 
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              28/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void SummaryByDate()
    {
        System.out.println("-------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("-------------------------------------------------------------------");
            return;
        }
        
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------Summary by date from Study Tracker-------------------");
        System.out.println("-------------------------------------------------------------------");

        TreeMap <LocalDate, Double> tobj = new TreeMap <LocalDate, Double> ();

        LocalDate lobj = null;
        double d, old;

        // this for loop is used to add the time which was used for studying in a particular date
        for(StudyLog sobj : Database)
        {
            lobj= sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);

                tobj.put(lobj,d+old);
            }
            else
            {
                tobj.put(lobj,d);
            }
        }

        // Display the details as per date
        for(LocalDate ldobj : tobj.keySet())
        {
            System.out.println("Date : "+ldobj+" Total Study "+tobj.get(ldobj));
        }

        System.out.println("-------------------------------------------------------------------");
    
    }

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     SummaryBySubject
    //  Description :       It is used to get the study details summary by subject
    //  Input :             It accepts nothing
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              28/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void SummaryBySubject()
    {
        System.out.println("-------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("-------------------------------------------------------------------");
            return;
        }
        
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------Summary by Subject from Study Tracker----------------");
        System.out.println("-------------------------------------------------------------------");

        TreeMap <String, Double> tobj = new TreeMap <String, Double> ();

        double d, old;
        String s;

        // this for loop is used to add the time which was used for studying in a particular Subject
        for(StudyLog sobj : Database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);

                tobj.put(s,d+old);
            }
            else
            {
                tobj.put(s,d);
            }
        }

        // Display the details as per subject
        for(String str : tobj.keySet())
        {
            System.out.println("Subject : "+str+" Total Study "+tobj.get(str));
        }

        System.out.println("-------------------------------------------------------------------");
    
    }
    
}

////////////////////////////////////////////////////////////////////////
// 
// Entry Point Function 
//
////////////////////////////////////////////////////////////////////////

class StudyTrack   // StudyTrackerStarter
{
    public static void main(String A[])
    {
        StudyTracker stobj = new StudyTracker();
        Scanner Scannerobj = new Scanner(System.in);

        int iChoice = 0;

        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------Welcome to Study Tracker Application-----------------");
        System.out.println("-------------------------------------------------------------------");

        do
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("--------------Please select the appropriate option-----------------");
            System.out.println("-------------------------------------------------------------------");

            System.out.println("1 : Insert new study log into database");
            System.out.println("2 : View all study logs");
            System.out.println("3 : Summary of Study log by date");
            System.out.println("4 : Summary of study log by Subject");
            System.out.println("5 : Export study log to CSV file");
            System.out.println("6 : Exit the application");
            System.out.println("-------------------------------------------------------------------");


            iChoice = Scannerobj.nextInt();

            switch(iChoice)
            {
                case 1:                        //Insert new study log into database
                    stobj.InsertLog();

                    break;

                case 2:                         // View all study logs
                    stobj.DisplayLog();

                    break;

                case 3:                           // Summary of Study log by date
                    stobj.SummaryByDate();

                    break;

                case 4:                         //Summary of study log by Subject
                    stobj.SummaryBySubject();

                    break;

                case 5:                         //Export study log to CSV file
                    stobj.ExportCSV();

                    break;

                case 6:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("---------Thank you for using Study Tracker Application-------------");
                    System.out.println("-------------------------------------------------------------------");

                    break;

                default:
                    System.out.println("Please enter valid option");
            }

        }while(iChoice != 6);
    }
}