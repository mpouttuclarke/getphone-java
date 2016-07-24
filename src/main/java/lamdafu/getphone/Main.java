package lamdafu.getphone;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.re2j.Matcher;
import com.google.re2j.Pattern;

public class Main {

	public static void main(String[] args) throws Exception {
		Matcher m = Pattern
				.compile(
						"(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?")
				.matcher("");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in),
				1024 * 1024);
		String line = null;
		while ((line = in.readLine()) != null) {
			m.reset(line);
			if (m.find()) {
				System.out.print(line);
				System.out.print("\t");
				int actual = 0;
				int groupCount = m.groupCount();
				for (int x = 1; x < groupCount; x++) {
					String group = m.group(x);
					if (group == null) {
						continue;
					}
					if (actual++ > 0) {
						System.out.print("-");
					}
					System.out.print(group);
				}
				System.out.println();
			}
		}
	}

}
