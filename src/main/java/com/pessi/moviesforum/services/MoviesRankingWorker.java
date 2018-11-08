package com.pessi.moviesforum.services;

import com.google.gson.Gson;
import com.pessi.moviesforum.dto.SliderMovieData;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesRankingWorker {

    public static final String FILMWEB_RANKING_LINK = "http://www.filmweb.pl/ranking/film";

    public List<SliderMovieData> getSliderMovieData() {
        try {
            List<SliderMovieData> sliderMovieDataList = new ArrayList<>();
            Document document = getDocument(FILMWEB_RANKING_LINK);

            Elements moviePanels = document.select(".place");

            for (Element element : moviePanels) {
                sliderMovieDataList.add(new SliderMovieData(getImgLink(element), getName(element), getLink(element)));
            }

            return sliderMovieDataList;
        } catch (IOException exception) {
            return null;
        }
    }

    private Document getDocument(String url) throws IOException {
        Connection connection = Jsoup.connect(url);
        return connection.get();
    }

    private String getName(Element moviePanel) {
        return moviePanel.select(".film__link").text();
    }

    private String getLink(Element moviePanel) {
        return moviePanel.select(".film__link").attr("abs:href");
    }

    private String getImgLink(Element moviePanel) {
        String srcLink = moviePanel.select("img").attr("abs:src");

        if (!srcLink.isEmpty()) {
            return srcLink;
        } else {
            return moviePanel.select("img").attr("abs:data-src");
        }
    }

    public String getSliderMovieDataJSON() {
        Gson gson = new Gson();
        return gson.toJson(getSliderMovieData());
    }

}
