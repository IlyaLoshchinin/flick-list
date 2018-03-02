package com.bestflicklist.app.domain;


import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class ImdbParserChart {

  public static void main(String[] args) throws IOException {

    Connection conn = Jsoup.connect("http://www.imdb.com/chart/top");
    Document doc = conn.get();
    Elements elements = doc.select(".titleColumn > a");
    List<String> urls =
       elements.stream().map(el -> el.attr("abs:href")
            .split("/\\?")[0]).collect(Collectors.toCollection(ArrayList::new));

    System.out.println(urls);


  }


}
