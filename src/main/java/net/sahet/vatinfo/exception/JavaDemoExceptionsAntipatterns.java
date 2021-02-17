package net.sahet.vatinfo.exception;

import java.io.FileInputStream;
import java.io.IOException;

class JavaDemoExceptionsAntipatterns {

	// Swallowing Exceptions
	public int getPlayerScore(String filePath) {
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(filePath);
		} catch (IOException e) {
			// this will never happen
		}
		return 0;
	}

	// Using return in a finally Block
	/**
	 * Another way to swallow exceptions is to return from the finally block. This
	 * is bad because, by returning abruptly, the JVM will drop the exception, even
	 * if it was thrown from by our code:
	 * 
	 * @param playerFile
	 * @return
	 */
	public int getPlayerScore2(String playerFile) {
		int score = 0;
		try {
			throw new IOException();
		} finally {
			return score; // <== the IOException is dropped
		}
	}
}