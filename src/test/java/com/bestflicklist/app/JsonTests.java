package com.bestflicklist.app;

import static org.assertj.core.api.Assertions.assertThat;

import com.bestflicklist.app.domain.Genre;
import com.bestflicklist.app.domain.ImdbChartsDto;
import com.bestflicklist.app.domain.NodeChartDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Illia Loshchinin on 27.02.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTests {


  private JacksonTester<NodeChartDto> json;

  @Before
  public void setup() {
    ObjectMapper objectMapper = new ObjectMapper();
    JacksonTester.initFields(this, objectMapper);
  }


  @Test
  public void testDeserialize() throws Exception {
    String content = "{\"id\":\"tt12323\",\"ranking\":24,\"popularity\":25,\"genres_ranking\":[{\"genre\":\"Action\",\"order\":20}],\"user_voted\":32323,\"release_date\":2015}";

    NodeChartDto node = new NodeChartDto("tt12323", 24, 32323, 2015, 25);
    node.addGenresRanking(Genre.Action, 20);
    assertThat(this.json.parse(content))
        .isEqualToComparingFieldByFieldRecursively(node);
    assertThat(this.json.parseObject(content).getPopularity()).isEqualTo(25);
  }

  @Test
  public void jsonDto() {
    ObjectMapper mapper = new ObjectMapper();

    //For testin

    ImdbChartsDto root = new ImdbChartsDto();
    NodeChartDto node = new NodeChartDto("tt12323", 24, 32323, 2015, 25);
    node.addGenresRanking(Genre.Action, 20);
    root.getTop().getMovies().add(node);
    root.getMostRated().getTvShows().add(node);
    try {
      //Convert object to JSON string and save into file directly
      mapper.writeValue(new File("expected.json"), node);

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

  @Test
  public void testSerialize() throws Exception {
    NodeChartDto node = new NodeChartDto("tt12323", 24, 32323, 2015, 25);
    // Assert against a `.json` file in the same package as the test
    node.addGenresRanking(Genre.Action, 20);
    assertThat(this.json.write(node)).isEqualToJson(new File("expected.json"));
    // Or use JSON path based assertions
    assertThat(this.json.write(node)).hasJsonPathNumberValue("@.ranking");
    assertThat(this.json.write(node)).extractingJsonPathStringValue("@.id")
        .isEqualTo("tt12323");
  }
}
