package io.enscene.topophone.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.enscene.topophone.model.Footer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class test {

  @Test
  public void shouldSerializeToJson() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
    Footer tweet = Footer.of("");

    System.out.println(objectMapper.writeValueAsString(tweet));
    Assertions.assertThat(objectMapper.writeValueAsString(tweet)).isNotEmpty();
  }

}
