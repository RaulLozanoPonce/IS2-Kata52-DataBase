package kata5p2.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

public class Kata5P2 {
    
    private final String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    
    public Kata5P2(String fileName){
        this.fileName = fileName;
        mailList = new ArrayList<>();
    }
    
    public static void main(String[] args) throws IOException{
        Kata5P2 kata4 = new Kata5P2("email.txt");
        kata4.execute();
    }

    private void execute() throws IOException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        mailList = new MailListReader().read(fileName);
    }

    private void process() {
        histogram = new MailHistogramBuilder().build(mailList);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }
}