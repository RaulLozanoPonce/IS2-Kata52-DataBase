package kata5p2.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReader {

    public List<Mail> read(String fileName) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(fileName);
        List<Mail> list;
        try (BufferedReader b = new BufferedReader(f)) {
            list = new ArrayList<>();
            while((cadena = b.readLine())!=null) {
                Mail m = new Mail(cadena);
                if (!m.getDomain().equals("")){
                    list.add(m);
                }
            }
        }
        return list;
    }
}
