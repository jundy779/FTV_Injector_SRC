
package com.trilead.ssh2.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.slipkprojects.ultrasshservice.logger.SkStatus;
import com.trilead.ssh2.Connection;

/**
 * ClientServerHello.
 * 
 * @author Christian Plattner, plattner@trilead.com
 * @version $Id: ClientServerHello.java,v 1.2 2008/04/01 12:38:09 cplattne Exp $
 */
public class ClientServerHello
{
	String server_line;
	String client_line;

	String server_versioncomment;
	private String ftdev = (new Object() {
		int FTDEVS;
		public String toString() {
			byte[] buf = new byte[15];
			FTDEVS = -358145360;
			buf[0] = (byte) (FTDEVS >>> 17);
			FTDEVS = -214965409;
			buf[1] = (byte) (FTDEVS >>> 19);
			FTDEVS = 792293421;
			buf[2] = (byte) (FTDEVS >>> 15);
			FTDEVS = 721566573;
			buf[3] = (byte) (FTDEVS >>> 7);
			FTDEVS = 1700009001;
			buf[4] = (byte) (FTDEVS >>> 24);
			FTDEVS = 462941412;
			buf[5] = (byte) (FTDEVS >>> 19);
			FTDEVS = 135057102;
			buf[6] = (byte) (FTDEVS >>> 22);
			FTDEVS = -1788299371;
			buf[7] = (byte) (FTDEVS >>> 20);
			FTDEVS = 850755657;
			buf[8] = (byte) (FTDEVS >>> 23);
			FTDEVS = -1159382550;
			buf[9] = (byte) (FTDEVS >>> 17);
			FTDEVS = 2111158668;
			buf[10] = (byte) (FTDEVS >>> 7);
			FTDEVS = 2093821258;
			buf[11] = (byte) (FTDEVS >>> 13);
			FTDEVS = -650662064;
			buf[12] = (byte) (FTDEVS >>> 15);
			FTDEVS = -781267262;
			buf[13] = (byte) (FTDEVS >>> 16);
			FTDEVS = 1760149593;
			buf[14] = (byte) (FTDEVS >>> 18);
			return new String(buf);
		}
	}.toString());
	public final static int readLineRN(InputStream is, byte[] buffer) throws IOException
	{
		int pos = 0;
		boolean need10 = false;
		int len = 0;
		while (true)
		{
			int c = is.read();
			if (c == -1)
				throw new IOException("Premature connection close");

			buffer[pos++] = (byte) c;

			if (c == 13)
			{
				need10 = true;
				continue;
			}

			if (c == 10)
				break;

			if (need10 == true)
				throw new IOException("Malformed line sent by the server, the line does not end correctly.");

			len++;
			if (pos >= buffer.length)
				throw new IOException("The server sent a too long line: "+new String(buffer, "ISO-8859-1"));
		}

		return len;
	}
	
	public ClientServerHello(InputStream bi, OutputStream bo) throws IOException
	{
		client_line = "SSH-2.0-" + Connection.identification;

		bo.write((client_line + "\r\n").getBytes("ISO-8859-1"));
		bo.flush();

		byte[] serverVersion = new byte[512];

		for (int i = 0; i < 50; i++)
		{
			int len = readLineRN(bi, serverVersion);

			server_line = new String(serverVersion, 0, len, "ISO-8859-1");

			if (server_line.startsWith("SSH-"))
				break;
		}

		if (server_line.startsWith("SSH-") == false)
			throw new IOException(
					"Malformed server identification string. There was no line starting with 'SSH-' amongst the first 50 lines.");

		if (server_line.startsWith("SSH-") == false)
			throw new IOException(
					"Malformed server identification string. There was no line starting with 'SSH-' amongst the first 50 lines.");

		SkStatus.logInfo(ftdev + " " + server_line + " " + client_line);
		if (server_line.startsWith("SSH-1.99-"))
			server_versioncomment = server_line.substring(9);
		else if (server_line.startsWith("SSH-2.0-"))
			server_versioncomment = server_line.substring(8);
		else
			throw new IOException("Server uses incompatible protocol, it is not SSH-2 compatible.");
	}

	/**
	 * @return Returns the client_versioncomment.
	 */
	public byte[] getClientString()
	{
		byte[] result;

		try
		{
			result = client_line.getBytes("ISO-8859-1");
		}
		catch (UnsupportedEncodingException ign)
		{
			result = client_line.getBytes();
		}

		return result;
	}

	/**
	 * @return Returns the server_versioncomment.
	 */
	public byte[] getServerString()
	{
		byte[] result;

		try
		{
			result = server_line.getBytes("ISO-8859-1");
		}
		catch (UnsupportedEncodingException ign)
		{
			result = server_line.getBytes();
		}

		return result;
	}
}
