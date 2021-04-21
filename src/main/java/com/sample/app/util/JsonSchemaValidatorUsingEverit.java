package com.sample.app.util;

import javax.validation.ValidationException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class JsonSchemaValidatorUsingEverit {

	public static void validateAndPrint(String jsonPayload, String jsonSchema) {
		JSONObject jsonSchemaObj = new JSONObject(jsonSchema);
		JSONObject jsonPayloadObj = new JSONObject(jsonPayload);

		Schema schema = SchemaLoader.load(jsonSchemaObj);

		try {
			schema.validate(jsonPayloadObj);
			System.out.println("Valid json");
		} catch (ValidationException e) {
			e.printStackTrace();
		}

	}

}
