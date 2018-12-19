package com.five.three;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello Universe'");
		String messager = (String) exp.getValue();
		System.out.println(messager);
	}
}