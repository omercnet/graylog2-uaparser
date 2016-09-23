package com.omercnet.graylog2.uaparser;

import ua_parser.Parser;
import ua_parser.Client;

import org.graylog.plugins.pipelineprocessor.EvaluationContext;
import org.graylog.plugins.pipelineprocessor.ast.expressions.Expression;
import org.graylog.plugins.pipelineprocessor.ast.functions.Function;
import org.graylog.plugins.pipelineprocessor.ast.functions.FunctionArgs;
import org.graylog.plugins.pipelineprocessor.ast.functions.FunctionDescriptor;
import org.graylog.plugins.pipelineprocessor.ast.functions.ParameterDescriptor;

import java.io.IOException;

public class UaParserFunction implements Function<Client> {

    public static final String NAME = "parse_ua";
    private static final String PARAM = "user_agent";

    @Override
    public Client evaluate(FunctionArgs functionArgs, EvaluationContext evaluationContext) {
        String uaString = valueParam.required(functionArgs, evaluationContext);
        Client c;
        try {
            Parser uaParser = new Parser();
             c = uaParser.parse(uaString);
        } catch (IOException e) {
            c = null;
        }
        return c;
    }

    @Override
    public Object preComputeConstantArgument(FunctionArgs functionArgs, String s, Expression expression) {
        return expression.evaluateUnsafe(EvaluationContext.emptyContext());
    }

    public FunctionDescriptor<Client> descriptor() {
        return FunctionDescriptor.<Client>builder()
                .name(NAME)
                .description("Returns a dictionary of a parsed user-agent")
                .params(valueParam)
                .returnType(Client.class)
                .build();
    }

    private final ParameterDescriptor<String, String> valueParam = ParameterDescriptor
            .string(PARAM)
            .description("The User-Agent string to parse")
            .build();
}
