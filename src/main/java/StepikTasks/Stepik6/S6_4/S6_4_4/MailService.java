package StepikTasks.Stepik6.S6_4.S6_4_4;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Mail<T>> {
    private LinkedHashMap<String, List<T>> mailbox;

    public MailService() {
        mailbox = new LinkedHashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, Collections.emptyList());
            }
        };
    }

    public Map<String, List<T>> getMailBox() {
        return mailbox;
    }

    @Override
    public void accept(Mail<T> mail) {
        String to = mail.getTo();
        if (!mailbox.containsKey(to)) {
            mailbox.put(to, new ArrayList<>());
        }
        mailbox.get(to).add(mail.getContent());
    }
}
