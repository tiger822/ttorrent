package com.freestyle.common.log;

import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class ColorPatternLayout extends PatternLayout {

  public ColorPatternLayout(String pattern) {
    super(pattern);
  }

  @Override
  public String format(LoggingEvent event) {
    Level level = event.getLevel();
    String prefix = "\033[33m";
    String suffix = "\033[0m";
    switch (level.toInt()) {
      case Level.TRACE_INT:
        prefix = "\033[30m";
        break;
      case Level.DEBUG_INT:
        prefix = "\033[34m";
        break;
      case Level.INFO_INT:
        prefix = "\033[35m";
        break;
      case Level.WARN_INT:
        prefix = "\033[33m";
        break;
      case Level.ERROR_INT:
        prefix = "\033[31m";
        break;
    }
    return prefix + super.format(event) + suffix;
  }
}