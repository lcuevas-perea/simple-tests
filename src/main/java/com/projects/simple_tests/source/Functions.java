package com.projects.simple_tests.source;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Functions {

  private static final Logger logger
      = LoggerFactory.getLogger(Functions.class);

  void encode() {
    String text = "Can you still read this text?";
    String encoded = URLEncoder.encode(text, UTF_8);

    logger.info("encode: {}", encoded);

    //encoded: Can+you+still+read+this+text%3F
    String decoded = URLDecoder.decode(encoded, UTF_8);

    logger.info("decode: {}", decoded);
  }

  void decode() {
    String text = "Can you still read this text?";
    String encoded = Base64.getEncoder().encodeToString(text.getBytes(UTF_8));

    logger.info("encode: {}", encoded);

    // encoded: Q2FuIHlvdSBzdGlsbCByZWFkIHRoaXMgdGV4dD8=
    String decoded = new String(Base64.getDecoder().decode(encoded.getBytes(UTF_8)));

    logger.info("decode: {}", decoded);

  }


}
