package com.greenfox.guardiansofthegalaxy.utils;

import org.springframework.http.MediaType;
import java.nio.charset.Charset;

public class TestUtils {

  public static final MediaType APP_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

}
