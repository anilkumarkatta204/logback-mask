package com.five.three;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaskingPatternLayout extends PatternLayout {
	
	public @Nullable String mask;
	
	public @Nullable String patternsProperty;
	
	@Override
	public String doLayout(ILoggingEvent event) {
		// TODO Auto-generated method stub
		return (!StringUtils.isBlank(patternsProperty) && !StringUtils.isBlank(mask)) ?
                Stream.of(event.getMessage().split("\\s+"))
                .map(this::maskMessage)
                .collect(Collectors.joining(" "))
        : event.getMessage();
	}
	
	private String maskMessage(String event){
        Pattern pattern = Pattern.compile(patternsProperty);
        Matcher matcher = pattern.matcher(event);
        return (matcher.matches()) ?
                IntStream
                        .range(0, event.length())
                        .mapToObj(count -> mask)
                        .collect(Collectors.joining()) :
                event;
    }

}
