package basic.youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		Meeting[] meetings = new Meeting[cnt];
		for(int i = 0; i<cnt; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		List<Meeting> result = getSchedule(meetings);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		for(Meeting meeting : result)
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		System.out.println(sb.toString());
	}
	
	public static List<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> result = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		result.add(meetings[0]);
		int size = meetings.length;
		for(int i = 1; i<size; i++) {
			Meeting current = result.get(result.size()-1);
			if(current.end <= meetings[i].start)
				result.add(meetings[i]);
		}
		return result;
	}
	
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return end != o.end ? end-o.end:start-o.start;
		}
	}
}
