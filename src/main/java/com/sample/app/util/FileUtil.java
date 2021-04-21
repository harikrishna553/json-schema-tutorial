package com.sample.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

	public static String readFileContentFromClassPath(String filePath) throws IOException {
		try (InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(filePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
			String str = null;
			StringBuilder builder = new StringBuilder();

			while ((str = br.readLine()) != null) {
				builder.append(str);
			}
			return builder.toString();
		}
	}
}
