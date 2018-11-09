package kata5p2.view;

import java.util.List;
import kata5p2.model.Histogram;

public class MailHistogramBuilder {
    public Histogram<String> build(List<String> MailList){
        Histogram<String> histogram = new Histogram();
        for(String mail : MailList){
            histogram.increment(mail);
        }
        return histogram;
    }
}
