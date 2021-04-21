package com.sample.app.strings;

import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.sample.app.util.FileUtil;
import com.sample.app.util.JsonSchemaUtil;

public class Schema1Demo {
	private static final String JSON_PAYLOAD_PATH = "strings/example/schema1Content.json";
	private static final String JSON_SCHEMA_PATH = "strings/schema/schema1.json";

	public static void main(String args[]) throws ProcessingException, IOException {

		String jsonPayload = FileUtil.readFileContentFromClassPath(JSON_PAYLOAD_PATH);
		String jsonSchema = FileUtil.readFileContentFromClassPath(JSON_SCHEMA_PATH);

		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);
		
		System.out.println("\n\nValidating against invalid schema");
		String invalidPayloadFilePath =  "strings/example/schema1InvalidContent.json";
		jsonPayload = FileUtil.readFileContentFromClassPath(invalidPayloadFilePath);
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);
	}
}
