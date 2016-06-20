import java.io.*;

public class Main {
    public static final String LINE_FORMAT = "TAG POS=1 TYPE=INPUT:PASSWORD FORM=ID:loginform ATTR=ID:pwd CONTENT=%s\n" +
            "ONDIALOG POS=1 BUTTON=OK CONTENT=\n" +
            "TAG POS=1 TYPE=INPUT:BUTTON FORM=ID:loginform ATTR=ID:atjbtn\n";
    public static final long MAX_LIMIT = 50_0000L;

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("pass00.txt"));
             BufferedWriter bw_0 = new BufferedWriter(new FileWriter("imarco_00.txt"));
             BufferedWriter bw_1 = new BufferedWriter(new FileWriter("imarco_01.txt"));
             BufferedWriter bw_2 = new BufferedWriter(new FileWriter("imarco_02.txt"));
             BufferedWriter bw_3 = new BufferedWriter(new FileWriter("imarco_03.txt"));
             BufferedWriter bw_4 = new BufferedWriter(new FileWriter("imarco_04.txt"));
             BufferedWriter bw_5 = new BufferedWriter(new FileWriter("imarco_05.txt"));
        ) {
            BufferedWriter[] bws = {bw_0, bw_1, bw_2, bw_3, bw_4, bw_5};
            for (BufferedWriter bufferedWriter : bws) {
                br.lines().limit(MAX_LIMIT).forEach((line) -> {
                    try {
                        bufferedWriter.write(String.format(LINE_FORMAT, line));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
