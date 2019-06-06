package StepikTasks.Stepik3.S3_5_3;

public class SpamAnalyzer extends KeywordAnalyzer {
    private final String[] keywords;

    SpamAnalyzer(String[] spamKeywords) {
        keywords = spamKeywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
