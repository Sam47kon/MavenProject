package StepikTasks.Stepik3.S3_5_3;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
