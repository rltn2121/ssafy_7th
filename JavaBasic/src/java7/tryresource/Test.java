package java7.tryresource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static void main(String[] args) throws IOException {
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		){
			String s = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
