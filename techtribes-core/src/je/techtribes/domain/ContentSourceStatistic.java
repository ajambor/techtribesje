package je.techtribes.domain;

public class ContentSourceStatistic {

    private ContentSource contentSource;
    private int score;
    private double percentage;

    public ContentSourceStatistic(ContentSource contentSource) {
        this.contentSource = contentSource;
    }

    public ContentSource getContentSource() {
        return contentSource;
    }

    public int getScore() {
        return score;
    }

    public double getPercentage() {
        return percentage;
    }

    public void incrementScore() {
        this.score++;
    }

    public void calculatePercentage(int max) {
        this.percentage = (score/(double)max) * 100.0;
    }

}
