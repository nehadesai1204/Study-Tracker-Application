STUDY TRACKER APPLICATION
-------------------------------------------------------------------

Author       : Neha Navin Desai
Date Created : 28/07/2025  
Language     : Java  
File Output  : Study.csv (for exported logs)  

DESCRIPTION
-------------------------------------------------------------------

Study Tracker is a Java-based console application designed to help students keep
a log of their daily study activities. The system allows users to:
- Record study logs with subject, duration, and description.
- Display all recorded logs.
- Summarize logs based on date or subject.
- Export logs into a CSV file for future use or sharing.

FEATURES
-------------------------------------------------------------------
1. **Insert New Log**
   - Records today's date automatically.
   - Prompts for subject name, duration (in hours), and a brief description.

2. **Display All Logs**
   - Lists all study entries in the format:
     ```
     YYYY-MM-DD | Subject | Duration | Description
     ```

3. **Summary by Date**
   - Aggregates and displays total study hours per day.

4. **Summary by Subject**
   - Aggregates and displays total study hours per subject.

5. **Export to CSV**
   - Exports all records to a file named `Study.csv` in the following format:
     ```
     Date,Subject,Duration,Description
     ```

6. **Exit**
   - Cleanly terminates the application.

REQUIREMENTS
-------------------------------------------------------------------
- Java Development Kit (JDK) 8 or above.
- A terminal or IDE that supports console input/output.


TECHNOLOGIES USED
-------------------------------------------------------------------
Language: Java
Packages & APIs:
java.util.* → Data structures (ArrayList, TreeMap), user input via Scanner.
java.time.LocalDate → Auto-captures the current date for study logs.
java.io.* → File handling and CSV export.

PROJECT FLOW
-------------------------------------------------------------------
1. Launch the application → Main Menu displayed
2. Choice 1: Insert new study log → User provides subject, duration, description → Date auto-generated.
3. Choice 2: Display all study logs stored in memory.
4. Choice 3: Display summary grouped by date (total hours per date).
5. Choice 4: Display summary grouped by subject (total hours per subject).
6. Choice 5: Export all study logs to MarvellousStudy.csv.
7. Choice 6: Exit application.

CLASSES AND RESPONSIBILITIES
-------------------------------------------------------------------

StudyLog

   Represents a single study session.
   Attributes: LocalDate date, String subject, double duration, String description.
   Methods: Constructor, getters, toString().


StudyTracker

   Manages all logs in memory.
   Acts as a controller for StudyLog database.
   Methods: InsertLog(), DisplayLog(), SummaryByDate(), SummaryBySubject(), ExportCSV().


StudyTrackerApp (Main Class)

   Contains main() method.
   Handles menu-driven interface and user input.
   Calls appropriate methods from StudyTracker.


EXAMPLE USAGE (CONSOLE FLOW)
-------------------------------------------------------------------
===== Marvellous Study Tracker =====
1. Insert Study Log
2. Display All Logs
3. Summary by Date
4. Summary by Subject
5. Export to CSV
6. Exit
Enter choice: 1

Enter Subject: Java Programming
Enter Duration (Hours): 2.5
Enter Description: Practiced ArraysList and TreeMap
Study log added successfully! (for date: 2025-09-13)
Sample Exported CSV (MarvellousStudy.csv)

Date, Subject, Duration, Description
2025-09-13, Java Programming, 2.5, Practiced ArraysList and TreeMap
2025-09-13, Database, 1.5, Solved SQL Joins
