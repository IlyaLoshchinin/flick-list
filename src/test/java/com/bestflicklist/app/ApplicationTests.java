package com.bestflicklist.app;

import com.bestflicklist.app.domain.Genre;
import com.bestflicklist.app.domain.ImdbChartsDto;
import com.bestflicklist.app.domain.NodeChartDto;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import javax.xml.soap.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


  @Test
  public void contextLoads() {
    ObjectMapper mapper = new ObjectMapper();

    //For testin

    ImdbChartsDto root = new ImdbChartsDto();
    NodeChartDto tt12323 = new NodeChartDto("tt12323", 24, 32323, 2015, 25);
    tt12323.addGenresRanking(Genre.Action, 20);
    root.getTop().getMovies().add(tt12323);
    root.getMostRated().getTvShows().add(tt12323);
    try {
      //Convert object to JSON string and save into file directly
      //mapper.writeValue(new File("user.json"), user);

      //Convert object to JSON string
//		  String jsonInString = mapper.writeValueAsString(user);
//			System.out.println(jsonInString);

      //Convert object to JSON string and pretty print
      String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
      System.out.println(jsonInString);


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
