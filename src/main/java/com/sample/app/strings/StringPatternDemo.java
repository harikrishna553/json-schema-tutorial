package com.sample.app.strings;

import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.sample.app.util.FileUtil;
import com.sample.app.util.JsonSchemaUtil;

public class StringPatternDemo {
	public static void main(String args[]) throws ProcessingException, IOException {

		String jsonSchemaFilePath = "strings/schema/stringPatternSchema.json";
		String jsonPayloadFilePath = "strings/example/stringPatternValidContent.json";

		String jsonPayload = FileUtil.readFileContentFromClassPath(jsonPayloadFilePath);
		String jsonSchema = FileUtil.readFileContentFromClassPath(jsonSchemaFilePath);

		System.out.println("Validating against valid schema content");
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);

		System.out.println("\n\nValidating against invalid content from stringPatternInvalidValidContent1.json");
		String invalidPayloadFilePath = "strings/example/stringPatternInvalidValidContent1.json";
		jsonPayload = FileUtil.readFileContentFromClassPath(invalidPayloadFilePath);
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);

		System.out.println("\n\nValidating against invalid content from stringPatternInvalidValidContent2.json");
		invalidPayloadFilePath = "strings/example/stringPatternInvalidValidContent2.json";
		jsonPayload = FileUtil.readFileContentFromClassPath(invalidPayloadFilePath);
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);
	}
}
