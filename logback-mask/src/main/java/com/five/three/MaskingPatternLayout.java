package com.five.three;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class MaskingPatternLayout extends PatternLayout {
	
	private String patternsProperty;
	private Optional<Pattern> pattern;
	private char mask;

	public void setMask(String mask) {
		this.mask = mask.toCharArray()[0];
	}

	public String getPatternsProperty() {
		return patternsProperty;
	}

	public void setPatternsProperty(String patternsProperty) {
		this.patternsProperty = patternsProperty;
		if (this.patternsProperty != null) {
			this.pattern = Optional.of(Pattern.compile(patternsProperty, Pattern.MULTILINE));
		} else {
			this.pattern = Optional.empty();
		}
	}
	
	

	@Override
	public String doLayout(ILoggingEvent event) {
		final StringBuilder message = new StringBuilder(super.doLayout(event));

		if (pattern.isPresent()) {
			Matcher matcher = pattern.get().matcher(message);
			while (matcher.find()) {

				int group = 1;
				while (group <= matcher.groupCount()) {
					if (matcher.group(group) != null) {
						for (int i = matcher.start(group); i < matcher.end(group); i++) {
							message.setCharAt(i, this.mask);
						}
					}
					group++;
				}
			}
		}
		return message.toString();
	}

}