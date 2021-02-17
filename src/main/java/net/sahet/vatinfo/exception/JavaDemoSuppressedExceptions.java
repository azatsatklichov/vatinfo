package net.sahet.vatinfo.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class SuppressedExceptions {
	public static void main(String[] args) {
		try {
			// demoSuppressedException("C:\\apps\\settings.gradleee");
			// use Java 7 suppressed methods
			// demoAddSuppressedException2("C:\\apps\\settings.gradleee");

			//demoSuppressedException3("C:\\apps\\settings.gradleee");

			// Java 7 approach try-with-resource
			demoSuppressedException4("C:\\apps\\settings.gradleee");
		} catch (IOException e) {
			System.err.println("Ex!!! " + e.getMessage());
			// System.err.println("Suppressed exception: " + e.getSuppressed()[0]);
		}
	}

	public static void demoSuppressedException(String filePath) throws IOException {
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		} finally {
			fileIn.close();
		}
	}

	public static void demoAddSuppressedException2(String filePath) throws IOException {
		Throwable firstException = null;
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(filePath);
		} catch (IOException e) {
			firstException = e;
		} finally {
			try {
				fileIn.close();
			} catch (NullPointerException npe) {
				if (firstException != null) {
					npe.addSuppressed(firstException);
				}
				throw npe;
			}
		}
	}

	/**
	 * Just a validation check
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public static void demoSuppressedException3(String filePath) throws IOException {
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		} finally {
			if (fileIn != null)
				fileIn.close();
		}
	}

	/**
	 * Use Java 7 try-with-resource approach
	 * 
	 * <pre>
	 * Classes That Implement the AutoCloseable or Closeable Interface
	 * 
	See the Javadoc of the AutoCloseable and Closeable interfaces for a list of classes that implement either of 
	these interfaces. The Closeable interface extends the AutoCloseable interface. 
	
	The close method of the Closeable interface throws exceptions of type IOException
	
	 while the close method of the AutoCloseable interface throws exceptions of type Exception. 
	 
	 Consequently, subclasses of the AutoCloseable interface can override this behavior of the close 
	method to throw specialized exceptions, such as IOException, or no exception at all.
	 * </pre>
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public static void demoSuppressedException4(String filePath) throws IOException {
		try (FileInputStream fileIn = new FileInputStream(filePath);) {
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		}
	}
}