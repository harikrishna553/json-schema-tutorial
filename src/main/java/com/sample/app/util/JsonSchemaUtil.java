package com.sample.app.util;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

public class JsonSchemaUtil {
	private static final JsonValidator VALIDATOR = JsonSchemaFactory.byDefault().getValidator();
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static ProcessingReport validateJson(String jsonDocument, String jsonSchema)
			throws JsonMappingException, JsonProcessingException, ProcessingException {
		Map<String, Object> jsonPayloadMap = OBJECT_MAPPER.readValue(jsonDocument,
				new TypeReference<Map<String, Object>>() {
				});
		JsonNode jsonPayloadNode = OBJECT_MAPPER.convertValue(jsonPayloadMap, JsonNode.class);

		Map<String, Object> jsonSchemaMap = OBJECT_MAPPER.readValue(jsonSchema,
				new TypeReference<Map<String, Object>>() {
				});
		JsonNode jsonSchemaNode = OBJECT_MAPPER.convertValue(jsonSchemaMap, JsonNode.class);

		return VALIDATOR.validate(jsonSchemaNode, jsonPayloadNode);
	}

	public static void printProcessingReport(ProcessingReport processingReport) {
		Iterator<ProcessingMessage> itr = processingReport.iterator();

		while (itr.hasNext()) {
			ProcessingMessage message = itr.next();
			System.out.println(message.asJson().toPrettyString());

			JsonNode messageNode = message.asJson().get("message");

			if (messageNode != null) {
				System.out.println("Message " + messageNode.asText() + "\n\n");
			}

		}
	}

	public static void validateAndPrint(String jsonPayload, String jsonSchema)
			throws JsonMappingException, JsonProcessingException, ProcessingException {
		ProcessingReport processingReport = validateJson(jsonPayload, jsonSchema);

		if (processingReport.isSuccess()) {
			System.out.println("Json is valid against given json schema");
			return;
		}

		printProcessingReport(processingReport);
	}
}