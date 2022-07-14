import java.io.*;
import java.util.Scanner;
import java.util.HashSet;

public class Project {
    // Create Temp.csv and output. file.
    public static void Createfile() {
        try {
            File temp = new File("C:\\Users\\h\\Downloads\\Assessment\\temp\\Temp.csv");
            File output = new File("C:\\Users\\h\\Downloads\\Assessment\\output\\output.csv");
            if (temp.createNewFile()) {
                System.out.println(temp.getName());

            } else {
                System.out.println("File already exists.");

            }
            if (output.createNewFile()) {
                System.out.println(output.getName());

            } else {
                System.out.println("File is already exists.");

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    // Read data from data files.
    public static void readcsvusingscanner(String filepath) {
        try {
            Scanner sc = new Scanner(new File(filepath));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine().toString());

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    // Find duplicate records in csv file and elminting hashset
    private static void Findduplicate() {
        try {
            // PrintWriter object for output.csv
            PrintWriter pw = new PrintWriter("C:\\Users\\h\\Downloads\\Assessment\\temp\\Temp1.csv");

            // BufferedReader object for factbook.csv
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\h\\Downloads\\Assessment\\data\\factbook.csv"));

            String line = br.readLine();

            // set store unique values
            HashSet<String> hs = new HashSet<String>();

            // loop for each line of input.txt
            while (line != null) {
                // write only if not
                // present in hashset
                if (hs.add(line))
                    pw.println(line);

                line = br.readLine();

            }

            pw.flush();

            // closing resources
            br.close();
            pw.close();

            System.out.println("File operation performed successfully");
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        try {
            // PrintWriter object for output.csv
            PrintWriter pw = new PrintWriter("C:\\Users\\h\\Downloads\\Assessment\\temp\\Temp2.csv");

            // BufferedReader object for factbook.csv
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\h\\Downloads\\Assessment\\data\\factbook-2.csv"));

            String line = br.readLine();

            // set store unique values
            HashSet<String> hs = new HashSet<String>();

            // loop for each line of input.txt
            while (line != null) {
                // write only if not
                // present in hashset
                if (hs.add(line))
                    pw.println(line);

                line = br.readLine();

            }

            pw.flush();

            // closing resources
            br.close();
            pw.close();

            System.out.println("File operation performed successfully");
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        // merges two files into single file(temp)
    }

    public static void MergesTwofiles() {
        try {
            PrintWriter pw = new PrintWriter("C:\\Users\\h\\Downloads\\Assessment\\temp\\Temp.csv");

            // BufferedReader object for file1
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\h\\Downloads\\Assessment\\temp\\Temp1.csv"));

            String line = br.readLine();

            // loop to copy each line of
            // file1 to file3
            while (line != null) {
                pw.println(line);
                line = br.readLine();
            }

            br = new BufferedReader(new FileReader("C:\\Users\\h\\Downloads\\Assessment\\temp\\Temp2.csv"));

            line = br.readLine();

            // loop to copy each line of
            // file2 to file3
            while (line != null) {
                pw.println(line);
                line = br.readLine();
            }

            pw.flush();

            // closing resources
            br.close();
            pw.close();

            System.out.println("Successfully merged Temp1 and Temp2 into Temp");
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    // find average of column of temp file and save in output file
    public static void Averageoutput() {
        try {

            String splitby = ",";

            PrintWriter pw = new PrintWriter("C:\\Users\\h\\Downloads\\Assessment\\output\\output.csv");
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\h\\Downloads\\Assessment\\Temp\\Temp.csv"));
            String ln = br.readLine();
            String ln1 = br.readLine();
            String line = br.readLine();
            pw.println("Country , Average");
            while (line != null) {
                String[] arr = line.split(splitby);

                String line2 = arr[0];
                String avg = arr[1];

                pw.print(line2);
                pw.print(",");
                pw.println(avg);

                line = br.readLine();
            }
            System.out.println("Average calculated successfully");
            pw.flush();

            // closing resources
            br.close();
            pw.close();
            {

            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    public static void main(String[] args) {
        Createfile();
        readcsvusingscanner("C:\\Users\\h\\Downloads\\Assessment\\data\\factbook.csv");
        Findduplicate();
        MergesTwofiles();
        Averageoutput();
    }
}