package net.dds.infrastructure.api.moviereview;

public class Result {

    public String display_title;
    public String mpaa_rating;
    public Integer critics_pick;
    public String byline;
    public String headline;
    public String summary_short;
    public String publication_date;
    public String opening_date;
    public String date_updated;
    public Link link;
    public String multimedia;

    public String buildResponse() {
        return "Title: " + display_title + "\n" +
           "MPA Rating" + mpaa_rating + "\n" +
           "Summary" + summary_short + "\n" +
           "Review Link" + link.url + "\n";
    }

}