package kata5p2.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderBD;

public class Kata5P2 {
    
    private List<String> mailList;
    private Histogram<String> histogram;
    
    public Kata5P2(){
        mailList = new ArrayList<>();
    }
    
    public static void main(String[] args) throws IOException{
        Kata5P2 kata5p2 = new Kata5P2();
        kata5p2.execute();
    }

    private void execute() throws IOException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        mailList = new MailListReaderBD().read();
    }

    private void process() {
        histogram = new MailHistogramBuilder().build(mailList);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }
}