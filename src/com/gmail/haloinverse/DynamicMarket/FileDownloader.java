package com.gmail.haloinverse.DynamicMarket;

import java.io.*;
import java.net.*;

public class FileDownloader {
	final static int size=1024;

	public static boolean FileDownload(String fileAddress, String	localFileName, String destinationDir) {
		OutputStream os = null;
		URLConnection URLConn = null;
	
		// URLConnection class represents a communication link between the
		// application and a URL.
	
		InputStream is = null;
		try {
			URL fileUrl;
			byte[] buf;
			int ByteRead,ByteWritten=0;
			fileUrl= new URL(fileAddress);
			os = new BufferedOutputStream(new FileOutputStream(destinationDir+"/"+localFileName));
			//The URLConnection object is created by invoking the	
			// openConnection method on a URL.
	
			URLConn = fileUrl.openConnection();
			is = URLConn.getInputStream();
			buf = new byte[size];
			while ((ByteRead = is.read(buf)) != -1) {
				os.write(buf, 0, ByteRead);
				ByteWritten += ByteRead;
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				is.close();
				os.close();
			}
			catch (IOException e) {
					e.printStackTrace();
			}
		}
	} 
	public static boolean fileDownload(String fileAddress, String destinationDir) {
		boolean isok;
		// Find the index of last occurance of character ‘/’ and ‘.’.
	
		int lastIndexOfSlash =	fileAddress.lastIndexOf('/');
		int lastIndexOfPeriod = fileAddress.lastIndexOf('.');
	
		// Find the name of file to be downloaded from the address.
	
		String fileName=fileAddress.substring
		(lastIndexOfSlash + 1);
	
		// Check whether path or file name is given correctly.
		if (lastIndexOfPeriod >=1 && lastIndexOfSlash >= 0 && lastIndexOfSlash < fileAddress.length()) {
			isok = FileDownload(fileAddress,fileName,destinationDir);
			return isok;
		} else {
			return false;
		}
	}
/*	public static void main(String[] args)
	{
		// Check whether there are at least two arguments.
		if(args.length==2)
		{
			for (int i = 1; i < args.length; i++) {
			fileDownload(args[i],args[0]);
			}
		} else{
			System.err.println("Provide Destination directory path and file	names separated by space.");
		}
	}*/
}


