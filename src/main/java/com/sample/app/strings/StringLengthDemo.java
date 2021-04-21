package com.sample.app.strings;

import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.sample.app.util.FileUtil;
import com.sample.app.util.JsonSchemaUtil;

public class StringLengthDemo {

	public static void main(String args[]) throws ProcessingException, IOException {

		String jsonSchemaFilePath = "strings/schema/stringLengthSchema.json";
		String jsonPayloadFilePath = "strings/example/stringLengthValidContent.json";

		String jsonPayload = FileUtil.readFileContentFromClassPath(jsonPayloadFilePath);
		String jsonSchema = FileUtil.readFileContentFromClassPath(jsonSchemaFilePath);

		System.out.println("\n\nValidating against valid schema content");
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);

		System.out.println("\n\nValidating against invalid content from stringLengthInvalidContent1.json");
		String invalidPayloadFilePath = "strings/example/stringLengthInvalidContent1.json";
		jsonPayload = FileUtil.readFileContentFromClassPath(invalidPayloadFilePath);
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);

		System.out.println("\n\nValidating against invalid content from stringLengthInvalidContent2.json");
		invalidPayloadFilePath = "strings/example/stringLengthInvalidContent2.json";
		jsonPayload = FileUtil.readFileContentFromClassPath(invalidPayloadFilePath);
		JsonSchemaUtil.validateAndPrint(jsonPayload, jsonSchema);
		
	}
}
