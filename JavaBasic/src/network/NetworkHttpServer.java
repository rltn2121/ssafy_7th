package network;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHttpServer {
	public static void main(String[] args) throws Exception{
		try(ServerSocket ss = new ServerSocket(8080)){
			System.out.print("------ 웹 서버 준비됨 ------"); // 서버 콘솔 출력
			
			while(true) {
				try(Socket socket = ss.accept()){
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
					
					String html = "<html><body><h1>Hello, SSAFY!! </h1></body></html>";
					bw.write("HTTP/1.1 200 OK \r\n");						// 1. start-line
					bw.write("Content-Type: text/html;charset=utf-8\r\n");	// 2. header
					bw.write("\r\n");										// 3. empty-line
					bw.write(html);											// 4. body
					bw.write("\r\n");
					bw.flush();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			
		}
		
	}
}
