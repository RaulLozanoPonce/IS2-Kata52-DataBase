package kata5p2.view;

import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;

public class MailHistogramBuilder {
    public Histogram<String> build(List<Mail> MailList){
        Histogram<String> histogram = new Histogram();
        for(Mail mail : MailList){
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
