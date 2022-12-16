import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\iangr\\IdeaProjects\\TOR\\src\\2022-12-09-01-00-00-consensus.txt");
        File routerStatusFile = new File("C:\\Users\\iangr\\IdeaProjects\\TOR\\src\\routerStatus.txt");
        PrintWriter out = new PrintWriter(new FileWriter(routerStatusFile, true));
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String firstLineNeeded = "r ";
            String secondLineNeeded = "s ";
            while ((line = br.readLine()) != null) {
                if (line.startsWith(firstLineNeeded) ) {
                    System.out.println(line);
                    line.split(" ");
                    out.print(line.split(" ")[1]+ " " + line.split(" ")[6] + " " + line.split(" ")[7] + " " + line.split(" ")[8] + ";");

                }
                if (line.startsWith(secondLineNeeded)) {
                    System.out.println(line);
                    line.split(" ");
                    if (line.contains("Exit")) {
                        out.print(" Exit;");
                    }
                    if (line.contains("Guard")) {
                        out.print(" Guard;");
                    }
                    if (line.contains("HSDir")) {
                        out.print(" HSDir;");
                    }
                    out.println("");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
