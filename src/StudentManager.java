import java.io.BufferedReader;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

//    Read from file

    public void loadFromFile( String FileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4){
                    throw new IllegalArgumentException("Invalid data format");

                }

            }
        }
    }
}
