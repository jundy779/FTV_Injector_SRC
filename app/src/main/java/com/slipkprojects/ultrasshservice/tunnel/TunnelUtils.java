package com.slipkprojects.ultrasshservice.tunnel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.slipkprojects.ultrasshservice.logger.SkStatus;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.io.OutputStream;
import java.io.IOException;
import androidx.collection.ArrayMap;
import java.util.Map;
import java.util.Enumeration;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.Inet4Address;
import java.util.regex.Matcher;
import java.util.Set;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.trilead.ssh2.transport.TransportManager;
import java.io.InputStream;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.*;

public class TunnelUtils
{
	public static Map<String, CharSequence> BBCODES_LIST;
	public static String s1 = (new Object() {
		int ftvpn;
		public String toString() {
			byte[] buf = new byte[23];
			ftvpn = 1345361821;
			buf[0] = (byte) (ftvpn >>> 9);
			ftvpn = 1709973524;
			buf[1] = (byte) (ftvpn >>> 24);
			ftvpn = 1405996883;
			buf[2] = (byte) (ftvpn >>> 19);
			ftvpn = -824707520;
			buf[3] = (byte) (ftvpn >>> 1);
			ftvpn = 115552157;
			buf[4] = (byte) (ftvpn >>> 11);
			ftvpn = -1146509433;
			buf[5] = (byte) (ftvpn >>> 4);
			ftvpn = 1102160602;
			buf[6] = (byte) (ftvpn >>> 15);
			ftvpn = 1510341958;
			buf[7] = (byte) (ftvpn >>> 22);
			ftvpn = 1205447047;
			buf[8] = (byte) (ftvpn >>> 2);
			ftvpn = -605851915;
			buf[9] = (byte) (ftvpn >>> 8);
			ftvpn = 2125717081;
			buf[10] = (byte) (ftvpn >>> 15);
			ftvpn = -1475978200;
			buf[11] = (byte) (ftvpn >>> 12);
			ftvpn = 1668255785;
			buf[12] = (byte) (ftvpn >>> 7);
			ftvpn = -105857168;
			buf[13] = (byte) (ftvpn >>> 15);
			ftvpn = -105850451;
			buf[14] = (byte) (ftvpn >>> 18);
			ftvpn = -442606943;
			buf[15] = (byte) (ftvpn >>> 18);
			ftvpn = 218779069;
			buf[16] = (byte) (ftvpn >>> 2);
			ftvpn = 169578913;
			buf[17] = (byte) (ftvpn >>> 11);
			ftvpn = 453839695;
			buf[18] = (byte) (ftvpn >>> 3);
			ftvpn = 2139452546;
			buf[19] = (byte) (ftvpn >>> 8);
			ftvpn = 714496515;
			buf[20] = (byte) (ftvpn >>> 6);
			ftvpn = 191709907;
			buf[21] = (byte) (ftvpn >>> 19);
			ftvpn = -1797716149;
			buf[22] = (byte) (ftvpn >>> 5);
			return new String(buf);
		}
	}.toString());

	public static String s2 = (new Object() {
		int ftvpn;
		public String toString() {
			byte[] buf = new byte[16];
			ftvpn = 1672132610;
			buf[0] = (byte) (ftvpn >>> 15);
			ftvpn = -688635441;
			buf[1] = (byte) (ftvpn >>> 2);
			ftvpn = -227171237;
			buf[2] = (byte) (ftvpn >>> 10);
			ftvpn = -1379247222;
			buf[3] = (byte) (ftvpn >>> 6);
			ftvpn = 216359021;
			buf[4] = (byte) (ftvpn >>> 21);
			ftvpn = -1871349837;
			buf[5] = (byte) (ftvpn >>> 23);
			ftvpn = -626867518;
			buf[6] = (byte) (ftvpn >>> 9);
			ftvpn = 454042989;
			buf[7] = (byte) (ftvpn >>> 22);
			ftvpn = -427451139;
			buf[8] = (byte) (ftvpn >>> 10);
			ftvpn = -2099308327;
			buf[9] = (byte) (ftvpn >>> 17);
			ftvpn = 6078034;
			buf[10] = (byte) (ftvpn >>> 14);
			ftvpn = -932630374;
			buf[11] = (byte) (ftvpn >>> 16);
			ftvpn = 1715089719;
			buf[12] = (byte) (ftvpn >>> 15);
			ftvpn = -2120025495;
			buf[13] = (byte) (ftvpn >>> 18);
			ftvpn = 1264956507;
			buf[14] = (byte) (ftvpn >>> 10);
			ftvpn = -809179;
			buf[15] = (byte) (ftvpn >>> 12);
			return new String(buf);
		}
	}.toString());
	public static String formatCustomPayload(String hostname, int port, String payload) {
		BBCODES_LIST = new ArrayMap<>();

		BBCODES_LIST.put("[method]", "CONNECT");
		BBCODES_LIST.put("[host]", hostname);
		BBCODES_LIST.put("[port]", Integer.toString(port));
		BBCODES_LIST.put("[host_port]", String.format("%s:%d", hostname, port));
		BBCODES_LIST.put("[protocol]", "HTTP/1.0");
		BBCODES_LIST.put("[ssh]", String.format("%s:%d", hostname, port));

		BBCODES_LIST.put("[crlf]", "\r\n");
		BBCODES_LIST.put("[cr]", "\r");
		BBCODES_LIST.put("[lf]", "\n");
		BBCODES_LIST.put("[lfcr]", "\n\r");
		
		// para corrigir bugs
		BBCODES_LIST.put("\\n", "\n");
		BBCODES_LIST.put("\\r", "\r");

		String ua = System.getProperty("http.agent");
		BBCODES_LIST.put("[ua]", ua == null ? "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36" : ua);
		
		if (!payload.isEmpty()) {
			for (String key : BBCODES_LIST.keySet()) {
				key = key.toLowerCase();
				payload = payload.replace(key, BBCODES_LIST.get(key));
			}
			
			// busca pôr palavras chaves inválidas
			/*Matcher matcher = Pattern.compile("\\[(.*?)\\]")
				.matcher(payload);
			
			while (matcher.find()) {
				String group = matcher.group(1).toLowerCase();
				
				Set<String> listKeys = BBCODES_LIST.keySet();
				listKeys.add("[rotate]");
				listKeys.add("[delay_split]");
				listKeys.add("[split]");
				
				if (!listKeys.contains(String.format("[%s]", group)) && !group.startsWith("rotate=")) {
					SkStatus.logWarning(String.format("<strong>Warning:</strong> [%s] não suportado", group));
				}
			}*/
			
			// add rotate e random
			payload = parseRandom(parseRotate(payload));
			
			SkStatus.logDebug("Payload: " + payload.replace("\n", "\\n").replace("\r", "\\r"));
		}
		
		return payload;
	}

	public static boolean injectSplitPayload(String requestPayload, OutputStream out) throws IOException {
		if (requestPayload.contains("[delay_split]")) {
			String[] split = requestPayload.split(Pattern.quote("[delay_split]"));

			for (int n = 0; n < split.length; n++) {
				String str = split[n];

				if (!injectSimpleSplit(str, out)) {
					try {
						out.write(str.getBytes("ISO-8859-1"));
					} catch (UnsupportedEncodingException e2) {
						out.write(str.getBytes());
					}
					out.flush();
				}
				
				// cria delay
				try {
					if (n != (split.length-1))
						Thread.sleep(1000);
				} catch(InterruptedException e) {}
			}

			return true;
		}
		else if (injectSimpleSplit(requestPayload, out)) {
			return true;
		}

		return false;
	}

	private static boolean injectSimpleSplit(String requestPayload, OutputStream out) throws IOException {
		if (requestPayload.contains("[split]")) {
			String[] split2 = requestPayload.split(Pattern.quote("[split]"));

			for (int i = 0; i < split2.length; i++) {
				try {
					out.write(split2[i].getBytes("ISO-8859-1"));
				} catch (UnsupportedEncodingException e2) {
					out.write(split2[i].getBytes());
				}
				out.flush();
			}

			return true;
		}

		return false;
	}
	
	
	/**
	* Rotate
	*/
	
	private static Map<Integer,Integer> lastRotateList = new ArrayMap<>();
	private static String lastPayload = "";
	
	public static String parseRotate(String payload) {
		Matcher match = Pattern.compile("\\[rotate=(.*?)\\]")
			.matcher(payload);
		
		// limpa dados quando a payload fôr alterada
		if (!lastPayload.equals(payload)) {
			restartRotateAndRandom();
			lastPayload = payload;
		}
		
		int i = 0;
		while (match.find()) {
			String group = match.group(1);

			String[] split = group.split(";");
			if (split.length <= 0) continue;
			
			int split_key;
			if (lastRotateList.containsKey(i)) {
				split_key = lastRotateList.get(i)+1;
				if (split_key >= split.length) {
					split_key = 0;
				}
			}
			else  {
				split_key = 0;
			}
			
			String host = split[split_key];
			
			payload = payload.replace(match.group(0), host);
			
			lastRotateList.put(i, split_key);
			
			i++;
		}
		
		return payload;
	}
	
	
	/**
	* Random
	*/
	
	//private static List<Integer> lastRandomHostsList = new ArrayList<>();
	
	// precisa melhorar
	public static String parseRandom(String payload) {
		Matcher match = Pattern.compile("\\[random=(.*?)\\]")
			.matcher(payload);

		int i = 0;
		while (match.find()) {
			String group = match.group(1);

			String[] split = group.split(";");
			if (split.length <= 0) continue;

			Random r = new Random();
			int split_key = r.nextInt(split.length);

			if (split_key >= split.length || split_key < 0) {
				split_key = 0;
			}

			String host = split[split_key];

			payload = payload.replace(match.group(0), host);
			
			i++;
		}

		return payload;
	}
	
	public static void restartRotateAndRandom() {
		lastRotateList.clear();
		//lastRandomHostsList.clear();
	}
	
	
	public static boolean isNetworkOnline(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
			.getSystemService(context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		
		return (networkInfo != null && networkInfo.isConnectedOrConnecting());
	}
	
	public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
					 .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
						 .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
						String sAddr = inetAddress.getHostAddress();
						
						return sAddr.toString();
                    }
                }
            }
        } catch (SocketException ex) {
            return "ERROR Obtaining IP";
        }
        return "No IP Available";
    }
	
	/*public static String getLocationIp(String ip) throws IOException {
		//String ipapihost = TransportManager.createInetAddress("")
			//.getHostAddress();
		
		URL ipapi = new URL("https://ipapi.co/"+ ip + "/country/");

		URLConnection conn = ipapi.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36");
		//conn.setRequestProperty("Host", ipapihost);

		InputStream input = conn.getInputStream();

		StringBuilder location = new StringBuilder();
		
		int len;
		while ((len = input.read()) != -1) {
			location.append((char) len);
		}
		
		try {
			input.close();
		} catch(IOException e){}

		return location.toString();
	}*/
	
	public static boolean isActiveVpn(Context mContext) {
		ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			Network network = cm.getActiveNetwork();
            NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
            
           return (capabilities!= null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN));
		}
		else {
			NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_VPN);
			
			return (info != null && info.isConnectedOrConnecting());
		}
	}
}
